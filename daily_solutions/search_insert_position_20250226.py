"""# Problem: Search Insert Position
Problem:

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
"""
# Time Complexity: O(log n) - Binary search reduces the search space by half in each iteration.
# Space Complexity: O(1) - Constant space is used, regardless of the input size.

def searchInsert(nums: list[int], target: int) -> int:
    """
    Finds the index of the target value in a sorted array, or the index where it should be inserted.

    Args:
        nums: A sorted array of distinct integers.
        target: The target value to search for.

    Returns:
        The index of the target value if found, or the index where it should be inserted.
    """
    left, right = 0, len(nums) - 1

    while left <= right:
        mid = (left + right) // 2  # Calculate the middle index.

        if nums[mid] == target:
            return mid  # Target found at the middle index.
        elif nums[mid] < target:
            left = mid + 1  # Target is in the right half.
        else:
            right = mid - 1  # Target is in the left half.

    return left  # Target not found, return the index where it should be inserted.

# Test cases
nums1 = [1, 3, 5, 6]
target1 = 5
print(searchInsert(nums1, target1))  # Output: 2

nums2 = [1, 3, 5, 6]
target2 = 2
print(searchInsert(nums2, target2))  # Output: 1

nums3 = [1, 3, 5, 6]
target3 = 7
print(searchInsert(nums3, target3))  # Output: 4

nums4 = [1, 3, 5, 6]
target4 = 0
print(searchInsert(nums4, target4)) # Output: 0

nums5 = [1]
target5 = 0
print(searchInsert(nums5,target5)) # Output: 0