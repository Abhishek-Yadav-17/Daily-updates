// Problem: Palindrome Number
java
/**
 * LeetCode Problem: 9. Palindrome Number
 *
 * Problem Statement:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */

 /**
  * filename: palindrom_number_20240229.java
  */
public class palindrom_number_20240229 {

    /**
     * Checks if an integer is a palindrome.
     *
     * @param x The integer to check.
     * @return True if the integer is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (except for 0 but we handle it below)
        if (x < 0) {
            return false;
        }

        // Special case: 0 is a palindrome
        if (x == 0) {
            return true;
        }

        // Revert half of the number and compare with the other half.
        int revertedNumber = 0;
        int originalNumber = x;

        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example, when the input is 12321, at the end of the while loop, we get x = 12, revertedNumber = 123
        // Since the middle digit doesn't matter in palindrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        palindrom_number_20240229 solution = new palindrom_number_20240229();

        // Test cases
        int num1 = 121;
        System.out.println(num1 + " is palindrome: " + solution.isPalindrome(num1)); // Output: true

        int num2 = -121;
        System.out.println(num2 + " is palindrome: " + solution.isPalindrome(num2)); // Output: false

        int num3 = 10;
        System.out.println(num3 + " is palindrome: " + solution.isPalindrome(num3));  // Output: false

        int num4 = 0;
        System.out.println(num4 + " is palindrome: " + solution.isPalindrome(num4));  // Output: true

        int num5 = 12321;
        System.out.println(num5 + " is palindrome: " + solution.isPalindrome(num5));  // Output: true

        int num6 = 123321;
        System.out.println(num6 + " is palindrome: " + solution.isPalindrome(num6)); // Output: true
    }

    /**
     * Time Complexity: O(log10(n)), where n is the input number.  We are essentially iterating through half of the digits of the number.
     * Space Complexity: O(1). We are only using a constant amount of extra space to store the reverted number.
     */
}
