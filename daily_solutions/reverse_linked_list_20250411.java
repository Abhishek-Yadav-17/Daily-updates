// Problem: Reverse Linked List
java
/**
 * LeetCode Problem 206: Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class reverse_linked_list_20240126 {

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
     * Reverses a singly linked list.
     *
     * @param head The head of the linked list.
     * @return The head of the reversed linked list.
     *
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * The algorithm iterates through each node in the list once.
     *
     * Space Complexity: O(1). The algorithm uses a constant amount of extra space, regardless of the input size.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize 'prev' to null, will become the new tail.
        ListNode current = head; // Initialize 'current' to the head of the list.
        ListNode next = null;    // Initialize 'next' to null.

        while (current != null) {
            next = current.next;   // Store the next node temporarily.
            current.next = prev;   // Reverse the pointer of the current node.
            prev = current;         // Move 'prev' one step forward to the current node.
            current = next;        // Move 'current' one step forward to the next node.
        }

        return prev; // 'prev' will be the new head of the reversed list.
    }

    public static void main(String[] args) {
        reverse_linked_list_20240126 solution = new reverse_linked_list_20240126();

        // Test Case 1: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead1 = solution.reverseList(head1);
        printLinkedList(reversedHead1); // Expected output: 5 4 3 2 1

        // Test Case 2: 1 -> 2 -> NULL
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode reversedHead2 = solution.reverseList(head2);
        printLinkedList(reversedHead2); // Expected output: 2 1

        // Test Case 3: NULL
        ListNode head3 = null;
        ListNode reversedHead3 = solution.reverseList(head3);
        printLinkedList(reversedHead3); // Expected output: (empty output)

        // Test Case 4: 1 -> NULL
        ListNode head4 = new ListNode(1);
        ListNode reversedHead4 = solution.reverseList(head4);
        printLinkedList(reversedHead4); // Expected output: 1
    }

    // Helper function to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
