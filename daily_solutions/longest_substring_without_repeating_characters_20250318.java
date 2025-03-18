// Problem: Longest Substring Without Repeating Characters
java
/**
 * LeetCode Problem 3: Longest Substring Without Repeating Characters
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

public class longest_substring_without_repeating_characters_20240125 {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int start = 0; // Start index of the sliding window
        int end = 0;   // End index of the sliding window
        Set<Character> charSet = new HashSet<>(); // Use a set to keep track of characters in the current window

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
        longest_substring_without_repeating_characters_20240125 solution = new longest_substring_without_repeating_characters_20240125();

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
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(n), where n is the length of the string s.
 *   - The `while` loop iterates through the string at most once.
 *   - `start` and `end` pointers both traverse the string from left to right.
 *   - `contains`, `add`, and `remove` operations on the `HashSet` take O(1) on average.
 *
 * Space Complexity: O(min(m, n)), where n is the length of the string `s`, and m is the size of the character set.
 *   - The `HashSet` `charSet` stores characters from the string.
 *   - In the worst case, the set will contain all unique characters in the string.
 *   - The space used by the set is bounded by the size of the character set (e.g., ASCII or Unicode) and the length of the input string.
 *
 * Reasoning:
 * We use a sliding window approach to solve this problem.  The `start` and `end` pointers define the current window.
 * The `HashSet` efficiently checks for the presence of a character within the current window in O(1) time.
 * If a character is already present, the `start` pointer is advanced and the corresponding character is removed from the `HashSet`, shrinking the window from the left.
 * If a character is not present, the `end` pointer is advanced, expanding the window to the right, and the character is added to the `HashSet`.
 * At each step, the maximum length of the substring without repeating characters is updated.
 */
