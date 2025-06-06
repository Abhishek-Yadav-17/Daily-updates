// Problem: Search Insert Position
java
// filename: search_insert_position_20240227.java

/**
 * Problem Statement:
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */

public class search_insert_position_20240227 {

    /**
     * Searches for the target value in a sorted array and returns its index if found.
     * If the target is not found, returns the index where it would be inserted to maintain the sorted order.
     *
     * @param nums   The sorted array of distinct integers.
     * @param target The target value to search for.
     * @return The index of the target value if found, or the index where it would be inserted if not found.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // To prevent integer overflow.

            if (nums[mid] == target) {
                return mid; // Target found.
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half.
            } else {
                right = mid - 1; // Target is in the left half.
            }
        }

        return left; // Target not found, return the index where it should be inserted.
    }

    public static void main(String[] args) {
        search_insert_position_20240227 solution = new search_insert_position_20240227();

        // Test cases
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Input: nums = [1,3,5,6], target = 5");
        System.out.println("Output: " + solution.searchInsert(nums1, target1)); // Expected output: 2

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Input: nums = [1,3,5,6], target = 2");
        System.out.println("Output: " + solution.searchInsert(nums2, target2)); // Expected output: 1

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Input: nums = [1,3,5,6], target = 7");
        System.out.println("Output: " + solution.searchInsert(nums3, target3)); // Expected output: 4

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Input: nums = [1,3,5,6], target = 0");
        System.out.println("Output: " + solution.searchInsert(nums4, target4)); // Expected output: 0

        int[] nums5 = {1};
        int target5 = 0;
        System.out.println("Input: nums = [1], target = 0");
        System.out.println("Output: " + solution.searchInsert(nums5, target5)); // Expected output: 0

    }
}

/**
 * Time Complexity: O(log n), where n is the length of the array. This is due to the use of binary search,
 *                  which halves the search space in each iteration.
 *
 * Space Complexity: O(1). The algorithm uses a constant amount of extra space, regardless of the input size.
 *                   It only uses a few variables (left, right, mid) to store indices.
 */
