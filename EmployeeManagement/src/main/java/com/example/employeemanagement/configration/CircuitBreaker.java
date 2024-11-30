package com.example.employeemanagement.configration;

import java.time.Duration;
import java.time.Instant;

public class CircuitBreaker {

    private enum State { CLOSED, OPEN, HALF_OPEN }
    private State state = State.CLOSED;

    private final int failureThreshold;
    private final Duration retryTimePeriod;
    private int failureCount = 0;
    private Instant lastFailureTime = Instant.now();

    public CircuitBreaker(int failureThreshold, Duration retryTimePeriod) {
        this.failureThreshold = failureThreshold;
        this.retryTimePeriod = retryTimePeriod;
    }

    public synchronized boolean isRequestAllowed() {
        if (state == State.OPEN) {
            if (Instant.now().isAfter(lastFailureTime.plus(retryTimePeriod))) {
                state = State.HALF_OPEN;
                return true;
            }
            return false;
        }
        return true;
    }

    public synchronized void recordSuccess() {
        state = State.CLOSED;
        failureCount = 0;
    }

    public synchronized void recordFailure() {
        failureCount++;
        if (failureCount >= failureThreshold) {
            state = State.OPEN;
            lastFailureTime = Instant.now();
        }
    }
}
