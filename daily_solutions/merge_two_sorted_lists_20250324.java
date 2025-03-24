// Problem: Merge Two Sorted Lists
java
/**
 * LeetCode Problem 21: Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 *
 */

// filename: merge_two_sorted_lists_20240229.java

public class merge_two_sorted_lists_20240229 {

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
     * Merges two sorted linked lists into one sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merging process.
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead; // tail keeps track of the current node in the merged list.

        // Iterate while both lists have elements.
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes in the two lists.
            if (list1.val <= list2.val) {
                // If the value in list1 is smaller or equal, append it to the merged list.
                tail.next = list1;
                list1 = list1.next; // Move to the next node in list1.
            } else {
                // Otherwise, append the node from list2 to the merged list.
                tail.next = list2;
                list2 = list2.next; // Move to the next node in list2.
            }
            tail = tail.next; // Move the tail pointer to the newly added node.
        }

        // If one of the lists is exhausted, append the remaining elements of the other list.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the head of the merged list (excluding the dummy node).
        return dummyHead.next;
    }

    public static void main(String[] args) {
        merge_two_sorted_lists_20240229 solution = new merge_two_sorted_lists_20240229();

        // Test case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        printList(mergedList); // Expected output: 1->1->2->3->4->4

        // Test case 2
        ListNode list3 = null;
        ListNode list4 = null;
        mergedList = solution.mergeTwoLists(list3, list4);
        printList(mergedList); // Expected output:

        // Test case 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        mergedList = solution.mergeTwoLists(list5, list6);
        printList(mergedList); // Expected output: 0

        // Test case 4
         ListNode list7 = new ListNode(5);
         ListNode list8 = new ListNode(1, new ListNode(2, new ListNode(4)));
         mergedList = solution.mergeTwoLists(list7, list8);
         printList(mergedList); // Expected output: 1->2->4->5
    }

    // Helper function to print the linked list
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


    /**
     * Time Complexity: O(m + n), where m and n are the lengths of the two lists.
     * The algorithm iterates through both lists at most once.
     *
     * Space Complexity: O(1).
     * The algorithm uses a constant amount of extra space.  We are creating a new list by rearranging pointers, not creating a new copy.
     */
}
