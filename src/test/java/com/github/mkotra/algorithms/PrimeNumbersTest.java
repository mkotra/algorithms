package com.github.mkotra.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.github.mkotra.algorithms.PrimeNumbers.*;

class PrimeNumbersTest {

    @Test
    public void testFor1() {
        Assertions.assertFalse(isPrime(1));
    }

    @Test
    public void testFor2() {
        Assertions.assertTrue(isPrime(2));
    }

    @Test
    public void testFor3() {
        Assertions.assertTrue(isPrime(3));
    }

    @Test
    public void testFor4() {
        Assertions.assertTrue(isPrime(3));
    }

    @Test
    public void testFor5() {
        Assertions.assertTrue(isPrime(5));
    }

    @Test
    public void testFor6() {
        Assertions.assertFalse(isPrime(6));
    }
}