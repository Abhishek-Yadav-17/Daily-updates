// Problem: Remove Duplicates from Sorted Array
java
/**
 * LeetCode Problem 26: Remove Duplicates from Sorted Array
 *
 * Problem Statement:
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Clarification:
 * Confused why the return value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means that a modification to the input array will be known to the caller.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function will be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */

// filename: remove_duplicates_from_sorted_array_20240229.java

public class remove_duplicates_from_sorted_array_20240229 {

    /**
     * Removes duplicates from a sorted array in-place.
     *
     * @param nums The sorted array.
     * @return The new length of the array after removing duplicates.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 1; // Index to track the next unique element's position. Start from index 1 as the first element is always unique.

        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous element, it's a unique element.
            if (nums[i] != nums[i - 1]) {
                nums[uniqueIndex] = nums[i]; // Place the unique element at the next available unique index.
                uniqueIndex++; // Increment the unique index.
            }
        }

        return uniqueIndex; // Return the new length of the array (number of unique elements).
    }

    public static void main(String[] args) {
        remove_duplicates_from_sorted_array_20240229 solution = new remove_duplicates_from_sorted_array_20240229();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println(", Length: " + len1); // Expected Output: 1 2, Length: 2


        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println(", Length: " + len2); // Expected Output: 0 1 2 3 4, Length: 5

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int len3 = solution.removeDuplicates(nums3);
        System.out.print("Test Case 3: ");
        for (int i = 0; i < len3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println(", Length: " + len3); // Expected Output: 1 2 3 4 5, Length: 5

        // Test case 4
        int[] nums4 = {1, 1, 1, 1, 1};
        int len4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: ");
        for (int i = 0; i < len4; i++) {
            System.out.print(nums4[i] + " ");
        }
        System.out.println(", Length: " + len4); // Expected Output: 1, Length: 1

        // Test case 5
        int[] nums5 = {};
        int len5 = solution.removeDuplicates(nums5);
        System.out.print("Test Case 5: ");
        for (int i = 0; i < len5; i++) {
            System.out.print(nums5[i] + " ");
        }
        System.out.println(", Length: " + len5); // Expected Output: , Length: 0

    }
}

/*
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(n), where n is the length of the input array `nums`.
 * The algorithm iterates through the array once to identify and move unique elements.
 *
 * Space Complexity: O(1).
 * The algorithm operates in-place, modifying the original array directly without using any extra space
 * that scales with the input size.  It uses only a constant amount of extra memory for the `uniqueIndex` variable.
 */
