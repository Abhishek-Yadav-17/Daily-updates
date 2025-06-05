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
     * Finds the indices of two numbers in the input array that add up to the target value.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that add up to the target, or null if no such pair exists.
     */
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store each number and its index.
        Map<Integer, Integer> numMap = new HashMap<>();

        // Iterate through the input array.
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target.
            int complement = target - nums[i];

            // Check if the complement exists in the HashMap.
            if (numMap.containsKey(complement)) {
                // If the complement exists, return the indices of the current number and its complement.
                return new int[] { numMap.get(complement), i };
            }

            // If the complement doesn't exist, add the current number and its index to the HashMap.
            numMap.put(nums[i], i);
        }

        // If no solution is found, return null or throw an exception.
        return null; // Or throw IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        two_sum_20240229 solution = new two_sum_20240229();

        // Test cases
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [0, 1]

        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [1, 2]

        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3)); // Expected: [0, 1]

        int[] nums4 = { -1, -3, 4, 0 };
        int target4 = -1;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(result4)); // Expected: [0,3]
    }

    /*
     * Time and Space Complexity Analysis:
     *
     * Time Complexity: O(n)
     *   - The algorithm iterates through the input array 'nums' once.
     *   - HashMap operations (containsKey and put) take O(1) average time.
     *   - Therefore, the overall time complexity is linear with respect to the size of the input array.
     *
     * Space Complexity: O(n)
     *   - In the worst-case scenario, the HashMap 'numMap' might store all the elements of the input array.
     *   - Therefore, the space complexity is linear with respect to the size of the input array.
     */
}
