// Problem: Implement strStr()
java
/**
 * LeetCode Problem: 28. Implement strStr()
 *
 * Problem Statement:
 * Implement strStr().
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

 // filename: implement_strstr_20240126.java

public class implement_strstr_20240126 {

    /**
     * Implements the strStr() function to find the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if not found.
     */
    public int strStr(String haystack, String needle) {
        // If needle is an empty string, return 0 as per problem definition.
        if (needle.isEmpty()) {
            return 0;
        }

        // Iterate through haystack until the remaining length is less than the length of needle.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if the substring of haystack starting at index i matches needle.
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                // If a match is found, return the starting index i.
                return i;
            }
        }

        // If no match is found after iterating through haystack, return -1.
        return -1;
    }

    /**
     * Main method for testing the strStr() function with example test cases.
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        implement_strstr_20240126 solution = new implement_strstr_20240126();

        // Test case 1
        String haystack1 = "hello";
        String needle1 = "ll";
        int result1 = solution.strStr(haystack1, needle1);
        System.out.println("Test Case 1: haystack = \"" + haystack1 + "\", needle = \"" + needle1 + "\", result = " + result1); // Expected output: 2

        // Test case 2
        String haystack2 = "aaaaa";
        String needle2 = "bba";
        int result2 = solution.strStr(haystack2, needle2);
        System.out.println("Test Case 2: haystack = \"" + haystack2 + "\", needle = \"" + needle2 + "\", result = " + result2); // Expected output: -1

        // Test case 3
        String haystack3 = "";
        String needle3 = "";
        int result3 = solution.strStr(haystack3, needle3);
        System.out.println("Test Case 3: haystack = \"" + haystack3 + "\", needle = \"" + needle3 + "\", result = " + result3); // Expected output: 0

        // Test case 4
        String haystack4 = "abc";
        String needle4 = "c";
        int result4 = solution.strStr(haystack4, needle4);
        System.out.println("Test Case 4: haystack = \"" + haystack4 + "\", needle = \"" + needle4 + "\", result = " + result4);

        // Test case 5
        String haystack5 = "mississippi";
        String needle5 = "issip";
        int result5 = solution.strStr(haystack5, needle5);
        System.out.println("Test Case 5: haystack = \"" + haystack5 + "\", needle = \"" + needle5 + "\", result = " + result5);
    }
}

/*
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(m*n), where n is the length of haystack and m is the length of needle.
 * The outer loop iterates up to n-m+1 times, and the substring comparison in the inner loop takes O(m) time.
 * In the worst case (e.g., haystack = "aaaaaaaa", needle = "aaaa"), the comparison happens for most of the iterations.
 *
 * Space Complexity: O(1).
 * The algorithm uses only a constant amount of extra space for variables like i and the substring comparison. The substring method itself typically creates a new string, but its length is bounded by 'm', so it doesn't scale with the input size 'n' in a way that affects the overall space complexity asymptotically. The dominant space usage is the constant space for storing the loop counter.
 */
