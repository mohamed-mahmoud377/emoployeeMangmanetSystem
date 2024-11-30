package com.example.employeemanagement.service;

import com.example.employeemanagement.configration.CircuitBreaker;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;

@Service
public class ThirdPartyService {

    @Autowired
    private RateLimiter rateLimiter;
    private static final Logger logger = LoggerFactory.getLogger(ThirdPartyService.class);

    private final CircuitBreaker emailCircuitBreaker = new CircuitBreaker(3, Duration.ofMinutes(5));
    private final CircuitBreaker departmentCircuitBreaker = new CircuitBreaker(3, Duration.ofMinutes(5));




    public boolean isEmailValid(String email) {
        if (!emailCircuitBreaker.isRequestAllowed()) {
            throw new RuntimeException("Email validation service is currently unavailable");
        }

        try {
            logger.info("Test Rate Limit");
            rateLimiter.acquire();

            boolean result = mockEmailValidationApiCall(email);

            logger.info("Test circuit breaker");
            emailCircuitBreaker.recordSuccess();
            return result;
        } catch (Exception e) {
            emailCircuitBreaker.recordFailure();
            throw new RuntimeException("Email validation service error: " + e.getMessage());
        }
    }

    public boolean isDepartmentValid(String department) {
        if (!departmentCircuitBreaker.isRequestAllowed()) {
            throw new RuntimeException("Department validation service is currently unavailable");
        }

        try {

            boolean result = mockDepartmentValidationApiCall(department);

            logger.info("Test circuit breaker");
            departmentCircuitBreaker.recordSuccess();
            return result;
        } catch (Exception e) {
            departmentCircuitBreaker.recordFailure();
            throw new RuntimeException("Department validation service error: " + e.getMessage());
        }
    }

    private boolean mockEmailValidationApiCall(String email) {
        return email != null && email.contains("@");
    }

    private boolean mockDepartmentValidationApiCall(String department) {
        return department != null && !department.isEmpty();
    }
}
