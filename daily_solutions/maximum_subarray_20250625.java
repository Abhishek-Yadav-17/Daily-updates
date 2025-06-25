// Problem: Maximum Subarray
java
/**
 * LeetCode Problem 53: Maximum Subarray
 *
 * Problem Statement:
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */

public class maximum_subarray_20241102 {

    /**
     * Finds the maximum sum of a contiguous subarray.
     *
     * @param nums The input integer array.
     * @return The maximum sum of a contiguous subarray.
     */
    public int maxSubArray(int[] nums) {
        // Check for null or empty input array.
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize maxSoFar and currentMax to the first element of the array.
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Calculate the maximum sum ending at the current element.
            // It's either the current element itself or the previous maximum sum plus the current element.
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Update the overall maximum sum if the current maximum sum is greater.
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // Return the overall maximum sum.
        return maxSoFar;
    }

    public static void main(String[] args) {
        maximum_subarray_20241102 solution = new maximum_subarray_20241102();

        // Test cases
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: " + java.util.Arrays.toString(nums1) + ", Max Subarray Sum: " + solution.maxSubArray(nums1)); // Expected: 6

        int[] nums2 = {1};
        System.out.println("Input: " + java.util.Arrays.toString(nums2) + ", Max Subarray Sum: " + solution.maxSubArray(nums2)); // Expected: 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Input: " + java.util.Arrays.toString(nums3) + ", Max Subarray Sum: " + solution.maxSubArray(nums3)); // Expected: 23

        int[] nums4 = {-1, -2, -3};
         System.out.println("Input: " + java.util.Arrays.toString(nums4) + ", Max Subarray Sum: " + solution.maxSubArray(nums4)); // Expected: -1

        int[] nums5 = {-2, -1};
        System.out.println("Input: " + java.util.Arrays.toString(nums5) + ", Max Subarray Sum: " + solution.maxSubArray(nums5)); // Expected: -1
    }

    /**
     * Time and Space Complexity Analysis:
     *
     * - Time Complexity: O(n), where n is the length of the input array. We iterate through the array once.
     * - Space Complexity: O(1), as we use only a constant amount of extra space to store the maxSoFar and currentMax variables.
     *
     * Reasoning:
     * The Kadane's algorithm efficiently solves this problem by iterating through the array once.
     * It keeps track of the maximum sum ending at each position and the overall maximum sum encountered so far.
     * The algorithm avoids unnecessary computations by only considering contiguous subarrays, making it highly efficient.
     */
}
