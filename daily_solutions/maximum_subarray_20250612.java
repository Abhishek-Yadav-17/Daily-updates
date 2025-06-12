// Problem: Maximum Subarray
java
// maximum_subarray_20240126.java

/*
Problem Statement:

Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum = 1.

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: [5,4,-1,7,8] has the largest sum = 23.
*/

class maximum_subarray_20240126 {

    /**
     * Finds the maximum sum of a contiguous subarray within the given array.
     *
     * @param nums The input array of integers.
     * @return The maximum sum of any contiguous subarray within the input array.
     */
    public int maxSubArray(int[] nums) {
        // Check for edge cases: null or empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Initialize max_so_far and current_max to the first element
        int max_so_far = nums[0];
        int current_max = nums[0];

        // Iterate through the rest of the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Calculate current_max: either extend the previous subarray or start a new one at the current element
            current_max = Math.max(nums[i], current_max + nums[i]);

            // Update max_so_far if current_max is greater
            max_so_far = Math.max(max_so_far, current_max);
        }

        // Return the maximum sum found
        return max_so_far;
    }

    public static void main(String[] args) {
        maximum_subarray_20240126 solution = new maximum_subarray_20240126();

        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result1 = solution.maxSubArray(nums1);
        System.out.println("Test Case 1: " + result1); // Expected Output: 6

        // Test case 2
        int[] nums2 = {1};
        int result2 = solution.maxSubArray(nums2);
        System.out.println("Test Case 2: " + result2); // Expected Output: 1

        // Test case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        int result3 = solution.maxSubArray(nums3);
        System.out.println("Test Case 3: " + result3); // Expected Output: 23

        // Test case 4
        int[] nums4 = {-1, -2, -3};
        int result4 = solution.maxSubArray(nums4);
        System.out.println("Test Case 4: " + result4); // Expected Output: -1

        // Test case 5
        int[] nums5 = {-2, -1};
        int result5 = solution.maxSubArray(nums5);
        System.out.println("Test Case 5: " + result5); // Expected Output: -1
    }
}

/*
Time and Space Complexity:

Time Complexity: O(n) - The algorithm iterates through the input array once.

Space Complexity: O(1) - The algorithm uses a constant amount of extra space (max_so_far and current_max), regardless of the size of the input array.

Reasoning:

The solution uses Kadane's Algorithm, which is a dynamic programming approach.  It maintains two variables:

- `current_max`:  The maximum sum ending at the current position in the array.  It's updated by taking the maximum of either the current element itself (starting a new subarray) or the current element added to the previous `current_max` (extending the previous subarray).
- `max_so_far`: The overall maximum sum found so far. It's updated whenever `current_max` is greater than the current `max_so_far`.

This approach ensures that at each position, we're considering both the possibility of starting a new subarray or extending an existing one, allowing us to find the global maximum subarray sum efficiently.
*/
