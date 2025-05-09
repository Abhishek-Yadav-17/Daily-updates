// Problem: Palindrome Number
java
/**
 * LeetCode Problem 9: Palindrome Number
 *
 * Problem Statement:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 *
 */

public class palindrome_number_20240128 {

    /**
     * Checks if an integer is a palindrome.
     *
     * @param x The integer to check.
     * @return True if x is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (except for 0, but that's handled below).
        if (x < 0) {
            return false;
        }

        // Single-digit numbers are palindromes.
        if (x < 10) {
            return true;
        }

        // Reverse the number and compare it to the original.
        int reversedNumber = 0;
        int originalNumber = x;

        while (x > 0) {
            int remainder = x % 10; // Get the last digit.
            reversedNumber = reversedNumber * 10 + remainder; // Append to the reversed number.
            x /= 10; // Remove the last digit from the original number.
        }

        return originalNumber == reversedNumber;
    }

    public static void main(String[] args) {
        palindrome_number_20240128 solution = new palindrome_number_20240128();

        // Test cases
        int num1 = 121;
        System.out.println(num1 + " is palindrome: " + solution.isPalindrome(num1)); // Output: true

        int num2 = -121;
        System.out.println(num2 + " is palindrome: " + solution.isPalindrome(num2)); // Output: false

        int num3 = 10;
        System.out.println(num3 + " is palindrome: " + solution.isPalindrome(num3));  // Output: false

        int num4 = 1234567899;
        System.out.println(num4 + " is palindrome: " + solution.isPalindrome(num4)); // Output: false

        int num5 = 123454321;
        System.out.println(num5 + " is palindrome: " + solution.isPalindrome(num5)); // Output: true

        int num6 = 0;
        System.out.println(num6 + " is palindrome: " + solution.isPalindrome(num6));   // Output: true
    }

    /**
     * Time and Space Complexity Analysis:
     *
     * Time Complexity: O(log10(n)), where n is the input number. The number of iterations in the while loop is proportional to the number of digits in the input number, which is log base 10 of n.
     * Space Complexity: O(1). We only use a constant amount of extra space to store the reversed number and the original number. No additional data structures are used that scale with the input.
     *
     * Reasoning:
     * The algorithm reverses the integer to check if it's a palindrome. This involves iterating through the digits of the integer once. Since the number of digits is logarithmic with respect to the value of the integer, the time complexity is O(log n). The algorithm only uses a few integer variables, so the space complexity is constant, O(1).
     */
}
