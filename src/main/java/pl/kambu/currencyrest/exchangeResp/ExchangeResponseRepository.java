package pl.kambu.currencyrest.exchangeResp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ExchangeResponseRepository extends CrudRepository<ExchangeResponse, Long> {
    List<ExchangeResponse> findAll();
}
