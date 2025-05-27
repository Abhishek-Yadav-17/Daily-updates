// Problem: Palindrome Number
java
/**
 * LeetCode Problem 9: Palindrome Number
 *
 * Problem Statement:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

// filename: palindrome_number_20240128.java
public class palindrome_number_20240128 {

    /**
     * Checks if an integer is a palindrome.
     *
     * @param x The integer to check.
     * @return True if the integer is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // If the number ends with 0 and is not 0 itself, it cannot be a palindrome
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        
        int reversedNumber = 0;
        int originalNumber = x;

        // Reverse only the first half of the number
        while (x > reversedNumber) {
            int pop = x % 10;
            x /= 10;
            reversedNumber = (reversedNumber * 10) + pop;
        }

        // When the length is an odd number, we can get rid of the middle digit by reversedNumber/10
        // For example, when the input is 12321, at the end of the while loop we get x = 12, reversedNumber = 123
        // Since the middle digit doesn't matter in palindrome(it will always equal to itself), we can simply get rid of it.
        return x == reversedNumber || x == reversedNumber / 10;
    }

    public static void main(String[] args) {
        palindrome_number_20240128 solution = new palindrome_number_20240128();

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
    }
}
// Time and Space Complexity:
// Time Complexity: O(log10(n)), where n is the input number. The number of iterations in the while loop is roughly half the number of digits in the input number.
// Space Complexity: O(1).  We are only using a constant amount of extra space to store the reversed number.
