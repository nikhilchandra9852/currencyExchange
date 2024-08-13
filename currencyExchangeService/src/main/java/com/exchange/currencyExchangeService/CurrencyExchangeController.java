package com.exchange.currencyExchangeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable("from") String fromCurrency,@PathVariable("to") String toCurrency){
        logger.info("This method will retrieve exchange values from {} to {}",fromCurrency,toCurrency);
//        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, fromCurrency, toCurrency, BigDecimal.valueOf(65));
        CurrencyExchange currencyExchange= currencyExchangeRepository.findByFromAndTo(fromCurrency,toCurrency).orElseThrow();

        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }
}
