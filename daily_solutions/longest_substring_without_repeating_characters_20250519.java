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

public class longest_substring_without_repeating_characters_20240229 {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        // Use a sliding window approach with a HashSet to track characters in the current window.

        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<>(); // Use a HashSet for O(1) lookup.

        while (right < n) {
            if (!charSet.contains(s.charAt(right))) {
                // If the character is not in the set, add it and expand the window.
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                // If the character is already in the set, shrink the window from the left until
                // the repeating character is removed.
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240229 solution = new longest_substring_without_repeating_characters_20240229();

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
    }
}

/*
 * Time Complexity: O(n), where n is the length of the string.  The `while` loop iterates through the string at most twice (once for `right` and once for `left`).
 * Space Complexity: O(min(n, m)), where n is the length of the string and m is the size of the character set (e.g., 26 for lowercase English letters, 128 for ASCII, etc.).  In the worst case, the HashSet `charSet` will store all the unique characters in the string.  If the string contains only unique characters, the space complexity is O(n). If the string contains characters from a fixed character set, the space complexity is O(m). Since we take the `min`, we can say the complexity is O(min(n,m)).
 *
 * Reasoning:
 * - The algorithm uses a sliding window approach, which is efficient for substring problems.
 * - The HashSet is used to efficiently check for repeating characters in O(1) time on average.
 * - The window expands as long as the character is not already in the HashSet.
 * - If a repeating character is found, the window shrinks from the left until the repeating character is removed.
 * - The maximum length of the substring without repeating characters is updated in each iteration.
 */
