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

public class longest_substring_without_repeating_characters_20240128 {

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
            // Try to extend the range [start, end]
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

    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240128 solution = new longest_substring_without_repeating_characters_20240128();

        // Test cases
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1);
        System.out.println("Length of longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println("Input: " + s2);
        System.out.println("Length of longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println("Input: " + s3);
        System.out.println("Length of longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s3)); // Output: 3

        String s4 = "";
        System.out.println("Input: " + s4);
        System.out.println("Length of longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s4)); // Output: 0

        String s5 = " ";
        System.out.println("Input: " + s5);
        System.out.println("Length of longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s5)); // Output: 1

        String s6 = "au";
        System.out.println("Input: " + s6);
        System.out.println("Length of longest substring without repeating characters: " + solution.lengthOfLongestSubstring(s6)); // Output: 2
    }
}

/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(n), where n is the length of the string s.  The `while` loop iterates at most 2n times because `start` and `end` both increment from 0 to n at most once.  The operations within the loop (HashSet `contains`, `add`, `remove`) take O(1) time on average.
 *
 * Space Complexity: O(min(m, n)), where n is the length of the string `s` and m is the size of the character set (number of unique characters). The HashSet `charSet` stores at most `min(m, n)` characters.  In the worst case (all characters are unique), the HashSet can store all the characters in the string.  In other cases, the HashSet stores at most the number of unique characters in the string.
 *
 * Reasoning:
 *
 * The solution uses the sliding window approach.  It maintains a window [start, end] and a HashSet to store the characters in the current window.
 * The `start` pointer indicates the beginning of the window and the `end` pointer indicates the end of the window.
 * The algorithm iterates through the string, expanding the window to the right (`end++`).  If a repeating character is encountered (i.e., `s.charAt(end)` is already in the HashSet), the window is shrunk from the left (`start++`) until the repeating character is removed from the HashSet.
 * The maximum length of the substring without repeating characters is updated at each step.
 */
