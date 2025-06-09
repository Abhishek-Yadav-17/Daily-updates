// Problem: Palindrome Number
java
//Filename: palindrom_number_20240128.java
//Date: 20240128

/*
LeetCode Problem: 9. Palindrome Number

Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/

class palindrom_number_20240128 {
    /**
     * Checks if an integer is a palindrome.
     *
     * @param x The integer to check.
     * @return True if the integer is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are never palindromes.
        if (x < 0) {
            return false;
        }

        // 0 is a palindrome
        if(x == 0) {
            return true;
        }

        // Single digit numbers are always palindromes
        if (x > 0 && x < 10) {
            return true;
        }

        // Reverse the number and compare to the original.
        int reversed_x = 0;
        int original_x = x;

        while (x > 0) {
            int remainder = x % 10;
            reversed_x = reversed_x * 10 + remainder;
            x /= 10;
        }

        return original_x == reversed_x;
    }

    public static void main(String[] args) {
        palindrom_number_20240128 solution = new palindrom_number_20240128();

        // Test cases
        int num1 = 121;
        System.out.println(num1 + " is palindrome: " + solution.isPalindrome(num1)); // Output: true

        int num2 = -121;
        System.out.println(num2 + " is palindrome: " + solution.isPalindrome(num2)); // Output: false

        int num3 = 10;
        System.out.println(num3 + " is palindrome: " + solution.isPalindrome(num3)); // Output: false

        int num4 = 12321;
        System.out.println(num4 + " is palindrome: " + solution.isPalindrome(num4)); // Output: true

        int num5 = 0;
        System.out.println(num5 + " is palindrome: " + solution.isPalindrome(num5)); // Output: true
    }

    /*
    Time Complexity: O(log10(x)), where x is the input integer.  The while loop iterates through the digits of x,
    and the number of digits in x is proportional to log10(x).

    Space Complexity: O(1).  The algorithm uses a constant amount of extra space, regardless of the size of the input.
    We only use a few integer variables to store the reversed number and other intermediate values.
    */
}
