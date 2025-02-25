# Problem: Search Insert Position
"""
Problem Statement:

Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
"""

def searchInsert(nums: list[int], target: int) -> int:
    """
    Finds the index to insert the target value in a sorted array.

    Args:
        nums: A sorted list of distinct integers.
        target: The target integer to search for or insert.

    Returns:
        The index of the target if found, or the index where it would be inserted.
    """

    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = (low + high) // 2  # Calculate the middle index

        if nums[mid] == target:
            return mid  # Target found at the middle index
        elif nums[mid] < target:
            low = mid + 1  # Target is in the right half
        else:
            high = mid - 1  # Target is in the left half

    return low  # Target not found, return the index where it would be inserted

# Time and Space Complexity:
# Time Complexity: O(log n) - Binary search algorithm.
# Space Complexity: O(1) - Constant space used.

# Test cases
if __name__ == '__main__':
    nums1 = [1, 3, 5, 6]
    target1 = 5
    print(f"Input: nums = {nums1}, target = {target1}, Output: {searchInsert(nums1, target1)}")  # Output: 2

    nums2 = [1, 3, 5, 6]
    target2 = 2
    print(f"Input: nums = {nums2}, target = {target2}, Output: {searchInsert(nums2, target2)}")  # Output: 1

    nums3 = [1, 3, 5, 6]
    target3 = 7
    print(f"Input: nums = {nums3}, target = {target3}, Output: {searchInsert(nums3, target3)}")  # Output: 4

    nums4 = [1, 3, 5, 6]
    target4 = 0
    print(f"Input: nums = {nums4}, target = {target4}, Output: {searchInsert(nums4, target4)}") # Output: 0

    nums5 = [1]
    target5 = 0
    print(f"Input: nums = {nums5}, target = {target5}, Output: {searchInsert(nums5, target5)}") # Output: 0
