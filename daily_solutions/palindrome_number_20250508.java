// Problem: Palindrome Number
java
/**
 * LeetCode Problem 9: Palindrome Number
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */

public class palindrome_number_20240228 {

    /**
     * Checks if an integer is a palindrome.
     *
     * @param x The integer to check.
     * @return True if x is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (except for Integer.MIN_VALUE which causes overflow).
        if (x < 0) {
            return false;
        }

        // Single-digit numbers are palindromes.
        if (x < 10) {
            return true;
        }

        // If the number ends with 0, it can only be a palindrome if it's just 0 itself.
        if (x % 10 == 0) {
            return false;
        }

        int reversedNumber = 0;
        int originalNumber = x;

        // Revert half of the number.
        while (x > reversedNumber) {
            int pop = x % 10;
            x /= 10;
            reversedNumber = (reversedNumber * 10) + pop;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example, when the input is 12321, at the end of the while loop, we get x = 12, revertedNumber = 123
        // Since the middle digit doesn't matter in palindrome(it will always equal to itself), we can simply get rid of it.
        return x == reversedNumber || x == reversedNumber / 10;
    }

    public static void main(String[] args) {
        palindrome_number_20240228 solution = new palindrome_number_20240228();

        // Test cases
        int x1 = 121;
        System.out.println(x1 + " is palindrome: " + solution.isPalindrome(x1)); // Output: true

        int x2 = -121;
        System.out.println(x2 + " is palindrome: " + solution.isPalindrome(x2)); // Output: false

        int x3 = 10;
        System.out.println(x3 + " is palindrome: " + solution.isPalindrome(x3)); // Output: false

        int x4 = 12321;
        System.out.println(x4 + " is palindrome: " + solution.isPalindrome(x4)); // Output: true

        int x5 = 123321;
        System.out.println(x5 + " is palindrome: " + solution.isPalindrome(x5)); // Output: true

        int x6 = 0;
        System.out.println(x6 + " is palindrome: " + solution.isPalindrome(x6)); // Output: true

        int x7 = 5;
        System.out.println(x7 + " is palindrome: " + solution.isPalindrome(x7)); // Output: true
    }
}

// Time and Space Complexity Analysis:
//
// Time Complexity: O(log10(n)) -  We are iterating through approximately half of the digits of the number.
// Space Complexity: O(1) - We are using a constant amount of extra space, regardless of the size of the input.
