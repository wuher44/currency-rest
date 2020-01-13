package pl.kambu.currencyrest.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.JacksonObjectMapper;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

@Service
public class NbpClient {
    public RatesResponse getRates(String currencyCode) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);

        Unirest.config().setObjectMapper(new JacksonObjectMapper(mapper));

        NbpResponse response = Unirest.get("http://api.nbp.pl/api/exchangerates/rates/c/" + currencyCode)
                .asObject(NbpResponse.class)
                .getBody();

        return new RatesResponse(response.getBidRate(), response.getAskRate());
    }
}
