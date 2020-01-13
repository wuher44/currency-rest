package pl.kambu.currencyrest.app;

public class RatesResponse {
    private double bid;
    private double ask;

    public RatesResponse(double bid, double ask) {
        this.bid = bid;
        this.ask = ask;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }
}
