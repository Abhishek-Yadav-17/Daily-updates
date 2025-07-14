// Problem: Palindrome Number
java
/**
 * LeetCode Problem 9: Palindrome Number
 *
 * Problem Statement:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 */

public class palindrome_number_20240227 {

    /**
     * Checks if an integer is a palindrome.
     *
     * @param x The integer to check.
     * @return True if x is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // If x is negative, it cannot be a palindrome.
        if (x < 0) {
            return false;
        }

        // If x ends with 0 and is not 0 itself, it cannot be a palindrome.
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        int reversedNumber = 0;
        int originalNumber = x;

        while (x > reversedNumber) {
            int pop = x % 10;
            x /= 10;

            reversedNumber = (reversedNumber * 10) + pop;
        }

        // When the length is an odd number, we can get rid of the middle digit by reversedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, reversedNumber = 123
        // Since the middle digit doesn't matter in determining whether it's a palindrome, we can simply get rid of it.
        return x == reversedNumber || x == reversedNumber / 10;
    }

    public static void main(String[] args) {
        palindrome_number_20240227 solution = new palindrome_number_20240227();

        // Test cases
        int num1 = 121;
        System.out.println(num1 + " is palindrome: " + solution.isPalindrome(num1)); // Output: true

        int num2 = -121;
        System.out.println(num2 + " is palindrome: " + solution.isPalindrome(num2)); // Output: false

        int num3 = 10;
        System.out.println(num3 + " is palindrome: " + solution.isPalindrome(num3)); // Output: false

        int num4 = 1221;
        System.out.println(num4 + " is palindrome: " + solution.isPalindrome(num4)); // Output: true

        int num5 = 12321;
        System.out.println(num5 + " is palindrome: " + solution.isPalindrome(num5)); // Output: true

        int num6 = 0;
        System.out.println(num6 + " is palindrome: " + solution.isPalindrome(num6)); // Output: true

        int num7 = 11;
        System.out.println(num7 + " is palindrome: " + solution.isPalindrome(num7)); // Output: true
    }
}

/**
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(log10(n)), where n is the input number.  The while loop iterates roughly half the number of digits in the input number.
 * We are essentially processing half of the digits of the number.
 *
 * Space Complexity: O(1).  We use a constant amount of extra space to store the reversed number. The space used does not depend on the size of the input.
 */
