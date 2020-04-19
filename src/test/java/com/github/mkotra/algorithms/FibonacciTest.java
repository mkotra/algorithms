package com.github.mkotra.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

    @Test
    public void compareRecursionAndWithoutRecursion() {
        for (int i = 0; i < 20; i++) {
            Assertions.assertEquals(Fibonacci.fibo(i), Fibonacci.fibo2(i));
        }
    }
}