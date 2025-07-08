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

public class implement_strstr_20240127 {

    /**
     * Implements the strStr() function to find the first occurrence of a needle string in a haystack string.
     *
     * @param haystack The string to search within.
     * @param needle The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *         Returns 0 if needle is an empty string.
     *
     * Time Complexity: O(m*n) where n is the length of haystack and m is the length of needle.
     *                 In the worst case, we might iterate through the haystack almost entirely for each character in needle.
     * Space Complexity: O(1) -  We only use constant extra space.
     */
    public int strStr(String haystack, String needle) {
        // Handle the empty needle case as per the problem statement.
        if (needle.isEmpty()) {
            return 0;
        }

        // Iterate through the haystack string.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring of haystack starting at index i matches the needle.
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the index if a match is found.
            }
        }

        // If no match is found, return -1.
        return -1;
    }

    public static void main(String[] args) {
        implement_strstr_20240127 solution = new implement_strstr_20240127();

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

        String haystack4 = "mississippi";
        String needle4 = "issip";
        System.out.println("strStr(\"" + haystack4 + "\", \"" + needle4 + "\") = " + solution.strStr(haystack4, needle4)); // Output: 4

        String haystack5 = "a";
        String needle5 = "a";
        System.out.println("strStr(\"" + haystack5 + "\", \"" + needle5 + "\") = " + solution.strStr(haystack5, needle5)); // Output: 0

        String haystack6 = "abc";
        String needle6 = "c";
        System.out.println("strStr(\"" + haystack6 + "\", \"" + needle6 + "\") = " + solution.strStr(haystack6, needle6)); // Output: 2
    }
}
