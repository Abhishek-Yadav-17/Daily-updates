// Problem: Two Sum
java
// two_sum_20240229.java
// 20240229

/**
 * Problem Statement:
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
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

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class two_sum_20240229 {

    /**
     * Finds two numbers in an array that add up to a target value.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that add up to the target.
     *         Returns null if no such pair exists.
     */
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store each number and its index.
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

            // If the complement does not exist, add the current number and its index to the HashMap.
            numMap.put(nums[i], i);
        }

        // If no solution is found, return null (although the problem states there's always a solution).
        return null;
    }

    public static void main(String[] args) {
        two_sum_20240229 solution = new two_sum_20240229();

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

        // Test case 4
        int[] nums4 = {1, 4, 7, 2};
        int target4 = 9;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(result4));

        // Test case 5 (negative numbers)
        int[] nums5 = {-1, -3, 2, 5};
        int target5 = -4;
        int[] result5 = solution.twoSum(nums5, target5);
        System.out.println("Input: nums = " + Arrays.toString(nums5) + ", target = " + target5);
        System.out.println("Output: " + Arrays.toString(result5));
    }
}

/**
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(n), where n is the length of the input array `nums`. This is because we iterate through the array once.
 * The HashMap operations (put and containsKey) take O(1) on average.
 *
 * Space Complexity: O(n), where n is the length of the input array `nums`. In the worst case, we might store all the elements
 * of the array in the HashMap.
 */
