package com.github.mkotra.algorithms.sort;

public abstract class Sort {

    public static Integer[] ARRAY = new Integer[] {5, 3, 8, 0, 6, 4, 2, 7, 9, 1};

    public static boolean less(Integer a, Integer b) {
        boolean result =  a.compareTo(b) < 0;
        if (result) {
            System.out.println(a +  " is LESS than " + b + " ");
        } else {
            System.out.println(a +  " is NOT LESS than " + b + " ");
        }
        return result;
    }

    public static void exch(Integer[] a, int i, int j) {
        System.out.println("       " + a[i] + " <--> " + a[j]);
        Integer tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void show(Integer[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(System.lineSeparator() + "-------------------------------");
    }

    public static boolean isSorted(Integer[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void printCurrent(Integer i, Integer[] a) {
        System.out.printf("i=%s a[i]=%s", i, a[i]);
        System.out.println(System.lineSeparator());
    }
}
