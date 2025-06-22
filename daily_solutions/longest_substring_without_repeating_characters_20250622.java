// Problem: Longest Substring Without Repeating Characters
java
// filename: longest_substring_without_repeating_characters_20240126.java

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
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashSet;
import java.util.Set;

class longest_substring_without_repeating_characters_20240126 {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public int lengthOfLongestSubstring(String s) {
        // Use sliding window technique with a set to track the characters in the current window.
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
                maxLength = Math.max(maxLength, charSet.size());
            } else {
                // If the current character is already in the set, remove the leftmost character and shrink the window.
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240126 solution = new longest_substring_without_repeating_characters_20240126();

        // Test cases
        String s1 = "abcabcbb";
        System.out.println("Longest substring without repeating characters for \"" + s1 + "\": " + solution.lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println("Longest substring without repeating characters for \"" + s2 + "\": " + solution.lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println("Longest substring without repeating characters for \"" + s3 + "\": " + solution.lengthOfLongestSubstring(s3)); // Output: 3

        String s4 = "";
        System.out.println("Longest substring without repeating characters for \"" + s4 + "\": " + solution.lengthOfLongestSubstring(s4)); // Output: 0

        String s5 = " ";
        System.out.println("Longest substring without repeating characters for \"" + s5 + "\": " + solution.lengthOfLongestSubstring(s5)); // Output: 1

        String s6 = "dvdf";
        System.out.println("Longest substring without repeating characters for \"" + s6 + "\": " + solution.lengthOfLongestSubstring(s6)); // Output: 3
    }

    /**
     * Time and Space Complexity:
     *
     * Time Complexity: O(n), where n is the length of the string.  The `while` loop iterates through the string at most once,
     * and set operations (add and remove) take O(1) time on average.
     *
     * Space Complexity: O(min(m, n)), where n is the length of the string and m is the size of the character set.
     * The `charSet` can store at most the number of distinct characters in the string, which is bounded by the smaller of
     * the string length and the character set size. In the worst case (string with all unique characters), the space complexity
     * is O(n).
     */
}
