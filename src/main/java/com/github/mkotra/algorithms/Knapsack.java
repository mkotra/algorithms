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
                    dp[i][w] = 0; // Base case: no items or no capacity
                    continue;
                }

                int itemWeight = weights[i - 1];
                int itemValue = values[i - 1];

                boolean canIncludeItem = (itemWeight <= w);

                if (canIncludeItem) {
                    int excludeItem = dp[i - 1][w]; // Value if item is excluded
                    int includeItem = dp[i - 1][w - itemWeight] + itemValue; // Value if item is included
                    dp[i][w] = Math.max(excludeItem, includeItem);
                } else {
                    dp[i][w] = dp[i - 1][w]; // Item can't be included
                }
            }

            // Draw the table after each item is processed
            drawTable(dp, i, weights, values, capacity);
        }

        // The maximum value that can be obtained is in dp[n][capacity]
        return dp[n][capacity];
    }

    // Method to draw the DP table after each iteration
    public static void drawTable(int[][] dp, int currentItem, int[] weights, int[] values, int capacity) {
        System.out.println("DP Table after processing item " + currentItem +
                (currentItem > 0 ? " (Weight: " + weights[currentItem - 1] +
                        ", Value: " + values[currentItem - 1] + ")" : "") + ":");

        // Print column headers (capacities)
        System.out.print("    ");
        for (int w = 0; w <= capacity; w++) {
            System.out.printf("%4d", w);
        }
        System.out.println();

        // Print the table rows
        for (int i = 0; i < dp.length; i++) {
            System.out.printf("I%-3d", i); // Row labels (items)
            for (int w = 0; w <= capacity; w++) {
                System.out.printf("%4d", dp[i][w]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
