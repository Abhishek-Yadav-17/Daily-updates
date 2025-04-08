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
     * Searches for the target value in the sorted array and returns its index.
     * If the target is not found, returns the index where it would be inserted.
     *
     * @param nums   The sorted array of distinct integers.
     * @param target The target value to search for.
     * @return The index of the target if found, or the insertion index if not found.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent integer overflow
            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return left; // Target not found, return insertion index
    }

    public static void main(String[] args) {
        search_insert_position_20241027 solution = new search_insert_position_20241027();

        // Test cases
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Input: nums = {1, 3, 5, 6}, target = 5");
        System.out.println("Output: " + solution.searchInsert(nums1, target1)); // Expected: 2

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Input: nums = {1, 3, 5, 6}, target = 2");
        System.out.println("Output: " + solution.searchInsert(nums2, target2)); // Expected: 1

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Input: nums = {1, 3, 5, 6}, target = 7");
        System.out.println("Output: " + solution.searchInsert(nums3, target3)); // Expected: 4

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Input: nums = {1, 3, 5, 6}, target = 0");
        System.out.println("Output: " + solution.searchInsert(nums4, target4)); // Expected: 0

        int[] nums5 = {1};
        int target5 = 0;
        System.out.println("Input: nums = {1}, target = 0");
        System.out.println("Output: " + solution.searchInsert(nums5, target5)); // Expected: 0
    }
}

/**
 * Time Complexity: O(log n), where n is the length of the input array. This is because we are using binary search, which halves the search space in each iteration.
 *
 * Space Complexity: O(1), as we are only using a constant amount of extra space for variables like left, right, and mid. The algorithm operates in place and doesn't create any data structures dependent on the input size.
 */
