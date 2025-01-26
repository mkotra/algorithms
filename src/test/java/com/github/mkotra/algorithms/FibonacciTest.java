package com.github.mkotra.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    public void testFiboRecursion() {
        assertEquals(0, Fibonacci.fiboRecursion(0));
        assertEquals(1, Fibonacci.fiboRecursion(1));
        assertEquals(1, Fibonacci.fiboRecursion(2));
        assertEquals(2, Fibonacci.fiboRecursion(3));
        assertEquals(3, Fibonacci.fiboRecursion(4));
        assertEquals(5, Fibonacci.fiboRecursion(5));
        assertEquals(8, Fibonacci.fiboRecursion(6));
        assertEquals(13, Fibonacci.fiboRecursion(7));
        assertEquals(21, Fibonacci.fiboRecursion(8));
        assertEquals(34, Fibonacci.fiboRecursion(9));
        assertEquals(55, Fibonacci.fiboRecursion(10));
        assertEquals(89, Fibonacci.fiboRecursion(11));
        assertEquals(144, Fibonacci.fiboRecursion(12));
        assertEquals(233, Fibonacci.fiboRecursion(13));
        assertEquals(377, Fibonacci.fiboRecursion(14));
        assertEquals(610, Fibonacci.fiboRecursion(15));
    }

    @Test
    public void testFiboIterative() {
        assertEquals(0, Fibonacci.fiboIterative(0));
        assertEquals(1, Fibonacci.fiboIterative(1));
        assertEquals(1, Fibonacci.fiboIterative(2));
        assertEquals(2, Fibonacci.fiboIterative(3));
        assertEquals(3, Fibonacci.fiboIterative(4));
        assertEquals(5, Fibonacci.fiboIterative(5));
        assertEquals(8, Fibonacci.fiboIterative(6));
        assertEquals(13, Fibonacci.fiboIterative(7));
        assertEquals(21, Fibonacci.fiboIterative(8));
        assertEquals(34, Fibonacci.fiboIterative(9));
        assertEquals(55, Fibonacci.fiboIterative(10));
        assertEquals(89, Fibonacci.fiboIterative(11));
        assertEquals(144, Fibonacci.fiboIterative(12));
        assertEquals(233, Fibonacci.fiboIterative(13));
        assertEquals(377, Fibonacci.fiboIterative(14));
        assertEquals(610, Fibonacci.fiboIterative(15));
    }
}