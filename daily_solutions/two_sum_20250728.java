// Problem: Two Sum
java
/**
 * LeetCode Problem: Two Sum
 *
 * Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class two_sum_20240229 {

    /**
     * Finds the indices of two numbers in the array that add up to the target.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that add up to the target, or null if no such pair exists.
     */
    public int[] twoSum(int[] nums, int target) {
        // Use a HashMap to store each number and its index.
        // This allows us to check if the complement (target - num) exists in the array in O(1) time.
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (the number needed to reach the target).
            int complement = target - nums[i];

            // Check if the complement is already in the HashMap.
            // If it is, we've found our pair!
            if (numMap.containsKey(complement)) {
                // Return the indices of the current number and its complement.
                return new int[] { numMap.get(complement), i };
            }

            // If the complement is not in the HashMap, add the current number and its index to the HashMap.
            numMap.put(nums[i], i);
        }

        // If we reach this point, it means no solution was found. This should not happen based on the problem statement.
        return null;
    }

    public static void main(String[] args) {
        two_sum_20240229 solution = new two_sum_20240229();

        // Test case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected output: [0, 1]

        // Test case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected output: [1, 2]

        // Test case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3)); // Expected output: [0, 1]
    }
}

/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(n), where n is the length of the input array.
 * - We iterate through the array once.
 * - HashMap operations (containsKey, put) take O(1) time on average.
 *
 * Space Complexity: O(n), where n is the length of the input array.
 * - In the worst-case scenario, we might store all n elements of the array in the HashMap.
 *
 * Reasoning:
 * The HashMap is used to efficiently check if the complement of a number exists in the array. By storing each number and its index in the HashMap, we can look up the complement in O(1) time on average. This avoids the need for nested loops, which would result in a time complexity of O(n^2).
 */
