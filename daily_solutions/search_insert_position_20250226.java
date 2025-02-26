// Problem: Search Insert Position
java
/**
 * LeetCode Problem: Search Insert Position
 *
 * Problem Statement:
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class search_insert_position_20240127 {

    /**
     * Searches for the target value in the sorted array and returns its index if found.
     * If the target is not found, returns the index where it would be inserted in order.
     *
     * @param nums   The sorted array of distinct integers.
     * @param target The target value to search for.
     * @return The index of the target if found, or the index where it would be inserted.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents potential overflow

            if (nums[mid] == target) {
                return mid; // Target found at index mid
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return left; // Target not found, return the index where it would be inserted
    }

    public static void main(String[] args) {
        search_insert_position_20240127 solution = new search_insert_position_20240127();

        // Test cases
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Test Case 1: " + solution.searchInsert(nums1, target1)); // Output: 2

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Test Case 2: " + solution.searchInsert(nums2, target2)); // Output: 1

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Test Case 3: " + solution.searchInsert(nums3, target3)); // Output: 4

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Test Case 4: " + solution.searchInsert(nums4, target4)); // Output: 0
    }

    /**
     * Time Complexity: O(log n) - Binary search reduces the search space by half in each iteration.
     * Space Complexity: O(1) - Constant space is used, regardless of the input size.  Only a few variables (left, right, mid) are used.
     */
}
