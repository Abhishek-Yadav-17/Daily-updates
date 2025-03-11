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

// filename: implement_strstr_20240103.java
public class implement_strstr_20240103 {

    /**
     * Implements the strStr() function to find the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if not found.
     */
    public int strStr(String haystack, String needle) {
        // Handle the case where needle is an empty string.
        if (needle.isEmpty()) {
            return 0;
        }

        // Iterate through the haystack string.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring of haystack starting at index i matches the needle.
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the starting index if a match is found.
            }
        }

        // If no match is found, return -1.
        return -1;
    }

    public static void main(String[] args) {
        implement_strstr_20240103 solution = new implement_strstr_20240103();

        // Test cases
        String haystack1 = "hello";
        String needle1 = "ll";
        System.out.println("haystack: " + haystack1 + ", needle: " + needle1 + ", index: " + solution.strStr(haystack1, needle1)); // Output: 2

        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println("haystack: " + haystack2 + ", needle: " + needle2 + ", index: " + solution.strStr(haystack2, needle2)); // Output: -1

        String haystack3 = "";
        String needle3 = "";
        System.out.println("haystack: " + haystack3 + ", needle: " + needle3 + ", index: " + solution.strStr(haystack3, needle3)); // Output: 0

        String haystack4 = "abc";
        String needle4 = "c";
        System.out.println("haystack: " + haystack4 + ", needle: " + needle4 + ", index: " + solution.strStr(haystack4, needle4)); // Output: 2

        String haystack5 = "mississippi";
        String needle5 = "issip";
        System.out.println("haystack: " + haystack5 + ", needle: " + needle5 + ", index: " + solution.strStr(haystack5, needle5)); // Output: 4
    }
}
/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(m*n), where n is the length of the haystack and m is the length of the needle.
 *  - The outer loop iterates up to n-m times.
 *  - The substring operation within the loop takes O(m) time.
 *  - The equals() method in the worst case can also take O(m) time.
 *
 * Space Complexity: O(1).
 *  - The algorithm uses a constant amount of extra space, regardless of the input size.
 */
