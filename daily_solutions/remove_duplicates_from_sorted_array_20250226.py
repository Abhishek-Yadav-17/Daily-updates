# Problem: Remove Duplicates from Sorted Array
"""
Problem Statement:

Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

Clarification:

Confused why the returned value is an integer, but your answer is an array?

Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function will be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2]
Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]
Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.

Constraints:

0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in ascending order.
"""

def removeDuplicates(nums):
    """
    Removes duplicate elements from a sorted array in-place.

    Args:
        nums: A list of integers, sorted in ascending order.

    Returns:
        The new length of the array after removing duplicates.
    """

    if not nums:
        return 0

    # Initialize a pointer to track the index of the next unique element.
    unique_index = 0

    # Iterate through the array starting from the second element.
    for i in range(1, len(nums)):
        # If the current element is different from the element at unique_index,
        # it means we've found a new unique element.
        if nums[i] != nums[unique_index]:
            unique_index += 1  # Move the unique_index to the next position.
            nums[unique_index] = nums[i]  # Assign the new unique element to that position.

    # The length of the array with unique elements is unique_index + 1.
    return unique_index + 1

# Time and Space Complexity Analysis:

# Time Complexity: O(n), where n is the length of the input array `nums`.
# We iterate through the array once.  Each comparison and assignment operation takes O(1) time.

# Space Complexity: O(1).
# We are modifying the input array in-place and not using any additional data structures
# that scale with the input size.  We only use a few integer variables, which take constant space.


# Test cases
nums1 = [1, 1, 2]
length1 = removeDuplicates(nums1)
print(f"Length: {length1}, Array: {nums1[:length1]}")  # Output: Length: 2, Array: [1, 2]

nums2 = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
length2 = removeDuplicates(nums2)
print(f"Length: {length2}, Array: {nums2[:length2]}")  # Output: Length: 5, Array: [0, 1, 2, 3, 4]

nums3 = []
length3 = removeDuplicates(nums3)
print(f"Length: {length3}, Array: {nums3[:length3]}") # Output: Length: 0, Array: []

nums4 = [1,1,1]
length4 = removeDuplicates(nums4)
print(f"Length: {length4}, Array: {nums4[:length4]}") # Output: Length: 1, Array: [1]
