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

public class maximum_subarray_20240229 {

    /**
     * Finds the maximum sum of a contiguous subarray within the given array.
     *
     * @param nums The input array of integers.
     * @return The maximum sum of a contiguous subarray.
     */
    public int maxSubArray(int[] nums) {
        // Check if the input array is null or empty.
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize maxSoFar to the first element of the array.
        // This ensures that even if all elements are negative, we return the largest negative number.
        int maxSoFar = nums[0];

        // Initialize currentMax to the first element of the array.
        int currentMax = nums[0];

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Calculate the maximum of the current element and the sum of the current element and the previous maximum.
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Update maxSoFar with the maximum of the current maxSoFar and the current maximum.
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // Return the maximum sum found.
        return maxSoFar;
    }

    public static void main(String[] args) {
        maximum_subarray_20240229 solution = new maximum_subarray_20240229();

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

    /**
     * Time and Space Complexity:
     *
     * Time Complexity: O(n), where n is the length of the input array.  The algorithm iterates through the array once.
     *
     * Space Complexity: O(1). The algorithm uses a constant amount of extra space to store variables, regardless of the input size.
     *
     * Reasoning:
     * The algorithm uses Kadane's Algorithm, which is a dynamic programming approach. It maintains two variables:
     * - `maxSoFar`: Stores the maximum sum found so far.
     * - `currentMax`: Stores the maximum sum ending at the current position.
     *
     * For each element in the array, the algorithm updates `currentMax` by choosing the maximum between the current element itself
     * and the sum of the current element and the previous `currentMax`. This step determines whether to start a new subarray from the
     * current element or to extend the existing subarray.  Then it updates `maxSoFar`.
     * Because this is a single loop and a small number of variables, the complexities are as explained above.
     */
}
