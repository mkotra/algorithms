package com.github.mkotra.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    public void compareRecursionAndWithoutRecursion() {
        for (int i = 0; i < 20; i++) {
            assertEquals(Fibonacci.fibo(i), Fibonacci.fibo2(i));
        }
    }
}