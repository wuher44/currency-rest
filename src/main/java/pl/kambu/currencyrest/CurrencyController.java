package pl.kambu.currencyrest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kambu.currencyrest.app.NbpClient;
import pl.kambu.currencyrest.app.RatesResponse;
import pl.kambu.currencyrest.currency.Currency;
import pl.kambu.currencyrest.currency.CurrencyService;
import pl.kambu.currencyrest.exchangeResp.ExchangeResponse;
import pl.kambu.currencyrest.exchangeResp.ExchangeResponseService;
import pl.kambu.currencyrest.logging.LoggerService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class CurrencyController {

    private final NbpClient nbpClient;
    private final ExchangeResponseService exchangeResponseService;
    private final CurrencyService currencyService;
    private final LoggerService loggerService;

    public CurrencyController(NbpClient nbpClient, ExchangeResponseService exchangeResponseService, CurrencyService currencyService, LoggerService loggerService) {
        this.nbpClient = nbpClient;
        this.exchangeResponseService = exchangeResponseService;
        this.currencyService = currencyService;
        this.loggerService = loggerService;
    }

    @GetMapping("/start")
    String hello() throws UnknownHostException {

        loggerService.toLog("/start");

        return "hello!";
    }

    @GetMapping(value = "/currencies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Currency> list() throws UnknownHostException {

        List<Currency> currList = currencyService.listAll();
        for (Currency c : currList) {
            RatesResponse rate = nbpClient.getRates(c.getCode());

            currencyService.setCurrencyRates(c, rate);

        }
        loggerService.toLog("currencies");


        return currencyService.listAll();
    }

    @GetMapping(value = "/exchange", produces = MediaType.APPLICATION_JSON_VALUE)
    public ExchangeResponse getExchangeCost(@RequestParam String amount, @RequestParam String from, @RequestParam String to) throws UnknownHostException {

        RatesResponse f = nbpClient.getRates(from);
        RatesResponse t = nbpClient.getRates(to);

        Currency fromCurrency = currencyService.findByCode(from);
        currencyService.setCurrencyRates(fromCurrency, f);
        Currency toCurrency = currencyService.findByCode(to);
        currencyService.setCurrencyRates(toCurrency, t);

        ExchangeResponse exchangeResponse = new ExchangeResponse(amount, fromCurrency, toCurrency, calc(amount, fromCurrency, toCurrency));
        exchangeResponseService.create(exchangeResponse);
        loggerService.toLog("/exchange?amount=" + amount + "&from=" + from + "&to=" + to);

        return exchangeResponse;
    }


    private double calc(String amount, Currency fromCurrency, Currency toCurrency) {

        double result = Double.parseDouble(amount.replaceFirst(",", ".")) * fromCurrency.getBid() / toCurrency.getAsk();

        BigDecimal bd = new BigDecimal(Double.toString(result));
        bd = bd.setScale(4, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }
}

