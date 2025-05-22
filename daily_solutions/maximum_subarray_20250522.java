// Problem: Maximum Subarray
java
/**
 * LeetCode Problem: 53. Maximum Subarray
 *
 * Problem Statement:
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */

// filename: maximum_subarray_20240229.java

class maximum_subarray_20240229 {

    /**
     * Finds the maximum sum of a contiguous subarray within the given array.
     *
     * @param nums The input integer array.
     * @return The maximum sum of a contiguous subarray.
     */
    public int maxSubArray(int[] nums) {
        // Check if the input array is valid.
        if (nums == null || nums.length == 0) {
            return 0; // or throw an exception, depending on the desired behavior
        }

        int maxSoFar = nums[0]; // Initialize the maximum sum so far with the first element
        int currentMax = nums[0]; // Initialize the current maximum sum with the first element

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // The current maximum sum is either the current element itself
            // or the current element plus the previous current maximum sum
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Update the maximum sum so far if the current maximum sum is greater
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // Return the maximum sum so far
        return maxSoFar;
    }

    public static void main(String[] args) {
        maximum_subarray_20240229 solution = new maximum_subarray_20240229();

        // Test cases
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum for " + java.util.Arrays.toString(nums1) + ": " + solution.maxSubArray(nums1)); // Expected: 6

        int[] nums2 = {1};
        System.out.println("Maximum subarray sum for " + java.util.Arrays.toString(nums2) + ": " + solution.maxSubArray(nums2)); // Expected: 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Maximum subarray sum for " + java.util.Arrays.toString(nums3) + ": " + solution.maxSubArray(nums3)); // Expected: 23

        int[] nums4 = {-1, -2, -3};
        System.out.println("Maximum subarray sum for " + java.util.Arrays.toString(nums4) + ": " + solution.maxSubArray(nums4)); // Expected: -1

        int[] nums5 = {-2, -1};
        System.out.println("Maximum subarray sum for " + java.util.Arrays.toString(nums5) + ": " + solution.maxSubArray(nums5)); // Expected: -1
    }

    /*
     * Time Complexity: O(n), where n is the length of the input array `nums`.
     *   The algorithm iterates through the array once.
     *
     * Space Complexity: O(1).
     *   The algorithm uses a constant amount of extra space, regardless of the input size. It only uses two variables, `maxSoFar` and `currentMax`,
     *   to store the maximum sum so far and the current maximum sum, respectively.
     *
     * Reasoning:
     * The Kadane's algorithm is used to solve this problem. This algorithm maintains two variables:
     * 1. `maxSoFar`: Stores the maximum sum of a contiguous subarray seen so far.
     * 2. `currentMax`: Stores the maximum sum of a contiguous subarray ending at the current position.
     *
     * For each element in the array, we update `currentMax` by taking the maximum between the current element itself and the current element plus the previous `currentMax`.
     * This effectively decides whether to start a new subarray from the current element or extend the previous subarray.
     *
     * Then, we update `maxSoFar` by taking the maximum between `maxSoFar` and `currentMax`. This ensures that `maxSoFar` always holds the maximum sum of any contiguous subarray seen so far.
     *
     * This approach avoids the need to check all possible subarrays, resulting in a linear time complexity.
     */
}
