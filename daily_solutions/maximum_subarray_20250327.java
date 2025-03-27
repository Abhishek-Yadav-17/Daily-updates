// Problem: Maximum Subarray
java
// maximum_subarray_20231027.java

/**
 * LeetCode Problem 53: Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 */
public class maximum_subarray_20231027 {

    /**
     * Finds the maximum sum of a contiguous subarray.
     *
     * @param nums The input array of integers.
     * @return The maximum sum of a contiguous subarray.
     */
    public int maxSubArray(int[] nums) {
        // Check for null or empty input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize variables to track the current maximum sum and the overall maximum sum.
        int currentMax = nums[0]; // Initialize currentMax with the first element
        int overallMax = nums[0];  // Initialize overallMax with the first element

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend the current subarray or start a new one.
            // If the current subarray sum is positive, extend it by adding the current element.
            // Otherwise, start a new subarray with the current element.
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Update the overall maximum sum if the current maximum sum is greater.
            overallMax = Math.max(overallMax, currentMax);
        }

        // Return the overall maximum sum.
        return overallMax;
    }

    public static void main(String[] args) {
        maximum_subarray_20231027 solution = new maximum_subarray_20231027();

        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println("Test Case 1: " + result1); // Output: 6

        // Test case 2
        int[] nums2 = {1};
        int result2 = solution.maxSubArray(nums2);
        System.out.println("Test Case 2: " + result2); // Output: 1

        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArray(nums3);
        System.out.println("Test Case 3: " + result3); // Output: 23

        // Test case 4
        int[] nums4 = {-1, -2, -3};
        int result4 = solution.maxSubArray(nums4);
        System.out.println("Test Case 4: " + result4); // Output: -1

        // Test case 5
        int[] nums5 = {-2, -1};
        int result5 = solution.maxSubArray(nums5);
        System.out.println("Test Case 5: " + result5); // Output: -1
    }
}
// Time Complexity: O(n) - The code iterates through the array once.
// Space Complexity: O(1) - The code uses a constant amount of extra space, regardless of the input size.

