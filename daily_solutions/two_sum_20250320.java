// Problem: Two Sum
java
/**
 * LeetCode Problem: 1. Two Sum
 *
 * Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class two_sum_20240102 {

    /**
     * Finds the indices of two numbers in the array that add up to the target.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that add up to the target, or null if no such pair exists.
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
                return new int[] { numMap.get(complement), i };
            }

            // If the complement doesn't exist, add the current number and its index to the HashMap.
            numMap.put(nums[i], i);
        }

        // If no solution is found, return null. This should not happen based on the problem constraints, but it's good to have for safety.
        return null;
    }

    public static void main(String[] args) {
        two_sum_20240102 solution = new two_sum_20240102();

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1));

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2));

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3));

        //Test case 4
        int[] nums4 = {1, 4, 7, 3, 9};
        int target4 = 10;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(result4));
    }
}
/**
 * Time and Space Complexity:
 *
 * Time Complexity: O(n), where n is the length of the input array nums.
 * This is because we iterate through the array only once. The HashMap operations (containsKey and put) take O(1) on average.
 *
 * Space Complexity: O(n), where n is the length of the input array nums.
 * This is because, in the worst case, we might store all the elements of the array in the HashMap.
 *
 * Reasoning:
 * The HashMap is used to store each number and its index. While iterating through the array, for each number,
 * we calculate the complement needed to reach the target. We then check if the complement exists in the HashMap.
 * If it does, it means we have found two numbers that add up to the target, and we return their indices.
 * If it doesn't, we add the current number and its index to the HashMap and continue iterating.
 * This approach avoids nested loops, which would result in a higher time complexity (O(n^2)). Using a HashMap allows us to efficiently
 * check for the complement in O(1) time on average.
 */
