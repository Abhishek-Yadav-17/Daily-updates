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

public class longest_substring_without_repeating_characters_20240102 {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0; // Start index of the current window
        int end = 0;   // End index of the current window
        Set<Character> charSet = new HashSet<>(); // Stores the characters in the current window

        while (end < n) {
            if (!charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start);
            } else {
                charSet.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240102 solution = new longest_substring_without_repeating_characters_20240102();

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

        String s6 = "dvdf";
        System.out.println("Input: " + s6 + ", Output: " + solution.lengthOfLongestSubstring(s6)); // Expected: 3
    }
}

/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(n), where n is the length of the string.  The `while` loop iterates at most 2n times because `start` and `end` both move from 0 to n, so the overall complexity is O(n).
 *
 * Space Complexity: O(min(m, n)), where n is the length of the string, and m is the size of the character set.  The `HashSet` `charSet` stores at most `min(m, n)` characters, as it can contain at most all the distinct characters in the string `s`. In the worst case, if all characters are distinct, it will store n characters. However, it will never store more than the number of possible characters (e.g. 128 for ASCII).
 *
 * Reasoning:
 * The solution uses the sliding window technique. We maintain a window [start, end) and a set of characters within that window.
 * We iterate through the string with the `end` pointer. If the character at `end` is not in the set, we add it to the set, increment `end`, and update the maximum length.
 * If the character at `end` is already in the set, it means we have a repeating character. In this case, we remove the character at `start` from the set and increment `start`.
 * This process continues until `end` reaches the end of the string. The maximum length encountered during this process is the length of the longest substring without repeating characters.
 */
