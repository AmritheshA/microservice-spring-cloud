package com.microservice.currencyconversionservice.Controller;

import com.microservice.currencyconversionservice.FeignProxy.CurrencyExchangeProxy;
import com.microservice.currencyconversionservice.Responce.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.GetExchange;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    //By using REST template
    @GetMapping("/currency-conversion/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversion(@PathVariable String from,
                                                    @PathVariable String to,
                                                    @PathVariable BigDecimal quantity) {

        HashMap<String, String> pathVariables = new HashMap<>();
        pathVariables.put("from", from);
        pathVariables.put("to", to);

        CurrencyConversion response = new RestTemplate().getForEntity
                ("http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyConversion.class, pathVariables).getBody();

        return new CurrencyConversion(response.getId(), from, to, quantity, response.getConversionValue(), quantity.multiply(response.getConversionValue()),response.getEnvironment());
    }

    // By Using Feign Client
    @GetMapping("/currency-conversion-feign/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getCurrencyConversionFeign(@PathVariable String from,
                                                    @PathVariable String to,
                                                    @PathVariable BigDecimal quantity) {


        CurrencyConversion response = proxy.getCurrencyExchanger(from,to);

        return new CurrencyConversion(response.getId(), from, to, quantity, response.getConversionValue(), quantity.multiply(response.getConversionValue()),response.getEnvironment());
    }

}
