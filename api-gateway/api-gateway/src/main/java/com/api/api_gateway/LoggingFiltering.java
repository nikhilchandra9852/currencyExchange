package com.api.api_gateway;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// LoggingFiltering
@Component
public class LoggingFiltering implements GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(LoggingFiltering.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Path of the request received -> {}", exchange.getRequest().getPath());

        return chain.filter(exchange);
    }
}
