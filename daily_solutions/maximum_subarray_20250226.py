# Problem: Maximum Subarray
```python
"""
LeetCode Problem: Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:
Input: nums = [1]
Output: 1

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
"""

def maxSubArray(nums: list[int]) -> int:
    """
    Finds the contiguous subarray with the largest sum.

    Args:
        nums (list[int]): An integer array.

    Returns:
        int: The sum of the contiguous subarray with the largest sum.
    """

    max_so_far = nums[0]  # Initialize the maximum sum found so far with the first element.
    current_max = nums[0]  # Initialize the current maximum sum with the first element.

    # Iterate through the array starting from the second element.
    for i in range(1, len(nums)):
        # Determine whether to start a new subarray from the current element
        # or extend the existing subarray.
        current_max = max(nums[i], current_max + nums[i])

        # Update the maximum sum found so far.
        max_so_far = max(max_so_far, current_max)

    return max_so_far


# Test cases
nums1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
print(f"Input: {nums1}, Output: {maxSubArray(nums1)}")  # Output: 6

nums2 = [1]
print(f"Input: {nums2}, Output: {maxSubArray(nums2)}")  # Output: 1

nums3 = [5, 4, -1, 7, 8]
print(f"Input: {nums3}, Output: {maxSubArray(nums3)}")  # Output: 23

nums4 = [-1, -2, -3]
print(f"Input: {nums4}, Output: {maxSubArray(nums4)}")  # Output: -1

nums5 = [-2, -1]
print(f"Input: {nums5}, Output: {maxSubArray(nums5)}")  # Output: -1

"""
Time and Space Complexity:

Time Complexity: O(n), where n is the length of the input array `nums`.
The algorithm iterates through the array once.

Space Complexity: O(1).
The algorithm uses only a constant amount of extra space to store variables
like `max_so_far` and `current_max`, regardless of the input array size.

Reasoning:

The solution implements Kadane's Algorithm, which is a dynamic programming approach.
It maintains two variables: `max_so_far` and `current_max`. `current_max` keeps track of the
maximum sum ending at the current position, while `max_so_far` keeps track of the overall
maximum sum encountered so far. At each element, the algorithm decides whether to extend the
existing subarray (by adding the current element to `current_max`) or to start a new subarray
from the current element (by setting `current_max` to the current element). The algorithm efficiently
finds the maximum subarray sum in a single pass through the array.
"""
```