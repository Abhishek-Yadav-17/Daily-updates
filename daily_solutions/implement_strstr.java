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

// filename: ImplementStrStr_20240229.java

public class implement_strstr {

    /**
     * Implements the strStr() function to find the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if not found. Returns 0 if needle is empty.
     *
     * Time Complexity: O(m*n) where n is the length of haystack and m is the length of needle.
     * Space Complexity: O(1) - constant space
     *
     * Reasoning:
     * The outer loop iterates through the haystack string up to the point where there's enough room for the needle string to exist.
     * The inner loop compares characters of the needle with characters of the haystack starting from the current index of the outer loop.
     * If a mismatch is found, the inner loop breaks, and the outer loop continues to the next index.
     * If the inner loop completes without finding any mismatches (i.e., the needle is found), the index of the first character of the matched substring in the haystack is returned.
     * If the outer loop completes without finding a match, -1 is returned.
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i <= haystackLength - needleLength; i++) { // Iterate through haystack
            int j;
            for (j = 0; j < needleLength; j++) { // Iterate through needle for comparison
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // Mismatch, break inner loop
                }
            }
            if (j == needleLength) { // Needle found
                return i;
            }
        }

        return -1; // Needle not found
    }

    public static void main(String[] args) {
        implement_strstr solution = new implement_strstr();

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