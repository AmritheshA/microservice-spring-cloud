package com.microservice.currencyexchangeservice.Controller;

import com.microservice.currencyexchangeservice.Repo.ResponseRepo;
import com.microservice.currencyexchangeservice.Responce.ExchangeCurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ExchangeController {

    @Autowired
    private Environment environment;
    @Autowired
    private ResponseRepo repo;

    @GetExchange("/currency-exchange/{from}/to/{to}")
    public ExchangeCurrencyResponse getCurrencyExchanger(@PathVariable String from,
                                                         @PathVariable String to) {

        ExchangeCurrencyResponse exchangeCurrencyResponse = repo.findByFromAndTo(from,to);

        if(exchangeCurrencyResponse == null) throw new NullPointerException("Cannot Found Resource");

        String env = environment.getProperty("local.server.port");

        exchangeCurrencyResponse.setEnvironment(env);

        return exchangeCurrencyResponse;
    }
}
