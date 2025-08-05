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
 *
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Example 3:
 * Input: haystack = "", needle = ""
 * Output: 0
 */

// filename: implement_strstr_20240228.java

class implement_strstr_20240228 {

    /**
     * Implements the strStr() function to find the first occurrence of needle in haystack.
     *
     * @param haystack The string to search in.
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
            // Check if the substring of haystack starting at index i is equal to needle.
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the index i if found.
            }
        }

        // If needle is not found in haystack, return -1.
        return -1;
    }

    public static void main(String[] args) {
        implement_strstr_20240228 solution = new implement_strstr_20240228();

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

         String haystack6 = "a";
        String needle6 = "a";
        System.out.println("strStr(\"" + haystack6 + "\", \"" + needle6 + "\") = " + solution.strStr(haystack6, needle6));

        String haystack7 = "aaa";
        String needle7 = "aaaa";
        System.out.println("strStr(\"" + haystack7 + "\", \"" + needle7 + "\") = " + solution.strStr(haystack7, needle7));
    }
}

/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(m*n), where n is the length of the haystack and m is the length of the needle.
 * The outer loop iterates up to n-m+1 times, and the substring comparison inside the loop takes O(m) time in the worst case.
 *
 * Space Complexity: O(1). The algorithm uses only a constant amount of extra space.
 * The substring method used internally might create a new string object, but its length is bounded by the length of the needle,
 * which can be considered as constant space relative to the input size.
 */
