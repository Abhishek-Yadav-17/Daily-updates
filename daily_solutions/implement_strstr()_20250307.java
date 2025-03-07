// Problem: Implement strStr()
java
/**
 * LeetCode Problem: 28. Implement strStr()
 *
 * Problem Statement:
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

public class implement_strstr_20240126 {

    /**
     * Implements strStr() function to find the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if not found.
     */
    public int strStr(String haystack, String needle) {
        // If needle is empty, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        // Iterate through the haystack string
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring of haystack starting at i matches needle
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the starting index if a match is found
            }
        }

        // If no match is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        implement_strstr_20240126 solution = new implement_strstr_20240126();

        // Test cases
        String haystack1 = "hello";
        String needle1 = "ll";
        System.out.println("strStr(\"" + haystack1 + "\", \"" + needle1 + "\") = " + solution.strStr(haystack1, needle1)); // Output: 2

        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println("strStr(\"" + haystack2 + "\", \"" + needle2 + "\") = " + solution.strStr(haystack2, needle2)); // Output: -1

        String haystack3 = "";
        String needle3 = "";
        System.out.println("strStr(\"" + haystack3 + "\", \"" + needle3 + "\") = " + solution.strStr(haystack3, needle3)); // Output: 0

        String haystack4 = "abc";
        String needle4 = "c";
        System.out.println("strStr(\"" + haystack4 + "\", \"" + needle4 + "\") = " + solution.strStr(haystack4, needle4)); // Output: 2

        String haystack5 = "mississippi";
        String needle5 = "issip";
        System.out.println("strStr(\"" + haystack5 + "\", \"" + needle5 + "\") = " + solution.strStr(haystack5, needle5)); // Output: 4

        String haystack6 = "a";
        String needle6 = "a";
        System.out.println("strStr(\"" + haystack6 + "\", \"" + needle6 + "\") = " + solution.strStr(haystack6, needle6)); // Output: 0

         String haystack7 = "aaa";
         String needle7 = "aaaa";
         System.out.println("strStr(\"" + haystack7 + "\", \"" + needle7 + "\") = " + solution.strStr(haystack7, needle7)); // Output: -1
    }

    /**
     * Time Complexity: O(m*n) where n is the length of haystack and m is the length of needle.
     * The outer loop iterates up to n-m times, and the substring comparison inside the loop takes O(m) time in the worst case.
     *
     * Space Complexity: O(1).
     * The algorithm uses only a constant amount of extra space.
     */
}
