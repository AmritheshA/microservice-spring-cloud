package com.microservice.currencyconversionservice.FeignProxy;

import com.microservice.currencyconversionservice.Responce.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyConversion getCurrencyExchanger(@PathVariable String from,
                                                   @PathVariable String to);
}
