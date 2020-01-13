package pl.kambu.currencyrest.exchangeResp;

import org.springframework.stereotype.Service;

@Service
public class ExchangeResponseService {
    ExchangeResponseRepository exchangeResponseRepository;

    public ExchangeResponseService(ExchangeResponseRepository exchangeResponseRepository) {
        this.exchangeResponseRepository = exchangeResponseRepository;
    }

    public void create(ExchangeResponse exchangeResponse) {
        exchangeResponseRepository.save(exchangeResponse);
    }
}
