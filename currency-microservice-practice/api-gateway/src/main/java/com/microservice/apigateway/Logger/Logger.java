package com.microservice.apigateway.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class Logger implements GlobalFilter {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("This is a sample log from api-gateway {}",exchange.getRequest().getPath());

        return chain.filter(exchange);
    }
}
