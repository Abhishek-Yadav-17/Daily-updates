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
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;
import java.util.Set;

public class longest_substring_without_repeating_characters_20240126 {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        // Use a sliding window approach with a HashSet to keep track of characters in the current window.
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<>();

        while (right < n) {
            // If the current character is not in the set, add it and expand the window.
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, charSet.size()); // Update max length.
            } else {
                // If the current character is already in the set, shrink the window from the left
                // until the duplicate character is removed.
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    /**
     * Main method for testing the solution.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240126 solution = new longest_substring_without_repeating_characters_20240126();

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

        String s7 = "tmmzuxt";
        System.out.println("Input: " + s7 + ", Output: " + solution.lengthOfLongestSubstring(s7)); // Expected: 5
    }
}

/**
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(n), where n is the length of the string. The `while` loop iterates at most 2n times
 * because the `right` pointer moves from 0 to n and the `left` pointer also moves from 0 to n.
 * Each operation inside the loop (HashSet `add` and `remove`) takes O(1) time on average.
 *
 * Space Complexity: O(min(m, n)), where n is the length of the string, and m is the size of the character set.
 * The `HashSet` can store at most the number of unique characters in the string, or the length of the string
 * if all characters are unique. In the worst case, where all characters are unique, the space complexity is O(n).
 * If the character set is fixed and small (e.g., ASCII characters), the space complexity is O(1) or O(m), where m is the size of the alphabet.
 */
