// Problem: Reverse Linked List
java
/**
 * LeetCode Problem 206: Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 */
public class reverse_linked_list_20240228 {

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
     * Time Complexity: O(n) - We iterate through the list once.
     * Space Complexity: O(1) - We use a constant amount of extra space.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize previous node as null
        ListNode curr = head; // Initialize current node as head
        ListNode next = null; // Initialize next node as null

        while (curr != null) {
            next = curr.next; // Store the next node
            curr.next = prev; // Reverse the pointer
            prev = curr; // Move prev to the current node
            curr = next; // Move current to the next node
        }
        head = prev; // Update head to the last node, which is the new head
        return head;
    }

    public static void main(String[] args) {
        reverse_linked_list_20240228 solution = new reverse_linked_list_20240228();

        // Test case 1: Empty list
        ListNode head1 = null;
        ListNode reversedHead1 = solution.reverseList(head1);
        printList(reversedHead1); // Output: (empty)

        // Test case 2: Single node list
        ListNode head2 = new ListNode(1);
        ListNode reversedHead2 = solution.reverseList(head2);
        printList(reversedHead2); // Output: 1

        // Test case 3: List with multiple nodes
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead3 = solution.reverseList(head3);
        printList(reversedHead3); // Output: 5 4 3 2 1
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
