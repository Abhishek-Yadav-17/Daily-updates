// Problem: Longest Substring Without Repeating Characters
java
// Filename: longest_substring_without_repeating_characters_20240125.java

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

public class longest_substring_without_repeating_characters_20240125 {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     *
     * Time Complexity: O(n), where n is the length of the string s.  We iterate through the string at most twice,
     * once with the 'i' pointer and once with the 'j' pointer.
     *
     * Space Complexity: O(min(m, n)), where n is the length of the string s, and m is the size of the character set (e.g., 26 for lowercase English letters).
     * In the worst-case scenario, the set might contain all unique characters in the string. The space used by the HashSet is proportional to the number of distinct characters
     * present in the longest substring without repeating characters, and it's bounded by the size of the character set or the length of the input string, whichever is smaller.
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int i = 0; // Start index of the sliding window
        int j = 0; // End index of the sliding window
        Set<Character> charSet = new HashSet<>();

        while (i < n && j < n) {
            // Try to extend the range [i, j]
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j++)); // Add the character to the set and move the end pointer
                maxLength = Math.max(maxLength, j - i); // Update the maximum length
            } else {
                charSet.remove(s.charAt(i++)); // Remove the character at the start and move the start pointer
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240125 solution = new longest_substring_without_repeating_characters_20240125();

        // Test cases
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1 + ", Output: " + solution.lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println("Input: " + s2 + ", Output: " + solution.lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println("Input: " + s3 + ", Output: " + solution.lengthOfLongestSubstring(s3)); // Output: 3

        String s4 = "";
        System.out.println("Input: " + s4 + ", Output: " + solution.lengthOfLongestSubstring(s4)); // Output: 0

        String s5 = " ";
        System.out.println("Input: " + s5 + ", Output: " + solution.lengthOfLongestSubstring(s5)); // Output: 1

        String s6 = "dvdf";
        System.out.println("Input: " + s6 + ", Output: " + solution.lengthOfLongestSubstring(s6)); // Output: 3

        String s7 = "tmmzuxt";
        System.out.println("Input: " + s7 + ", Output: " + solution.lengthOfLongestSubstring(s7)); // Output: 5
    }
}
