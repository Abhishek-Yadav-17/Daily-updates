// Problem: Search Insert Position
java
/**
 * LeetCode Problem 35: Search Insert Position
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */

 // Filename: search_insert_position_20240127.java
 public class search_insert_position_20240127 {

    /**
     * Searches for the target value in a sorted array and returns the index if found.
     * If not found, returns the index where the target would be inserted to maintain the sorted order.
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
                return mid; // Target found at index mid
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return left; // Target not found, return the index where it should be inserted
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

        int[] nums5 = {1};
        int target5 = 0;
        System.out.println("Test Case 5: " + solution.searchInsert(nums5, target5)); // Output: 0

        int[] nums6 = {1};
        int target6 = 2;
        System.out.println("Test Case 6: " + solution.searchInsert(nums6, target6)); // Output: 1
    }
}

/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(log n), where n is the length of the input array `nums`.
 *                  This is because we are using binary search to find the target or its insertion point. Binary search divides the search space in half at each step, resulting in logarithmic time complexity.
 *
 * Space Complexity: O(1), which is constant. We are only using a few extra variables (left, right, mid) to store indices, and their memory usage does not depend on the size of the input array. Therefore, the space complexity is constant.
 */
