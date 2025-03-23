// Problem: Reverse Linked List
java
/**
 * LeetCode Problem 206: Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

 // filename: reverse_linked_list_20240127.java
public class reverse_linked_list_20240127 {

    /**
     * Definition for singly-linked list.
     */
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    /**
     * Reverses a singly linked list.
     *
     * @param head The head of the linked list.
     * @return The head of the reversed linked list.
     *
     * Time Complexity: O(n), where n is the number of nodes in the linked list.  We iterate through each node once.
     * Space Complexity: O(1), as we are using constant extra space for pointers.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize the previous pointer to null
        ListNode current = head; // Initialize the current pointer to the head
        ListNode next = null; // Initialize the next pointer to null

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the pointer of the current node
            prev = current; // Move the previous pointer to the current node
            current = next; // Move the current pointer to the next node
        }

        return prev; // The new head is the previous pointer after the loop finishes
    }

    public static void main(String[] args) {
        reverse_linked_list_20240127 solution = new reverse_linked_list_20240127();

        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead1 = solution.reverseList(head1);
        printLinkedList(reversedHead1); // Expected output: 5 -> 4 -> 3 -> 2 -> 1 -> null

        // Test case 2: 1 -> 2 -> null
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode reversedHead2 = solution.reverseList(head2);
        printLinkedList(reversedHead2); // Expected output: 2 -> 1 -> null

        // Test case 3: null
        ListNode head3 = null;
        ListNode reversedHead3 = solution.reverseList(head3);
        printLinkedList(reversedHead3); // Expected output: null

        // Test case 4: 1 -> null
        ListNode head4 = new ListNode(1);
        ListNode reversedHead4 = solution.reverseList(head4);
        printLinkedList(reversedHead4); // Expected output: 1 -> null
    }

    // Helper function to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
