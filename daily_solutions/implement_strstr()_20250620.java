// Problem: Implement strStr()
java
/**
 * 20240229_implement_strstr.java
 *
 * Problem Statement:
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 */
public class ImplementStrstr_20240229 {

    /**
     * Implements the strStr() function to find the index of the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */
    public int strStr(String haystack, String needle) {
        // If needle is empty, return 0
        if (needle.isEmpty()) {
            return 0;
        }

        // Iterate through haystack
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if needle matches the substring of haystack starting at index i
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the index if a match is found
            }
        }

        // Return -1 if no match is found
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrstr_20240229 solution = new ImplementStrstr_20240229();

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

        String haystack5 = "abc";
        String needle5 = "c";
        System.out.println("strStr(\"" + haystack5 + "\", \"" + needle5 + "\") = " + solution.strStr(haystack5, needle5)); // Output: 2
    }
}
// Time and Space Complexity Analysis:
//
// Time Complexity: O(m*n), where n is the length of haystack and m is the length of needle.
// The outer loop iterates up to n-m times in the worst case. The substring comparison inside the loop takes O(m) time.
//
// Space Complexity: O(1).  The algorithm uses a constant amount of extra space.  The substring operation in Java may create a new string, but its size is bounded by 'm', the length of the needle.  We can consider this space usage to be constant relative to the input 'n' and 'm' since the extra space doesn't scale with the length of the haystack.
