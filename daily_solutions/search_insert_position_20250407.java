// Problem: Search Insert Position
java
/**
 * LeetCode Problem: 35. Search Insert Position
 *
 * Problem Statement:
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class search_insert_position_20241027 {

    /**
     * Finds the index to insert the target value into a sorted array.
     *
     * @param nums   The sorted array of distinct integers.
     * @param target The target value to search for or insert.
     * @return The index of the target if found, or the index where it would be inserted.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid to prevent potential overflow

            if (nums[mid] == target) {
                return mid; // Target found at index mid
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        // If the target is not found, 'left' will be the index where it should be inserted.
        return left;
    }

    public static void main(String[] args) {
        search_insert_position_20241027 solution = new search_insert_position_20241027();

        // Test cases
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Input: nums = [1,3,5,6], target = 5, Output: " + solution.searchInsert(nums1, target1)); // Expected: 2

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Input: nums = [1,3,5,6], target = 2, Output: " + solution.searchInsert(nums2, target2)); // Expected: 1

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Input: nums = [1,3,5,6], target = 7, Output: " + solution.searchInsert(nums3, target3)); // Expected: 4

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Input: nums = [1,3,5,6], target = 0, Output: " + solution.searchInsert(nums4, target4)); // Expected: 0

        int[] nums5 = {1};
        int target5 = 0;
        System.out.println("Input: nums = [1], target = 0, Output: " + solution.searchInsert(nums5, target5)); // Expected: 0
    }
}
/*
Time and Space Complexity:

Time Complexity: O(log n), where n is the length of the input array `nums`. This is because the algorithm uses binary search, which halves the search space in each iteration.

Space Complexity: O(1). The algorithm uses a constant amount of extra space, regardless of the input size. It only uses a few integer variables (left, right, mid) for calculations.
*/
