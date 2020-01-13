package pl.kambu.currencyrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.kambu.currencyrest.currency.CurrencyService;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private CurrencyService currencyService;

    @Autowired
    public DatabaseLoader(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public void run(ApplicationArguments args) {
        if (currencyService.isEmpty()) {
            currencyService.createRepository();
        }

    }
}
