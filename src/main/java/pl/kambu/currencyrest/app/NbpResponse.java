package pl.kambu.currencyrest.app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NbpResponse {

    private String table;
    private String currency;
    private String code;
    private Rates[] rates;


    @JsonCreator
    public NbpResponse(@JsonProperty("table") String table, @JsonProperty("currency") String currency, @JsonProperty("code") String code, @JsonProperty("rates") Rates[] rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public Rates[] getRates() {
        return rates;
    }

    public double getBidRate() {
        return Double.parseDouble(rates[0].getBidRate());
    }

    public double getAskRate() {
        return Double.parseDouble(rates[0].getAskRate());
    }
}
