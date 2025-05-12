// Problem: Remove Duplicates from Sorted Array
java
// filename: remove_duplicates_from_sorted_array_20231027.java

/**
 * Problem Statement:
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 *
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Clarification:
 *
 * Confused why the return value is an integer but your answer is an array?
 *
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
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 */
class RemoveDuplicatesFromSortedArray_20231027 {

    /**
     * Removes duplicate elements from a sorted array in-place.
     *
     * @param nums The sorted array.
     * @return The new length of the array after removing duplicates.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int insertIndex = 1; // Index to insert the next unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Check if the current element is different from the previous
                nums[insertIndex] = nums[i]; // If different, copy it to the insertIndex
                insertIndex++; // Increment the insertIndex
            }
        }
        return insertIndex; // Return the new length of the array
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_20231027 solution = new RemoveDuplicatesFromSortedArray_20231027();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: nums = [");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i]);
            if (i < len1 - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("], length = " + len1);


        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: nums = [");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i]);
            if (i < len2 - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("], length = " + len2);

        // Test case 3: Empty array
        int[] nums3 = {};
        int len3 = solution.removeDuplicates(nums3);
        System.out.println("Test Case 3: nums = [], length = " + len3); // Expected length = 0

        // Test case 4: Array with all same elements
        int[] nums4 = {1, 1, 1, 1, 1};
        int len4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: nums = [");
        for (int i = 0; i < len4; i++) {
            System.out.print(nums4[i]);
            if (i < len4 - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("], length = " + len4); // Expected length = 1
    }
}
// Time and Space Complexity Analysis:

// Time Complexity: O(n), where n is the length of the array.  We iterate through the array once.
// Space Complexity: O(1). We are modifying the array in-place, using only constant extra space.
