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
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 */

// filename: implement_strstr_20240127.java

public class implement_strstr_20240127 {

    /**
     * Implements the strStr() function to find the index of the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *         Returns 0 if needle is an empty string.
     *
     * Time Complexity: O(m*n) where n is the length of haystack and m is the length of needle. In the worst case, we iterate through almost all possible starting positions in haystack, and for each starting position, we compare the substring with needle.
     * Space Complexity: O(1).  We use constant extra space.
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i <= haystackLength - needleLength; i++) { // Iterate through possible starting positions in haystack
            int j;
            for (j = 0; j < needleLength; j++) { // Compare characters of haystack substring with needle
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // Mismatch, break inner loop
                }
            }
            if (j == needleLength) { // Needle found at index i
                return i;
            }
        }

        return -1; // Needle not found
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

        String haystack4 = "abc";
        String needle4 = "c";
        System.out.println("strStr(\"" + haystack4 + "\", \"" + needle4 + "\") = " + solution.strStr(haystack4, needle4)); // Output: 2

        String haystack5 = "mississippi";
        String needle5 = "issip";
        System.out.println("strStr(\"" + haystack5 + "\", \"" + needle5 + "\") = " + solution.strStr(haystack5, needle5)); // Output: 4
    }
}
