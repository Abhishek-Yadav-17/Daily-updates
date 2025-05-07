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

// filename: merge_two_sorted_lists_20240128.java

public class merge_two_sorted_lists_20240128 {

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
    }

    /**
     * Merges two sorted linked lists into a single sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     *
     * Time Complexity: O(m+n), where m and n are the lengths of list1 and list2, respectively.
     *                  This is because we iterate through both lists once.
     *
     * Space Complexity: O(1), because we are not using any extra space proportional to the input size.
     *                   We are only using a constant amount of extra space for the dummy node and the current node.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the insertion process.
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Iterate while both lists have elements.
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes in both lists.
            if (list1.val <= list2.val) {
                // If the value in list1 is smaller or equal, append it to the merged list.
                current.next = list1;
                list1 = list1.next;
            } else {
                // Otherwise, append the value from list2 to the merged list.
                current.next = list2;
                list2 = list2.next;
            }
            // Move the current pointer to the next node in the merged list.
            current = current.next;
        }

        // If one of the lists is not empty, append the remaining nodes to the merged list.
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the head of the merged list (excluding the dummy node).
        return dummy.next;
    }

    public static void main(String[] args) {
        merge_two_sorted_lists_20240128 solution = new merge_two_sorted_lists_20240128();

        // Test case 1:
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList1 = solution.mergeTwoLists(list1, list2);
        System.out.print("Test Case 1: ");
        printList(mergedList1); // Output: 1->1->2->3->4->4

        // Test case 2:
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        System.out.print("Test Case 2: ");
        printList(mergedList2); // Output: null

        // Test case 3:
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        System.out.print("Test Case 3: ");
        printList(mergedList3); // Output: 0

         // Test case 4:
        ListNode list7 = new ListNode(5);
        ListNode list8 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode mergedList4 = solution.mergeTwoLists(list7, list8);
        System.out.print("Test Case 4: ");
        printList(mergedList4); // Output: 1->2->4->5
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println();
    }
}
