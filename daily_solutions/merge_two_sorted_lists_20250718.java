// Problem: Merge Two Sorted Lists
java
/**
 * LeetCode Problem 21: Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */

// filename: merge_two_sorted_lists_20240123.java
public class merge_two_sorted_lists_20240123 {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + (next != null ? " -> " + next.toString() : "");
        }
    }

    /**
     * Merges two sorted linked lists into one sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     *
     * Time Complexity: O(m + n), where m and n are the lengths of list1 and list2, respectively.
     *                  We need to iterate through both lists at most once.
     * Space Complexity: O(1). We are using constant extra space because we are modifying the existing lists in-place.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the logic.
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        // Iterate while both lists have elements.
        while (list1 != null && list2 != null) {
            // Choose the smaller element from the two lists and append it to the merged list.
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // Move the tail to the newly added node.
        }

        // Append the remaining elements from list1, if any.
        if (list1 != null) {
            tail.next = list1;
        }

        // Append the remaining elements from list2, if any.
        if (list2 != null) {
            tail.next = list2;
        }

        // Return the head of the merged list (excluding the dummy node).
        return dummy.next;
    }


    public static void main(String[] args) {
        merge_two_sorted_lists_20240123 solution = new merge_two_sorted_lists_20240123();

        // Test case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList1 = solution.mergeTwoLists(list1, list2);
        System.out.println("Merged List 1: " + mergedList1);  // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4

        // Test case 2
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        System.out.println("Merged List 2: " + mergedList2);  // Output: null

        // Test case 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        System.out.println("Merged List 3: " + mergedList3);  // Output: 0
    }
}
