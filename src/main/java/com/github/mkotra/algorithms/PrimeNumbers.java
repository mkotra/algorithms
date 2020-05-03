package com.github.mkotra.algorithms;

class PrimeNumbers {

    public static void main(String[] args) {
        for (int i = 2; i < 10000; i++) {
            if (isPrime(i)) {
                System.out.println("Number " + i + " isPrime");
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        double sqrt = Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
