package com.github.mkotra.algorithms;

public class Fibonacci {

    public static void main(String[] args) {
        for (long i = 0; i < 10; i++) {
            System.out.println("N " + i + " fibo " + fibo(i));
        }

        for (long i = 0; i < 50; i++) {
            System.out.println("N " + i + " fibo " + fibo2(i));
        }
    }

    //recursion
    public static long fibo(long n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 2) + fibo(n - 1);
    }

    //without recursion
    public static long fibo2(long n) {
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
