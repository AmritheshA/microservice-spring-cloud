package com.microservice.currencyexchangeservice.Responce;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class ExchangeCurrencyResponse {

    @Id
    private Long currencyId;
    @Column(name = "from_currency")
    private String from;
    @Column(name = "to_currency")
    private String to;
    private BigDecimal conversionValue;
    private String environment;

    public ExchangeCurrencyResponse() {
    }

    public ExchangeCurrencyResponse(Long currencyId, String from, String to, BigDecimal currentValue) {
        this.currencyId = currencyId;
        this.from = from;
        this.to = to;
        this.conversionValue = currentValue;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionValue() {
        return conversionValue;
    }

    public void setConversionValue(BigDecimal currentValue) {
        this.conversionValue = currentValue;
    }

    public String getEnvironment() {
        return environment;
    }
    public void setEnvironment(String environment){
        this.environment = environment;
    }

}
