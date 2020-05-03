package com.github.mkotra.algorithms;

import java.util.*;

class Change {

    private static final Map<Integer, Integer> CASH = new LinkedHashMap<>();
    static {
        CASH.put(500, 1);
        CASH.put(200, 5);
        CASH.put(100, 10);
        CASH.put(50, 30);
        CASH.put(20, 2);
        CASH.put(10, 2);
        CASH.put(5, 2);
        CASH.put(2, 3);
        CASH.put(1, 3);
    }

    public static void main(String[] args) {
        List<Integer> change = change(125, 100);
        System.out.println(change);
    }

    public static List<Integer> change(int demand, int input) {
        int target = input - demand;
        if (target < 0) {
            throw new IllegalStateException("Not enough money " + target);
        }
        List<Integer> change = new LinkedList<>();
        int current = 0;
        for (Map.Entry<Integer, Integer> entry : CASH.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (current != target) {
                while (v > 0 && current + k <= target) {
                    current = current + k;
                    change.add(k);
                    v--;
                }
            }
        }
        if (current < target) {
            throw new IllegalStateException("Cannot handle, there is not enough coins " + (current - target) + " change: " + change);
        }
        return change;
    }
}
