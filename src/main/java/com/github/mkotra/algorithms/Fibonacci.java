package com.github.mkotra.algorithms;

class Fibonacci {

    public static void main(String[] args) {
        for (long i = 0; i < 10; i++) {
            System.out.println("N " + i + " fibo " + fiboRecursion(i));
        }

        for (long i = 0; i < 50; i++) {
            System.out.println("N " + i + " fibo " + fiboIterative(i));
        }
    }

    public static long fiboRecursion(long n) {
        if (n <= 1) {
            return n;
        }
        return fiboRecursion(n - 2) + fiboRecursion(n - 1);
    }

    public static long fiboIterative(long n) {
        if (n <= 1) {
            return n;
        }
        long fibo = 1;
        long fiboPrev = 1;
        for (long i = 2; i < n; i++) {
            long fiboTmp = fibo;
            fibo = fibo + fiboPrev;
            fiboPrev = fiboTmp;
        }
        return fibo;
    }
}
