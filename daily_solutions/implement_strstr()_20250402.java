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

// filename: implement_strstr_20240105.java
// Date: 20240105

public class implement_strstr_20240105 {

    /**
     * Implements the strStr() function to find the index of the first occurrence of needle in haystack.
     *
     * @param haystack The string to search within.
     * @param needle   The string to search for.
     * @return The index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *         Returns 0 if needle is an empty string.
     */
    public int strStr(String haystack, String needle) {
        // If needle is empty, return 0.
        if (needle.isEmpty()) {
            return 0;
        }

        // Iterate through haystack to find the first occurrence of needle.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // Check if needle is a substring of haystack starting at index i.
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the index of the first occurrence.
            }
        }

        // If needle is not found in haystack, return -1.
        return -1;
    }

    public static void main(String[] args) {
        implement_strstr_20240105 solution = new implement_strstr_20240105();

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
        String needle4 = "";
        System.out.println("strStr(\"" + haystack4 + "\", \"" + needle4 + "\") = " + solution.strStr(haystack4, needle4)); // Output: 0

        String haystack5 = "mississippi";
        String needle5 = "issip";
        System.out.println("strStr(\"" + haystack5 + "\", \"" + needle5 + "\") = " + solution.strStr(haystack5, needle5)); // Output: 4
    }
}


**Explanation:**

1.  **Problem Statement:** The code implements the `strStr()` function, which searches for the first occurrence of a substring (needle) within a larger string (haystack).

2.  **Code:**
    *   The `strStr()` function first handles the edge case where `needle` is an empty string, returning 0 as specified in the problem.
    *   It then iterates through `haystack` using a `for` loop. The loop condition `i <= haystack.length() - needle.length()` ensures that we don't go out of bounds when checking for `needle`.
    *   Inside the loop, `haystack.substring(i, i + needle.length())` extracts a substring of `haystack` starting at index `i` with the same length as `needle`.
    *   `equals(needle)` compares the extracted substring with `needle`. If they are equal, it means we've found a match, and we return the current index `i`.
    *   If the loop completes without finding a match, it means `needle` is not a substring of `haystack`, so we return -1.

3.  **Test Cases:** The `main()` function includes several test cases to demonstrate the functionality of the `strStr()` method with different inputs, including empty strings and cases where the needle is present or absent in the haystack.

4.  **Time and Space Complexity:**
    *   **Time Complexity:** O(m\*n), where n is the length of `haystack` and m is the length of `needle`.  In the worst-case scenario, the `equals()` method might perform a character-by-character comparison for each possible starting position in `haystack`.
    *   **Space Complexity:** O(1).  The solution uses only a constant amount of extra space (for variables like `i`). The `substring()` method might create a new string object, but its size is bounded by the length of `needle`, which is considered constant in terms of the input `haystack` length.

**Reasoning behind Time and Space Complexity:**

*   **Time Complexity:** The nested operation of iterating through `haystack` and comparing substrings with `needle` leads to the O(m\*n) time complexity. More efficient algorithms like KMP (Knuth-Morris-Pratt) or Boyer-Moore can achieve O(n) time complexity, but they are more complex to implement.
*   **Space Complexity:** The algorithm primarily uses a constant amount of extra space for loop counters and temporary variables, resulting in O(1) space complexity. Even the creation of substrings with `haystack.substring()` involves space proportional to `needle`, which is treated as constant relative to the input `haystack`.