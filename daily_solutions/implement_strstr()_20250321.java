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
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 */

// filename: implement_strstr_20240229.java

public class implement_strstr_20240229 {

    /**
     * Implements the strStr() function to find the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if not found.
     */
    public int strStr(String haystack, String needle) {
        // Handle the edge case where needle is an empty string.  According to the problem statement, return 0.
        if (needle.isEmpty()) {
            return 0;
        }

        // Iterate through the haystack string.  The loop condition ensures we don't go out of bounds
        // when checking for the needle string.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring of haystack starting at index i matches the needle.
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                // If a match is found, return the starting index i.
                return i;
            }
        }

        // If the needle is not found in the haystack, return -1.
        return -1;
    }

    public static void main(String[] args) {
        implement_strstr_20240229 solution = new implement_strstr_20240229();

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

/*
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(m*n), where n is the length of the haystack and m is the length of the needle.
 *   - The outer loop iterates up to n-m+1 times.
 *   - The `substring` and `equals` operations within the loop take O(m) time in the worst case.
 *
 * Space Complexity: O(1).
 *   - The algorithm uses a constant amount of extra space, regardless of the input size.  We're just using a few variables.
 */
