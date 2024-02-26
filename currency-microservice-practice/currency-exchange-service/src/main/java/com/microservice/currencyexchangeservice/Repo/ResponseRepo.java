package com.microservice.currencyexchangeservice.Repo;

import com.microservice.currencyexchangeservice.Responce.ExchangeCurrencyResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepo extends JpaRepository<ExchangeCurrencyResponse, Long> {
    ExchangeCurrencyResponse findByFromAndTo(String from, String to);
}
