// Problem: Implement strStr()
java
/**
 * LeetCode Problem: 28. Implement strStr()
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
 */

// filename: implement_strstr_20240103.java
public class implement_strstr_20240103 {

    /**
     * Implements strStr() to find the index of the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *         Returns 0 if needle is an empty string.
     */
    public int strStr(String haystack, String needle) {
        // If needle is empty, return 0 as per problem description.
        if (needle.isEmpty()) {
            return 0;
        }

        // Iterate through the haystack string.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring of haystack starting at index i matches the needle.
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                // If a match is found, return the starting index i.
                return i;
            }
        }

        // If no match is found after iterating through the entire haystack, return -1.
        return -1;
    }

    public static void main(String[] args) {
        implement_strstr_20240103 solution = new implement_strstr_20240103();

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

/**
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(m*n), where n is the length of the haystack and m is the length of the needle.
 *                  In the worst case, we may iterate through the haystack string almost entirely,
 *                  and for each position, we perform a string comparison of length m.
 *                  substring() takes O(m) time.
 *
 * Space Complexity: O(1).  We use only a constant amount of extra space, regardless of the input size.
 *                   The substring method may create a new string, but its length is bounded by 'm',
 *                   and it's considered constant in terms of the input size for space complexity analysis.
 */
