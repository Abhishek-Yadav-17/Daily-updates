// Problem: Remove Duplicates from Sorted Array
java
/**
 * LeetCode Problem: 26. Remove Duplicates from Sorted Array
 *
 * Problem Statement:
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *  assert nums[i] == expectedNums[i];
 * }
 *
 */

// filename: remove_duplicates_from_sorted_array_20240228.java
public class remove_duplicates_from_sorted_array_20240228 {

    /**
     * Removes duplicates from a sorted array in-place.
     *
     * @param nums The sorted integer array.
     * @return The number of unique elements after removing duplicates.
     *
     * Time Complexity: O(n), where n is the length of the array. We iterate through the array once.
     * Space Complexity: O(1). We are modifying the array in-place and using constant extra space.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 1; // Index of the next unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        remove_duplicates_from_sorted_array_20240228 solution = new remove_duplicates_from_sorted_array_20240228();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: Unique elements count = " + k1 + ", Array = ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }
        System.out.println();

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: Unique elements count = " + k2 + ", Array = ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println();

        // Test case 3
        int[] nums3 = {1, 1, 1};
        int k3 = solution.removeDuplicates(nums3);
        System.out.print("Test Case 3: Unique elements count = " + k3 + ", Array = ");
        for (int i = 0; i < k3; i++) {
            System.out.print(nums3[i] + " ");
        }
        System.out.println();

        // Test case 4
        int[] nums4 = {};
        int k4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: Unique elements count = " + k4 + ", Array = ");
        for (int i = 0; i < k4; i++) {
            System.out.print(nums4[i] + " ");
        }
        System.out.println();
    }
}
