package com.example.employeemanagement.configration;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimiterConfig {


    @Bean
    public RateLimiter rateLimiter() {

        double permitsPerSecond = 1.0 / 5.0;
        return RateLimiter.create(permitsPerSecond);
    }
}
