package com.github.mkotra.algorithms;

import org.junit.jupiter.api.Test;

import static com.github.mkotra.algorithms.PrimeNumbers.isPrime;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrimeNumbersTest {

    @Test
    public void testFor1() {
        assertFalse(isPrime(1));
    }

    @Test
    public void testFor2() {
        assertTrue(isPrime(2));
    }

    @Test
    public void testFor3() {
        assertTrue(isPrime(3));
    }

    @Test
    public void testFor4() {
        assertTrue(isPrime(3));
    }

    @Test
    public void testFor5() {
        assertTrue(isPrime(5));
    }

    @Test
    public void testFor6() {
        assertFalse(isPrime(6));
    }
}