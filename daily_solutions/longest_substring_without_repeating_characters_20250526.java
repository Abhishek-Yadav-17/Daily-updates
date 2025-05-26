// Problem: Longest Substring Without Repeating Characters
java
/**
 * LeetCode Problem 3: Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;
import java.util.Set;

public class longest_substring_without_repeating_characters_20240228 {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Set<Character> charSet = new HashSet<>();

        while (start < n && end < n) {
            // try to extend the range [start, end]
            if (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            } else {
                charSet.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start);
            }
        }

        return maxLength;
    }

    /**
     * Main method to test the solution.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240228 solution = new longest_substring_without_repeating_characters_20240228();

        // Test cases
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1 + ", Output: " + solution.lengthOfLongestSubstring(s1)); // Expected: 3

        String s2 = "bbbbb";
        System.out.println("Input: " + s2 + ", Output: " + solution.lengthOfLongestSubstring(s2)); // Expected: 1

        String s3 = "pwwkew";
        System.out.println("Input: " + s3 + ", Output: " + solution.lengthOfLongestSubstring(s3)); // Expected: 3

        String s4 = "";
        System.out.println("Input: " + s4 + ", Output: " + solution.lengthOfLongestSubstring(s4)); // Expected: 0

        String s5 = " ";
        System.out.println("Input: " + s5 + ", Output: " + solution.lengthOfLongestSubstring(s5)); // Expected: 1

        String s6 = "au";
        System.out.println("Input: " + s6 + ", Output: " + solution.lengthOfLongestSubstring(s6)); // Expected: 2

        String s7 = "dvdf";
        System.out.println("Input: " + s7 + ", Output: " + solution.lengthOfLongestSubstring(s7)); // Expected: 3
    }
}

// Time and Space Complexity Analysis:
//
// Time Complexity: O(n), where n is the length of the string s. The `while` loop iterates through the string at most twice in the worst-case scenario (when all characters are distinct), because start and end pointers only move forward. The operations within the loop (HashSet `contains` and `remove` or `add`) take O(1) time on average.
//
// Space Complexity: O(min(m, n)), where n is the length of the string s, and m is the size of the character set (e.g., 26 for lowercase English letters). This is because the HashSet `charSet` stores at most all unique characters in the string. In the worst-case scenario (when all characters in s are unique), the HashSet will store n characters. However, if the character set is smaller than n (e.g., the string consists of only lowercase English letters), the HashSet will store at most m characters.

