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

// filename: merge_two_sorted_lists_20240121.java

public class merge_two_sorted_lists_20240121 {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
        public String toString() {
            return val + (next != null ? " -> " + next.toString() : "");
        }
    }

    /**
     * Merges two sorted linked lists.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     *
     * Time Complexity: O(m+n), where m and n are the lengths of list1 and list2 respectively.
     *                  We iterate through both lists once.
     * Space Complexity: O(1), we are only using constant extra space.
     *
     * Reasoning:
     * The algorithm iterates through both input lists, comparing the values of the current nodes in each list.
     * The smaller value is added to the merged list, and the corresponding pointer is advanced.  This continues
     * until one of the lists is exhausted.  Then, the remaining nodes from the other list are appended to the merged list.
     * A dummy node is used to simplify the creation of the merged list's head.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the code.
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy; // tail pointer to the tail of the result list

        // Iterate while both lists have elements.
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Append the remaining elements from list1, if any.
        if (list1 != null) {
            tail.next = list1;
        }

        // Append the remaining elements from list2, if any.
        if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next; // Return the head of the merged list (excluding the dummy node).
    }

     public static void main(String[] args) {
        merge_two_sorted_lists_20240121 solution = new merge_two_sorted_lists_20240121();

        // Test case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList1 = solution.mergeTwoLists(list1, list2);
        System.out.println("Merged List 1: " + mergedList1);

        // Test case 2
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        System.out.println("Merged List 2: " + mergedList2);

        // Test case 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        System.out.println("Merged List 3: " + mergedList3);

        // Test case 4
        ListNode list7 = new ListNode(5);
        ListNode list8 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode mergedList4 = solution.mergeTwoLists(list7, list8);
        System.out.println("Merged List 4: " + mergedList4);
    }
}
