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

public class two_sum_20240129 {

    /**
     * Finds the indices of two numbers in an array that add up to a target value.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that add up to the target,
     *         or null if no such pair exists.
     */
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the number and its index.
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (the number needed to reach the target).
            int complement = target - nums[i];

            // Check if the complement exists in the HashMap.
            if (numMap.containsKey(complement)) {
                // If the complement exists, return the indices of the current number and the complement.
                return new int[] { numMap.get(complement), i };
            }

            // If the complement doesn't exist, add the current number and its index to the HashMap.
            numMap.put(nums[i], i);
        }

        // If no solution is found, return null (or throw an exception, depending on the problem constraints).
        return null;
    }

    public static void main(String[] args) {
        two_sum_20240129 solution = new two_sum_20240129();

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

        // Test case 4
        int[] nums4 = { -1, -3, -8, -11 };
        int target4 = -9;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(result4)); // Expected output: [0, 2]
    }
}

/*
 * Time Complexity: O(n), where n is the length of the input array.
 *   - We iterate through the array once.
 *   - HashMap operations (containsKey, put, get) take O(1) on average.
 *
 * Space Complexity: O(n), where n is the length of the input array.
 *   - In the worst case, we might store all the elements of the array in the HashMap.
 *
 * Reasoning:
 *   - The HashMap allows us to efficiently check if the complement of a number has already been seen.
 *   - By storing the number and its index in the HashMap, we can quickly retrieve the index of the complement if it exists.
 *   - This avoids nested loops, which would result in a time complexity of O(n^2).
 */
