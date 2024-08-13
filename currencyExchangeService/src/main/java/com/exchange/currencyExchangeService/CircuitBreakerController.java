package com.exchange.currencyExchangeService;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api",fallbackMethod = "hardCodedResponse")
//    @CircuitBreaker(name = "default",fallbackMethod = "hardCodedResponse")
    //ratelimiting - no of calls for time
    @RateLimiter(name="default")
    // how many concurrent calls are called using BulkHead
    @Bulkhead(name = "default")
    public String sampleApi(){
        logger.info("Sample APi call received.");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:3637/dummy", String.class);
//        return forEntity.getBody();
        return "Hi Nikhil";
    }
    public  String hardCodedResponse(Exception ex){
        return "Fallback-response"+ex.getMessage();
    }
}
