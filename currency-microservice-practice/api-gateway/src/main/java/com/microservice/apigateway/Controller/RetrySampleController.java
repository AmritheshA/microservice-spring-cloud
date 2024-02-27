package com.microservice.apigateway.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RetrySampleController {

    private Logger logger = LoggerFactory.getLogger(RetrySampleController.class);

    @GetMapping("/retry-sample")
//    @Retry(name = "default")
//    @CircuitBreaker(name="default")
//    @RateLimiter(name = "default")
//    @Bulkhead(name = "default")
    public String retrySample() {

        return new RestTemplate().getForEntity("/just-sample", String.class).getBody();
    }

    public String fallbackMethod(Exception e) {
        return "Fallback response";
    }
}
