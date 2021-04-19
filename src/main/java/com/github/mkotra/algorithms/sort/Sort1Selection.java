package com.github.mkotra.algorithms.sort;

public class Sort1Selection extends Sort {
    public static void sort(Integer[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            printCurrent(i, a);
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            show(a);
        }
    }
}
