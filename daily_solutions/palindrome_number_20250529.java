// Problem: Palindrome Number
java
/**
 * LeetCode Problem: 9. Palindrome Number
 *
 * Problem Statement:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 *
 */
public class palindrome_number_20240124 {

    /**
     * Checks if an integer is a palindrome.
     *
     * @param x The integer to check.
     * @return True if x is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0) {
            return false;
        }

        // Single-digit numbers are palindromes
        if (x < 10) {
            return true;
        }

        // Reverse the integer
        int reversed = 0;
        int original = x;

        while (x > 0) {
            int remainder = x % 10;
            reversed = reversed * 10 + remainder;
            x /= 10;
        }

        // Compare the reversed integer with the original integer
        return original == reversed;
    }

    public static void main(String[] args) {
        palindrome_number_20240124 solution = new palindrome_number_20240124();

        // Test cases
        int num1 = 121;
        System.out.println(num1 + " is palindrome: " + solution.isPalindrome(num1)); // Output: true

        int num2 = -121;
        System.out.println(num2 + " is palindrome: " + solution.isPalindrome(num2)); // Output: false

        int num3 = 10;
        System.out.println(num3 + " is palindrome: " + solution.isPalindrome(num3)); // Output: false

        int num4 = 12321;
        System.out.println(num4 + " is palindrome: " + solution.isPalindrome(num4)); // Output: true

        int num5 = 1;
        System.out.println(num5 + " is palindrome: " + solution.isPalindrome(num5)); // Output: true

        int num6 = 1221;
        System.out.println(num6 + " is palindrome: " + solution.isPalindrome(num6)); // Output: true
    }
}

// Time and Space Complexity:
//
// Time Complexity: O(log10(n)), where n is the input integer.  This is because the number of iterations in the `while` loop is proportional to the number of digits in the integer, which is log base 10 of n.
//
// Space Complexity: O(1). We only use a few integer variables to store the reversed number and the original number, which take constant space.  The space used does not depend on the size of the input.
