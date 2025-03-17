// Problem: Remove Duplicates from Sorted Array
java
/**
 * LeetCode Problem: 26. Remove Duplicates from Sorted Array
 *
 * Problem Statement:
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means that modifying the input array will be known to the caller.
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

// filename: remove_duplicates_from_sorted_array_20240105.java

public class remove_duplicates_from_sorted_array_20240105 {

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

        int insertIndex = 1; // Index to insert the next unique element. Start at index 1 because the first element is always unique.

        // Iterate through the array, starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous element,
            // it's a unique element, so we insert it at the insertIndex.
            if (nums[i] != nums[i - 1]) {
                nums[insertIndex] = nums[i];
                insertIndex++; // Increment insertIndex to prepare for the next unique element.
            }
        }

        return insertIndex; // The new length of the array after removing duplicates.
    }

    public static void main(String[] args) {
        remove_duplicates_from_sorted_array_20240105 solution = new remove_duplicates_from_sorted_array_20240105();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: New length = " + len1 + ", Modified array = ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: New length = " + len2 + ", Modified array = ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int len3 = solution.removeDuplicates(nums3);
        System.out.print("Test Case 3: New length = " + len3 + ", Modified array = ");
        for (int i = 0; i < len3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println();

        // Test case 4
        int[] nums4 = {};
        int len4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: New length = " + len4 + ", Modified array = ");
        for (int i = 0; i < len4; i++) {
            System.out.print(nums4[i] + " ");
        }
        System.out.println();

        // Test case 5
        int[] nums5 = {1,1,1};
        int len5 = solution.removeDuplicates(nums5);
        System.out.print("Test Case 5: New length = " + len5 + ", Modified array = ");
        for (int i = 0; i < len5; i++) {
            System.out.print(nums5[i] + " ");
        }
        System.out.println();
    }
}

/**
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(n), where n is the length of the input array.
 *   The algorithm iterates through the array once to identify and move unique elements.
 *
 * Space Complexity: O(1).
 *   The algorithm operates in-place, modifying the input array directly without using any extra space
 *   that scales with the input size.  Only a constant amount of extra space is used for variables like
 *   'insertIndex' and the loop counter 'i'.
 */
