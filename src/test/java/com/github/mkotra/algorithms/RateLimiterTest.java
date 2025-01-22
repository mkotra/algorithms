package com.github.mkotra.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RateLimiterTest {

    private RateLimiter rateLimiter;

    @BeforeEach
    void setUp() {
        // Initialize the RateLimiter with 5 requests per second
        rateLimiter = new RateLimiter(5, 1, TimeUnit.SECONDS);
    }

    @Test
    void testAllowsRequestsWithinLimit() {
        // Test that up to 5 requests are allowed
        for (int i = 0; i < 5; i++) {
            assertTrue(rateLimiter.tryAcquire(), "Request " + i + " should be allowed");
        }

        // Additional requests should be denied
        assertFalse(rateLimiter.tryAcquire(), "Request 6 should be denied");
    }

    @Test
    void testDeniesRequestsBeyondLimit() {
        // Exhaust all 5 permits
        for (int i = 0; i < 5; i++) {
            assertTrue(rateLimiter.tryAcquire(), "Request " + i + " should be allowed");
        }

        // Ensure further requests are denied within the same window
        for (int i = 5; i < 10; i++) {
            assertFalse(rateLimiter.tryAcquire(), "Request " + i + " should be denied");
        }
    }

    @Test
    void testResetsPermitsAfterTimeWindow() throws InterruptedException {
        // Exhaust all 5 permits
        for (int i = 0; i < 5; i++) {
            assertTrue(rateLimiter.tryAcquire(), "Request " + i + " should be allowed");
        }

        // Additional requests should be denied
        assertFalse(rateLimiter.tryAcquire(), "Request 6 should be denied");

        // Wait for the time window to reset
        Thread.sleep(1100);

        // After reset, permits should be replenished
        for (int i = 0; i < 5; i++) {
            assertTrue(rateLimiter.tryAcquire(), "Request after reset " + i + " should be allowed");
        }

        // Further requests should be denied again
        assertFalse(rateLimiter.tryAcquire(), "Request after reset 6 should be denied");
    }

    @Test
    void testHandlesConcurrentRequests() throws InterruptedException {
        // Create a rate limiter that allows only 1 request per second
        RateLimiter concurrentRateLimiter = new RateLimiter(1, 1, TimeUnit.SECONDS);

        // First request should be allowed
        assertTrue(concurrentRateLimiter.tryAcquire(), "First request should be allowed");

        // Concurrent request within the same second should be denied
        Thread thread = new Thread(() -> {
            boolean result = concurrentRateLimiter.tryAcquire();
            assertFalse(result, "Concurrent request should be denied");
        });
        thread.start();
        thread.join();

        // Wait for the next time window
        Thread.sleep(1100);

        // Next request should be allowed
        assertTrue(concurrentRateLimiter.tryAcquire(), "Request after window reset should be allowed");
    }

    @Test
    void testHandlesZeroPermits() {
        // Create a rate limiter with 0 requests allowed
        RateLimiter zeroPermitLimiter = new RateLimiter(0, 1, TimeUnit.SECONDS);

        // All requests should be denied
        assertFalse(zeroPermitLimiter.tryAcquire(), "Requests should always be denied for 0 permits");
    }
}
