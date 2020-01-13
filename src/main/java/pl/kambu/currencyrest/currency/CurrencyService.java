package pl.kambu.currencyrest.currency;

import org.springframework.stereotype.Service;
import pl.kambu.currencyrest.app.RatesResponse;

import java.util.List;


@Service
public class CurrencyService {
    private CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> listAll() {
        return currencyRepository.findAll();
    }

    public boolean isEmpty() {
        return currencyRepository.count() == 0;
    }

    public Currency findByCode(String code) {
        return currencyRepository.findByCode(code);
    }

    public void createRepository() {
        currencyRepository.save(new Currency("USD", "United States Dollar"));
        currencyRepository.save(new Currency("CAD", "Canadian Dollar"));
        currencyRepository.save(new Currency("EUR", "Euro"));
        currencyRepository.save(new Currency("CZK", "Czech Republic Koruna"));
        currencyRepository.save(new Currency("CHF", "Swiss Franc"));
    }

    public void save(Currency currency) {
        currencyRepository.save(currency);
    }

    public void setCurrencyRates(Currency currency, RatesResponse rate) {
        currency.setBid(rate.getBid());
        currency.setAsk(rate.getAsk());
        save(currency);
    }
}
