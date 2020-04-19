package com.github.mkotra.algorithms;

public class Factorial {
    public static void main(String[] args) {
        for (long i = 0; i < 20; i++) {
            System.out.println("N " + i + " factorial " + factorial(i));
        }
    }

    public static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
