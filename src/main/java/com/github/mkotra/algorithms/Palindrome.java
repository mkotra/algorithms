package com.github.mkotra.algorithms;

public class Palindrome {

    public static void main(String[] args) {
        String test1 = "madam";
        String test2 = "hello";
        String test3 = "racecar";

        System.out.println("Test 1: \"" + test1 + "\" is a palindrome: " + isPalindrome(test1)); // Expected: true
        System.out.println("Test 2: \"" + test2 + "\" is a palindrome: " + isPalindrome(test2)); // Expected: false
        System.out.println("Test 3: \"" + test3 + "\" is a palindrome: " + isPalindrome(test3)); // Expected: true
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String input) {
        // Initialize two pointers: one at the start, one at the end
        int left = 0;
        int right = input.length() - 1;

        // Compare characters from both ends towards the center
        while (left < right) {
            // If characters at both pointers are not equal, it's not a palindrome
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            // Move the pointers towards the center
            left++;
            right--;
        }

        // If all characters matched, it's a palindrome
        return true;
    }


}
