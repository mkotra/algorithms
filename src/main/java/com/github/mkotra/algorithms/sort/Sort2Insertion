package com.github.mkotra.algorithms.sort;

public class Sort2Insertion extends Sort {
    public static void sort(Integer[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            printCurrent(i, a);
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
            show(a);
        }
    }
}
