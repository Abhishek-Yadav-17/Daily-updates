// Problem: Longest Substring Without Repeating Characters
java
/**
 * LeetCode Problem: 3. Longest Substring Without Repeating Characters
 *
 * Problem Statement:
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
 */

import java.util.HashSet;
import java.util.Set;

public class longest_substring_without_repeating_characters_20240124 {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     *
     * Time Complexity: O(n), where n is the length of the string.  We iterate through the string
     * at most twice using the two pointers (start and end).
     *
     * Space Complexity: O(min(m, n)), where n is the length of the string, and m is the size of the character set.
     * In the worst case, the set might contain all the characters in the string (up to the size of the character set).
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int end = 0;

        Set<Character> charSet = new HashSet<>();

        while (end < n) {
            if (!charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, charSet.size());
            } else {
                charSet.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240124 solution = new longest_substring_without_repeating_characters_20240124();

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
