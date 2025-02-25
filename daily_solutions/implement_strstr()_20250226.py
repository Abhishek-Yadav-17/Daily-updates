# Problem: Implement strStr()
```python
# Problem Statement:
#
# Implement strStr().
#
# Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
#
# Clarification:
#
# What should we return when needle is an empty string? This is a great question to ask during an interview.
#
# For the purpose of this problem, we will return 0 when needle is an empty string.
#
# Example 1:
#
# Input: haystack = "hello", needle = "ll"
# Output: 2
#
# Example 2:
#
# Input: haystack = "aaaaa", needle = "bba"
# Output: -1
#
# Example 3:
#
# Input: haystack = "", needle = ""
# Output: 0

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        """
        Finds the index of the first occurrence of needle in haystack.

        Args:
            haystack: The string to search in.
            needle: The string to search for.

        Returns:
            The index of the first occurrence of needle in haystack, or -1 if needle is not found.
        """

        # If needle is an empty string, return 0.
        if not needle:
            return 0

        # Iterate through the haystack, checking for needle at each position.
        for i in range(len(haystack) - len(needle) + 1):
            # If the substring of haystack starting at i matches needle, return i.
            if haystack[i:i + len(needle)] == needle:
                return i

        # If needle is not found, return -1.
        return -1

# Time and Space Complexity:

# Time Complexity: O(m*n), where n is the length of haystack and m is the length of needle.
# In the worst case, we iterate through the entire haystack and compare needle with a substring of haystack at each position.

# Space Complexity: O(1).  We use only a constant amount of extra space.

# Test cases
if __name__ == '__main__':
    sol = Solution()

    # Test case 1
    haystack1 = "hello"
    needle1 = "ll"
    result1 = sol.strStr(haystack1, needle1)
    print(f"Input: haystack = '{haystack1}', needle = '{needle1}'")
    print(f"Output: {result1}")  # Expected output: 2

    # Test case 2
    haystack2 = "aaaaa"
    needle2 = "bba"
    result2 = sol.strStr(haystack2, needle2)
    print(f"Input: haystack = '{haystack2}', needle = '{needle2}'")
    print(f"Output: {result2}")  # Expected output: -1

    # Test case 3
    haystack3 = ""
    needle3 = ""
    result3 = sol.strStr(haystack3, needle3)
    print(f"Input: haystack = '{haystack3}', needle = '{needle3}'")
    print(f"Output: {result3}")  # Expected output: 0

    # Test case 4
    haystack4 = "mississippi"
    needle4 = "issip"
    result4 = sol.strStr(haystack4, needle4)
    print(f"Input: haystack = '{haystack4}', needle = '{needle4}'")
    print(f"Output: {result4}") #Expected output: 4

    # Test case 5
    haystack5 = "abc"
    needle5 = "c"
    result5 = sol.strStr(haystack5, needle5)
    print(f"Input: haystack = '{haystack5}', needle = '{needle5}'")
    print(f"Output: {result5}") # Expected output: -1
```