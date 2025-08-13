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
 * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller.
 *
 * Internally you should do the following:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * // any modification to nums in the range [0, len - 1] will be visible to the caller.
 * // For example, if nums = [1,2,2,3,3,4], your function should return len = 4, and nums should be modified to [1,2,3,4].
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

        int i = 0; // Index for the next non-duplicate element
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1; // Return the length of the modified array
    }

    public static void main(String[] args) {
        remove_duplicates_from_sorted_array_20240229 solution = new remove_duplicates_from_sorted_array_20240229();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: Modified array: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println(", New length: " + len1);

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: Modified array: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println(", New length: " + len2);

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int len3 = solution.removeDuplicates(nums3);
        System.out.print("Test Case 3: Modified array: ");
        for (int i = 0; i < len3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println(", New length: " + len3);

        // Test case 4
        int[] nums4 = {};
        int len4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: Modified array: ");
        for (int i = 0; i < len4; i++) {
            if (nums4.length > 0)
                System.out.print(nums4[i] + " ");
        }
        System.out.println(", New length: " + len4);
    }
}

/*
 * Time and Space Complexity:
 *
 * Time Complexity: O(n), where n is the length of the input array. We iterate through the array once.
 *
 * Space Complexity: O(1). We modify the array in-place, using only constant extra space.
 *
 * Reasoning:
 * The solution uses a two-pointer approach. The 'i' pointer tracks the index of the next non-duplicate element, and the 'j' pointer iterates through the array. If the current element at 'j' is different from the element at 'i', it means we've found a new unique element. In that case, we increment 'i' and copy the element from 'j' to 'i'. Finally, we return 'i + 1', which represents the length of the modified array containing only unique elements. This approach avoids the need for extra space by modifying the array in place, which is essential to meet the problem constraint.
 */
