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

/**
 * Filename: two_sum_20240127.java
 * Date: 20240127
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class two_sum_20240127 {

    /**
     * Finds two numbers in the array that add up to the target value.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that add up to the target,
     *         or null if no such pair exists.
     */
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store each number and its index.
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target.
            int complement = target - nums[i];

            // Check if the complement exists in the HashMap.
            if (numMap.containsKey(complement)) {
                // If the complement exists, return the indices of the current number and the complement.
                return new int[]{numMap.get(complement), i};
            }

            // If the complement doesn't exist, add the current number and its index to the HashMap.
            numMap.put(nums[i], i);
        }

        // If no solution is found, return null.  This should not happen given the problem constraints
        // that there is exactly one solution.  Returning null handles the case where the input might not
        // satisfy those assumptions.
        return null;
    }

    public static void main(String[] args) {
        two_sum_20240127 solution = new two_sum_20240127();

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test Case 1: nums = " + Arrays.toString(nums1) + ", target = " + target1 + ", Output = " + Arrays.toString(result1)); // Output: [0, 1]

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test Case 2: nums = " + Arrays.toString(nums2) + ", target = " + target2 + ", Output = " + Arrays.toString(result2)); // Output: [1, 2]

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test Case 3: nums = " + Arrays.toString(nums3) + ", target = " + target3 + ", Output = " + Arrays.toString(result3)); // Output: [0, 1]

        //Test case 4
        int[] nums4 = {1, 4, 2, 5};
        int target4 = 6;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Test Case 4: nums = " + Arrays.toString(nums4) + ", target = " + target4 + ", Output = " + Arrays.toString(result4)); // Output: [0, 1]

    }
}

/*
 * Time and Space Complexity:
 *
 * Time Complexity: O(n), where n is the length of the input array `nums`.  This is because we iterate through the array only once.
 * The HashMap operations (containsKey and put) take constant time on average.
 *
 * Space Complexity: O(n), where n is the length of the input array `nums`.  In the worst-case scenario, all elements of the array
 * might be added to the HashMap.
 */
