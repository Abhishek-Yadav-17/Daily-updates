// Problem: Merge Two Sorted Lists
java
/**
 * LeetCode Problem 21: Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
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
     * Merges two sorted linked lists.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     *
     * Time Complexity: O(m + n), where m and n are the lengths of list1 and list2, respectively.
     *                  We iterate through both lists at most once.
     * Space Complexity: O(1). We are using constant extra space. We are creating a new list by rearranging the nodes of given lists
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merging process.
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

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

        // If one of the lists is not empty, append the remaining elements to the merged list.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // The merged list starts from the next node after the dummy node.
        return dummyHead.next;
    }

    public static void main(String[] args) {
        merge_two_sorted_lists_20240229 solution = new merge_two_sorted_lists_20240229();

        // Test case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList1 = solution.mergeTwoLists(list1, list2);
        printList(mergedList1); // Expected output: 1 1 2 3 4 4

        // Test case 2
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        printList(mergedList2); // Expected output:

        // Test case 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        printList(mergedList3); // Expected output: 0

        //Test case 4
        ListNode list7 = new ListNode(-9, new ListNode(3));
        ListNode list8 = new ListNode(5, new ListNode(7));
        ListNode mergedList4 = solution.mergeTwoLists(list7, list8);
        printList(mergedList4); // Expected output: -9 3 5 7
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
