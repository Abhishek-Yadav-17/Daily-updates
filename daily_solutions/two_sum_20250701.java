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
 */

// filename: two_sum_20240229.java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class two_sum_20240229 {

    /**
     * Finds two numbers in the input array that add up to the target value.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers that add up to the target,
     *         or null if no such pair exists.
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

        // If no such pair exists, return null (although the problem statement guarantees a solution).
        return null;
    }

    public static void main(String[] args) {
        two_sum_20240229 solution = new two_sum_20240229();

        // Test case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test Case 1: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected output: [0, 1]

        // Test case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test Case 2: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected output: [1, 2]

        // Test case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test Case 3: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(result3)); // Expected output: [0, 1]

        // Test case 4
        int[] nums4 = {1, 4, 2};
        int target4 = 3;
        int[] result4 = solution.twoSum(nums4, target4);
        System.out.println("Test Case 4: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output: " + Arrays.toString(result4));

        // Test case 5
        int[] nums5 = {2,5,5,11};
        int target5 = 10;
        int[] result5 = solution.twoSum(nums5, target5);
        System.out.println("Test Case 5: nums = " + Arrays.toString(nums5) + ", target = " + target5);
        System.out.println("Output: " + Arrays.toString(result5));
    }
}
/*
Time and Space Complexity Analysis:

Time Complexity: O(n)
- The code iterates through the input array nums once.
- HashMap operations (put and containsKey) take O(1) on average.
- Therefore, the overall time complexity is dominated by the single loop, resulting in O(n).

Space Complexity: O(n)
- In the worst-case scenario, the HashMap numMap might store all the elements of the input array nums.
- Therefore, the space complexity is O(n).
*/
