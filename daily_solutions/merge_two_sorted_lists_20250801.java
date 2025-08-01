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

// filename: merge_two_sorted_lists_20240227.java

public class merge_two_sorted_lists_20240227 {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
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
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the head of the merged list.
        ListNode dummyHead = new ListNode(0);

        // Create a pointer to traverse the merged list.
        ListNode tail = dummyHead;

        // Iterate while both lists have elements.
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes in both lists.
            if (list1.val <= list2.val) {
                // Append the smaller node from list1 to the merged list.
                tail.next = list1;
                list1 = list1.next; // Move the list1 pointer forward
            } else {
                // Append the smaller node from list2 to the merged list.
                tail.next = list2;
                list2 = list2.next; // Move the list2 pointer forward
            }
            tail = tail.next; // Move the tail pointer of the merged list forward
        }

        // If one of the lists is exhausted, append the remaining nodes of the other list.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the head of the merged list (excluding the dummy node).
        return dummyHead.next;
    }

    /**
     * Helper method to print a linked list.
     *
     * @param head The head of the linked list to print.
     */
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        merge_two_sorted_lists_20240227 solution = new merge_two_sorted_lists_20240227();

        // Test case 1
        ListNode list1_1 = solution.new ListNode(1, solution.new ListNode(2, solution.new ListNode(4)));
        ListNode list2_1 = solution.new ListNode(1, solution.new ListNode(3, solution.new ListNode(4)));
        ListNode mergedList1 = solution.mergeTwoLists(list1_1, list2_1);
        System.out.print("Test Case 1: ");
        solution.printList(mergedList1); // Expected output: 1 1 2 3 4 4

        // Test case 2
        ListNode list1_2 = null;
        ListNode list2_2 = solution.new ListNode(0);
        ListNode mergedList2 = solution.mergeTwoLists(list1_2, list2_2);
        System.out.print("Test Case 2: ");
        solution.printList(mergedList2); // Expected output: 0

        // Test case 3
        ListNode list1_3 = null;
        ListNode list2_3 = null;
        ListNode mergedList3 = solution.mergeTwoLists(list1_3, list2_3);
        System.out.print("Test Case 3: ");
        solution.printList(mergedList3); // Expected output: (empty line)

        // Test case 4
        ListNode list1_4 = solution.new ListNode(5);
        ListNode list2_4 = solution.new ListNode(1, solution.new ListNode(2, solution.new ListNode(4)));
        ListNode mergedList4 = solution.mergeTwoLists(list1_4, list2_4);
        System.out.print("Test Case 4: ");
        solution.printList(mergedList4); // Expected output: 1 2 4 5
    }
    
    /**
     * Time Complexity: O(m + n), where 'm' and 'n' are the lengths of the two input lists.
     *  We iterate through both lists at most once.
     *
     * Space Complexity: O(1) (excluding the space for the new linked list).
     *  We use a constant amount of extra space for pointers, regardless of the input size.
     *  The space required for the new linked list is O(m + n), but this is typically not considered
     *  when analyzing the space complexity of in-place algorithms (which this is effectively doing by
     *  splicing together the existing nodes). If creating a new linked list the space complexity will be O(m+n).
     */
}
