package com.github.mkotra.algorithms;

class McCarthy {

    static int counter = 0;

    public static void main(String[] args) {
        System.out.println("Result: " + mc91(-100000));
        System.out.println("Counter: " + counter);
    }

    public static int mc91(int n) {
        counter++;
        if (n > 100) {
            return n - 10;
        } else {
            return mc91(mc91(n + 11));
        }
    }
}
