// Problem: Search Insert Position
java
// Filename: search_insert_position_20231027.java

/**
 * Problem Statement:
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
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
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */

class search_insert_position_20231027 {

    /**
     * Finds the insert position for a target value in a sorted array.
     *
     * @param nums   The sorted array of distinct integers.
     * @param target The target value to search for or find the insert position for.
     * @return The index of the target if found, or the index where it would be inserted.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate mid to prevent potential overflow

            if (nums[mid] == target) {
                return mid; // Target found at mid index
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return left; // Target not found, return the index where it would be inserted
    }

    public static void main(String[] args) {
        search_insert_position_20231027 solution = new search_insert_position_20231027();

        // Test cases
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Input: nums = [1,3,5,6], target = 5");
        System.out.println("Output: " + solution.searchInsert(nums1, target1)); // Expected: 2

        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Input: nums = [1,3,5,6], target = 2");
        System.out.println("Output: " + solution.searchInsert(nums2, target2)); // Expected: 1

        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Input: nums = [1,3,5,6], target = 7");
        System.out.println("Output: " + solution.searchInsert(nums3, target3)); // Expected: 4

        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Input: nums = [1,3,5,6], target = 0");
        System.out.println("Output: " + solution.searchInsert(nums4, target4)); // Expected: 0

        int[] nums5 = {1};
        int target5 = 0;
        System.out.println("Input: nums = [1], target = 0");
        System.out.println("Output: " + solution.searchInsert(nums5, target5)); // Expected: 0

        int[] nums6 = {1, 3, 5};
        int target6 = 4;
        System.out.println("Input: nums = [1, 3, 5], target = 4");
        System.out.println("Output: " + solution.searchInsert(nums6, target6)); // Expected: 2

        int[] nums7 = {1,3,5,6};
        int target7 = 5;

        System.out.println("Input: nums = [1, 3, 5, 6], target = 5");
        System.out.println("Output: " + solution.searchInsert(nums7, target7)); // Expected: 2
    }
}

/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(log n), where n is the length of the input array `nums`. This is because we are using binary search,
 *                  which repeatedly divides the search interval in half.
 *
 * Space Complexity: O(1).  We are only using a constant amount of extra space for variables like `left`, `right`, and `mid`,
 *                   regardless of the input size. This makes the space complexity constant.
 */
