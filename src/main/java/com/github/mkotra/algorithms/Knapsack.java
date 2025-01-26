package com.github.mkotra.algorithms;

public class Knapsack {

    public static void main(String[] args) {
        // Example input
        int[] weights = {2, 3, 4, 5};  // Weights of items
        int[] values = {3, 4, 5, 6};   // Values of items
        int capacity = 5;              // Knapsack capacity

        // Calculate the maximum value we can achieve
        int maxValue = knapsack(weights, values, capacity);

        // Output the result
        System.out.println("Maximum value in Knapsack: " + maxValue);
    }

    // Function to solve the 0/1 Knapsack problem
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        // dp[i][w] will be storing the maximum value that can be obtained
        // with the first i items and a capacity of w.
        int[][] dp = new int[n + 1][capacity + 1];

        // Building the dp table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;  // Base case: no items or no capacity
                } else if (weights[i - 1] <= w) {
                    // If including the item i does not exceed the capacity
                    dp[i][w] = Math.max(dp[i - 1][w],
                            dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];  // Item i can't be included
                }
            }
        }

        // The maximum value that can be obtained is in dp[n][capacity]
        return dp[n][capacity];
    }
}
