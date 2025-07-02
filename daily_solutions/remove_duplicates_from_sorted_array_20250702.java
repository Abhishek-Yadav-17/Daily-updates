// Problem: Remove Duplicates from Sorted Array
java
// filename: remove_duplicates_from_sorted_array_20240229.java

/**
 * LeetCode Problem 26: Remove Duplicates from Sorted Array
 *
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
 *     assert nums[i] == expectedNums[i];
 * }
 *
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class remove_duplicates_from_sorted_array_20240229 {

    /**
     * Removes duplicates from a sorted array in-place.
     *
     * @param nums The sorted array to remove duplicates from.
     * @return The number of unique elements in the array.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0; // Index to track the position of the next unique element

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the last unique element found
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++; // Move the uniqueIndex to the next position
                nums[uniqueIndex] = nums[i]; // Copy the current element to the next unique position
            }
        }

        // Return the number of unique elements (uniqueIndex + 1)
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        remove_duplicates_from_sorted_array_20240229 solution = new remove_duplicates_from_sorted_array_20240229();

        // Test case 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.print("Test Case 1: k = " + k1 + ", nums = [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i == k1 - 1 ? "" : ","));
        }
        System.out.println("]");

        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.print("Test Case 2: k = " + k2 + ", nums = [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i == k2 - 1 ? "" : ","));
        }
        System.out.println("]");

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = solution.removeDuplicates(nums3);
        System.out.print("Test Case 3: k = " + k3 + ", nums = [");
        for (int i = 0; i < k3; i++) {
            System.out.print(nums3[i] + (i == k3 - 1 ? "" : ","));
        }
        System.out.println("]");

        // Test case 4
        int[] nums4 = {};
        int k4 = solution.removeDuplicates(nums4);
        System.out.print("Test Case 4: k = " + k4 + ", nums = [");
        for (int i = 0; i < k4; i++) {
            System.out.print(nums4[i] + (i == k4 - 1 ? "" : ","));
        }
        System.out.println("]");

        // Test case 5
        int[] nums5 = {1,1,1,1,1};
        int k5 = solution.removeDuplicates(nums5);
        System.out.print("Test Case 5: k = " + k5 + ", nums = [");
        for (int i = 0; i < k5; i++) {
            System.out.print(nums5[i] + (i == k5 - 1 ? "" : ","));
        }
        System.out.println("]");
    }
}
// Time and Space Complexity:
// Time Complexity: O(n), where n is the length of the input array nums.  We iterate through the array once.
// Space Complexity: O(1), as we are modifying the array in-place and not using any extra space.
