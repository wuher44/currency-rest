package pl.kambu.currencyrest.exchangeResp;

import pl.kambu.currencyrest.currency.Currency;

import javax.persistence.*;

@Entity
@Table(name = "exchange_response")
public class ExchangeResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String amount;
    @OneToOne
    @JoinColumn
    private Currency fromCurrency;
    @OneToOne
    @JoinColumn
    private Currency toCurrency;
    private double exchangeResult;


    public ExchangeResponse() {
    }

    public ExchangeResponse(String amount, Currency fromCurrency, Currency toCurrency, double exchangeResult) {
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.exchangeResult = exchangeResult;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getExchangeResult() {
        return exchangeResult;
    }

    public void setExchangeResult(double exchangeResult) {
        this.exchangeResult = exchangeResult;
    }
}
