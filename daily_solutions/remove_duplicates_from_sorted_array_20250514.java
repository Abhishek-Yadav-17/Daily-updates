// Problem: Remove Duplicates from Sorted Array
java
/**
 * LeetCode Problem 26: Remove Duplicates from Sorted Array
 *
 * Problem Statement:
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and return the new length.
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

// filename: remove_duplicates_from_sorted_array_20240104.java
public class remove_duplicates_from_sorted_array_20240104 {

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
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1; // Return the new length of the array
    }

    public static void main(String[] args) {
        remove_duplicates_from_sorted_array_20240104 solution = new remove_duplicates_from_sorted_array_20240104();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int len1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println("\nLength: " + len1); // Expected output: 1 2   Length: 2


        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println("\nLength: " + len2); // Expected output: 0 1 2 3 4   Length: 5

        // Test case 3: empty array
        int[] nums3 = {};
        int len3 = solution.removeDuplicates(nums3);
        System.out.println("Test Case 3: Length: " + len3); // Expected output: Length: 0

        // Test case 4: array with one element
        int[] nums4 = {5};
        int len4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: ");
        for (int i = 0; i < len4; i++) {
            System.out.print(nums4[i] + " ");
        }
        System.out.println("\nLength: " + len4); // Expected output: 5 Length: 1
    }
}

/*
 * Time and Space Complexity Analysis:
 *
 * Time Complexity: O(n), where n is the length of the input array.  We iterate through the array once.
 *
 * Space Complexity: O(1). We are modifying the array in-place and using only a constant amount of extra space.
 *
 * Reasoning:
 * The algorithm maintains two pointers, i and j.  The pointer i points to the index where the next non-duplicate element should be placed.
 * The pointer j iterates through the array.  If nums[i] and nums[j] are different, it means we have found a new unique element.
 * In this case, we increment i and copy nums[j] to nums[i].  If nums[i] and nums[j] are the same, we simply increment j to skip the duplicate.
 * At the end of the iteration, the subarray nums[0...i] contains all the unique elements, and i+1 is the new length of the array.  Because the problem
 * specifically asks to modify the array in-place, this approach satisfies the requirements and uses minimal space.
 */
