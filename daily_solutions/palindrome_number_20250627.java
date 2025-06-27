// Problem: Palindrome Number
java
/**
 * LeetCode Problem: 9. Palindrome Number
 *
 * Problem Statement:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 */

public class palindrome_number_20240228 {

    /**
     * Determines if an integer is a palindrome.
     *
     * @param x The integer to check.
     * @return True if the integer is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (except for 0, handled later).
        if (x < 0) {
            return false;
        }

        // Single-digit numbers are palindromes
        if (x < 10) {
            return true;
        }

        // Reversing the number
        int reversedNumber = 0;
        int originalNumber = x; // Keep the original number to compare later

        while (x > 0) {
            int remainder = x % 10; // Get the last digit
            reversedNumber = reversedNumber * 10 + remainder; // Add the last digit to the reversed number
            x /= 10; // Remove the last digit from the original number
        }
        // Check if the original and reversed numbers are equal.

        return originalNumber == reversedNumber;
    }

    public static void main(String[] args) {
        palindrome_number_20240228 solution = new palindrome_number_20240228();

        // Test cases
        int num1 = 121;
        System.out.println(num1 + " is palindrome: " + solution.isPalindrome(num1)); // Output: true

        int num2 = -121;
        System.out.println(num2 + " is palindrome: " + solution.isPalindrome(num2)); // Output: false

        int num3 = 10;
        System.out.println(num3 + " is palindrome: " + solution.isPalindrome(num3));  // Output: false

        int num4 = 12321;
        System.out.println(num4 + " is palindrome: " + solution.isPalindrome(num4));  // Output: true

        int num5 = 12345;
        System.out.println(num5 + " is palindrome: " + solution.isPalindrome(num5));  // Output: false

        int num6 = 0;
        System.out.println(num6 + " is palindrome: " + solution.isPalindrome(num6));  // Output: true
    }
}

/*
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(log10(n)), where n is the input number. The while loop iterates through the digits of the number, which is proportional to the number of digits (logarithmic in base 10).
 *
 * Space Complexity: O(1). The solution uses a constant amount of extra space, regardless of the size of the input number. The variables 'reversedNumber', 'originalNumber', and 'remainder' take up a fixed amount of space.
 *
 * Reasoning:
 * The approach efficiently determines if a number is a palindrome by reversing the digits of the number and then comparing the reversed number with the original number.  The early exit conditions for negative numbers and single-digit numbers optimize the performance.  Using integer division and modulus operations, it can be done without converting the number to a string, which results in better performance and lower memory usage.
 */
