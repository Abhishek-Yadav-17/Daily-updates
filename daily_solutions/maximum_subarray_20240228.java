// Problem: Maximum Subarray
/**
 * LeetCode Problem: 53. Maximum Subarray
 *
 * Problem Statement:
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 */

public class maximum_subarray_20240228 {

    /**
     * Java solution for the Maximum Subarray problem.
     *
     * @param nums The input array of integers.
     * @return The maximum sum of any contiguous subarray within the input array.
     */
    public int maxSubArray(int[] nums) {
        // Check if the input array is null or empty.
        if (nums == null || nums.length == 0) {
            return 0; // Return 0 if the array is null or empty.
        }

        // Initialize the maximum sum so far and the current maximum sum.
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Calculate the current maximum sum: either the current element itself,
            // or the current element plus the previous maximum sum.
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Update the maximum sum so far if the current maximum sum is greater.
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // Return the maximum sum so far.
        return maxSoFar;
    }

    public static void main(String[] args) {
        maximum_subarray_20240228 solution = new maximum_subarray_20240228();

        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println("Test Case 1: " + result1); // Expected output: 6

        // Test case 2
        int[] nums2 = {1};
        int result2 = solution.maxSubArray(nums2);
        System.out.println("Test Case 2: " + result2); // Expected output: 1

        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArray(nums3);
        System.out.println("Test Case 3: " + result3); // Expected output: 23

        // Test case 4
        int[] nums4 = {-1, -2, -3};
        int result4 = solution.maxSubArray(nums4);
        System.out.println("Test Case 4: " + result4); // Expected output: -1
    }

    /**
     * Time Complexity: O(n), where n is the length of the input array.
     *   The algorithm iterates through the array once.
     *
     * Space Complexity: O(1).
     *   The algorithm uses a constant amount of extra space to store the current maximum sum and the overall maximum sum.
     *
     * Reasoning:
     *   The Kadane's Algorithm is used to solve this problem efficiently. It iterates through the array while keeping track of the current maximum sum ending at each element and the overall maximum sum seen so far.
     *   For each element, we decide whether to start a new subarray from that element or extend the existing subarray based on whether including the current element increases the sum.
     *   This ensures that we find the maximum sum subarray in O(n) time.
     */
}