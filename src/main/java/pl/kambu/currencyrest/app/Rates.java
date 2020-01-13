package pl.kambu.currencyrest.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rates {
    private String no;
    private String date;
    private String bidRate;
    private String askRate;


    public Rates(@JsonProperty("no") String no, @JsonProperty("effectiveDate") String date, @JsonProperty("bid") String bidRate, @JsonProperty("ask") String askRate) {
        this.no = no;
        this.date = date;
        this.bidRate = bidRate;
        this.askRate = askRate;
    }

    public String getNo() {
        return no;
    }

    public String getDate() {
        return date;
    }

    public String getBidRate() {
        return bidRate;
    }

    public String getAskRate() {
        return askRate;
    }
}
