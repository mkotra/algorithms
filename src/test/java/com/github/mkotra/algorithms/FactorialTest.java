package com.github.mkotra.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialTest {
    @Test
    public void test() {
        Assertions.assertEquals(1, Factorial.factorial(0));
        Assertions.assertEquals(1, Factorial.factorial(1));
        Assertions.assertEquals(2, Factorial.factorial(2));
        Assertions.assertEquals(6, Factorial.factorial(3));
        Assertions.assertEquals(24, Factorial.factorial(4));
        Assertions.assertEquals(120, Factorial.factorial(5));
    }
}