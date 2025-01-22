package com.github.mkotra.algorithms;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    private final Semaphore semaphore;
    private final int maxRequests;
    private final long timePeriodMillis;
    private long nextResetTime;

    public RateLimiter(int maxRequests, long timePeriod, TimeUnit timeUnit) {
        this.semaphore = new Semaphore(maxRequests);
        this.maxRequests = maxRequests;
        this.timePeriodMillis = timeUnit.toMillis(timePeriod);
        this.nextResetTime = System.currentTimeMillis() + timePeriodMillis;
    }

    public synchronized boolean tryAcquire() {
        long now = System.currentTimeMillis();

        if (now >= nextResetTime) {
            semaphore.drainPermits(); // Clear all permits
            semaphore.release(maxRequests); // Reset to maxRequests
            nextResetTime = now + timePeriodMillis;
        }

        return semaphore.tryAcquire();
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 1, TimeUnit.SECONDS);

        for (int i = 0; i < 100; i++) {
            if (rateLimiter.tryAcquire()) {
                System.out.println("Request allowed: " + i);
            } else {
                System.out.println("Request denied: " + i);
            }
            Thread.sleep(100);
        }
    }
}
