// Problem: Palindrome Number
java
// filename: palindrom_number_20240126.java

/**
 * LeetCode Problem 9: Palindrome Number
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
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
 *
 *
 * Constraints:
 * -231 <= x <= 231 - 1
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
class palindrom_number_20240126 {

    /**
     * Checks if an integer is a palindrome without converting it to a string.
     *
     * @param x The integer to check.
     * @return True if the integer is a palindrome, false otherwise.
     */
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes (except for 0 but is handled in below conditions)
        if (x < 0) {
            return false;
        }

        // If the number is 0 it is palindrome
        if (x == 0) {
            return true;
        }

        // If the number ends with 0, it can only be a palindrome if it is just 0. Example 10, 100.
        if (x % 10 == 0) {
            return false;
        }

        int reversedNumber = 0;
        int originalNumber = x;

        while (x > reversedNumber) {
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }

        // For even length palindromes we can just check if reversedNumber == x
        // For odd length palindromes, we divide the reversedNumber by 10 and check again
        return x == reversedNumber || x == reversedNumber / 10;
    }

    public static void main(String[] args) {
        palindrom_number_20240126 solution = new palindrom_number_20240126();

        int num1 = 121;
        System.out.println(num1 + " is palindrome: " + solution.isPalindrome(num1)); // Output: true

        int num2 = -121;
        System.out.println(num2 + " is palindrome: " + solution.isPalindrome(num2)); // Output: false

        int num3 = 10;
        System.out.println(num3 + " is palindrome: " + solution.isPalindrome(num3));  // Output: false

        int num4 = 12321;
        System.out.println(num4 + " is palindrome: " + solution.isPalindrome(num4)); // Output: true

        int num5 = 12345;
        System.out.println(num5 + " is palindrome: " + solution.isPalindrome(num5)); // Output: false

        int num6 = 0;
        System.out.println(num6 + " is palindrome: " + solution.isPalindrome(num6)); // Output: true

        int num7 = 1221;
        System.out.println(num7 + " is palindrome: " + solution.isPalindrome(num7)); // Output: true
    }
}
/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(log10(n)), where n is the input integer.  The while loop iterates roughly half the number of digits in the input integer.  Getting the last digit and division are constant time operations, therefore the time is proportional to number of digits which grows logarithmically with the input number.
 *
 * Space Complexity: O(1).  We only use a few integer variables (reversedNumber, digit, originalNumber), so the space used is constant regardless of the input size.
 */
