// Problem: Search Insert Position
java
// filename: search_insert_position_20240229.java

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
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 */
class search_insert_position_20240229 {

    /**
     * Searches for the target value in a sorted array and returns the index where it is found,
     * or the index where it would be inserted if it were not found.
     *
     * @param nums   The sorted array of distinct integers.
     * @param target The target value to search for.
     * @return The index of the target value if found, or the index where it would be inserted.
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent potential overflow

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return left; // Target not found, return the insertion index
    }

    public static void main(String[] args) {
        search_insert_position_20240229 solution = new search_insert_position_20240229();

        // Test case 1
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        int result1 = solution.searchInsert(nums1, target1);
        System.out.println("Input: nums = [1,3,5,6], target = 5, Output: " + result1); // Expected: 2

        // Test case 2
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        int result2 = solution.searchInsert(nums2, target2);
        System.out.println("Input: nums = [1,3,5,6], target = 2, Output: " + result2); // Expected: 1

        // Test case 3
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        int result3 = solution.searchInsert(nums3, target3);
        System.out.println("Input: nums = [1,3,5,6], target = 7, Output: " + result3); // Expected: 4

        // Test case 4
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        int result4 = solution.searchInsert(nums4, target4);
        System.out.println("Input: nums = [1,3,5,6], target = 0, Output: " + result4); // Expected: 0

        // Test case 5
        int[] nums5 = {1};
        int target5 = 0;
        int result5 = solution.searchInsert(nums5, target5);
        System.out.println("Input: nums = [1], target = 0, Output: " + result5); // Expected: 0

        // Test case 6
        int[] nums6 = {1};
        int target6 = 2;
        int result6 = solution.searchInsert(nums6, target6);
        System.out.println("Input: nums = [1], target = 2, Output: " + result6); // Expected: 1
    }
}
/*
Time and Space Complexity Analysis:

Time Complexity: O(log n), where n is the length of the input array `nums`.  This is because the algorithm uses binary search, which repeatedly divides the search interval in half.

Space Complexity: O(1). The algorithm uses a constant amount of extra space, regardless of the input size.  Only a few integer variables (left, right, mid) are used.
*/
