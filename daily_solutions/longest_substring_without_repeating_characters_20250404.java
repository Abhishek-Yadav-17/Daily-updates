// Problem: Longest Substring Without Repeating Characters
java
/**
 * LeetCode Problem: 3. Longest Substring Without Repeating Characters
 *
 * Problem Statement:
 * Given a string s, find the length of the longest substring without repeating characters.
 */

 /**
  * filename: longest_substring_without_repeating_characters_20240229.java
  */

import java.util.HashSet;
import java.util.Set;

class longest_substring_without_repeating_characters_20240229 {

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

        // Use a HashSet to keep track of characters in the current window.
        Set<Character> charSet = new HashSet<>();

        while (end < n) {
            // If the current character is not in the set, add it and expand the window.
            if (!charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start); // Update max length
            } else {
                // If the current character is already in the set, remove the leftmost character
                // from the window and shrink the window from the left.
                charSet.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        longest_substring_without_repeating_characters_20240229 solution = new longest_substring_without_repeating_characters_20240229();

        // Test cases
        String s1 = "abcabcbb";
        System.out.println("Longest substring length for \"" + s1 + "\": " + solution.lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println("Longest substring length for \"" + s2 + "\": " + solution.lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println("Longest substring length for \"" + s3 + "\": " + solution.lengthOfLongestSubstring(s3)); // Output: 3

        String s4 = "";
        System.out.println("Longest substring length for \"" + s4 + "\": " + solution.lengthOfLongestSubstring(s4)); // Output: 0

        String s5 = " ";
        System.out.println("Longest substring length for \"" + s5 + "\": " + solution.lengthOfLongestSubstring(s5)); // Output: 1
    }
}

/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(n), where n is the length of the string.  The while loop iterates through the string at most once,
 * and the operations within the loop (HashSet add and remove) take O(1) time on average.
 *
 * Space Complexity: O(min(m, n)), where n is the length of the string, and m is the size of the character set.
 * In the worst-case scenario, the HashSet will store all the characters in the string if all characters are unique.
 * However, it can store at most the size of the character set (e.g., 26 for lowercase English letters).
 *
 * Reasoning:
 * The sliding window approach is used to solve this problem.  The `start` and `end` pointers define the current window.
 * The HashSet is used to efficiently check if a character is already present in the current window.
 * The window expands as long as unique characters are encountered.  If a duplicate character is found, the window
 * shrinks from the left until the duplicate character is removed. The maximum length is updated in each iteration.
 */
