// Problem: Remove Duplicates from Sorted Array
java
/**
 * LeetCode Problem: 26. Remove Duplicates from Sorted Array
 *
 * Problem Statement:
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and return the new length.
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.
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

// removeduplicatesfromsortedarray_20240120.java
public class removeduplicatesfromsortedarray_20240120 {

    /**
     * Removes duplicates from a sorted array in-place.
     *
     * @param nums The sorted array to modify.
     * @return The new length of the array after removing duplicates.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // Handle empty or null array case.
        }

        int i = 0; // Index for the next non-duplicate element.

        for (int j = 1; j < nums.length; j++) {
            // If the current element is different from the previous non-duplicate element...
            if (nums[j] != nums[i]) {
                i++; // Move the index for the next non-duplicate element.
                nums[i] = nums[j]; // Copy the current element to the next non-duplicate position.
            }
        }

        return i + 1; // Return the length of the modified array.
    }

    public static void main(String[] args) {
        removeduplicatesfromsortedarray_20240120 solution = new removeduplicatesfromsortedarray_20240120();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("Length: " + len1); // Expected Output: 1 2 Length: 2

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println("Length: " + len2); // Expected Output: 0 1 2 3 4 Length: 5

        // Test case 3: empty array
        int[] nums3 = {};
        int len3 = solution.removeDuplicates(nums3);
        System.out.print("Test Case 3: ");
        for (int i = 0; i < len3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println("Length: " + len3); // Expected Output: Length: 0

        // Test case 4: single element
        int[] nums4 = {5};
        int len4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: ");
        for (int i = 0; i < len4; i++) {
            System.out.print(nums4[i] + " ");
        }
        System.out.println("Length: " + len4); // Expected Output: 5 Length: 1

        // Test case 5: all duplicates
        int[] nums5 = {1, 1, 1, 1, 1};
        int len5 = solution.removeDuplicates(nums5);
        System.out.print("Test Case 5: ");
        for (int i = 0; i < len5; i++) {
            System.out.print(nums5[i] + " ");
        }
        System.out.println("Length: " + len5); // Expected Output: 1 Length: 1
    }
}
/*
Time and Space Complexity:

Time Complexity: O(n), where n is the length of the input array `nums`.  We iterate through the array once with the index `j`.

Space Complexity: O(1), because we are modifying the array in-place.  We only use a few extra variables (i, j) which take constant space.
*/
