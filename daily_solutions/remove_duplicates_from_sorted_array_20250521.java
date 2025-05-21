// Problem: Remove Duplicates from Sorted Array
java
// filename: remove_duplicates_from_sorted_array_20240229.java

/**
 * LeetCode Problem 26: Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
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
 *
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return length = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively. It doesn't matter what you leave beyond the returned length.
 *
 *
 * Constraints:
 * 0 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
class RemoveDuplicatesFromSortedArray_20240229 {

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

        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray_20240229 solution = new RemoveDuplicatesFromSortedArray_20240229();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: Length = " + len1 + ", Array = [");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + (i == len1 - 1 ? "" : ", "));
        }
        System.out.println("]");

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: Length = " + len2 + ", Array = [");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + (i == len2 - 1 ? "" : ", "));
        }
        System.out.println("]");

        // Test case 3
        int[] nums3 = {1,2,3};
        int len3 = solution.removeDuplicates(nums3);
        System.out.print("Test Case 3: Length = " + len3 + ", Array = [");
        for (int i = 0; i < len3; i++) {
            System.out.print(nums3[i] + (i == len3 - 1 ? "" : ", "));
        }
        System.out.println("]");

        // Test case 4
        int[] nums4 = {};
        int len4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: Length = " + len4 + ", Array = [");
        for (int i = 0; i < len4; i++) {
            System.out.print(nums4[i] + (i == len4 - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}

// Time and Space Complexity:
// Time Complexity: O(n), where n is the length of the input array.  We iterate through the array once.
// Space Complexity: O(1), because we are modifying the array in-place and not using any extra space.
