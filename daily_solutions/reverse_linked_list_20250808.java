// Problem: Reverse Linked List
java
/**
 * LeetCode Problem 206: Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class reverse_linked_list_20240125 {

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
     * Space Complexity: O(1), as we are only using a constant amount of extra space for pointers.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize the previous pointer to null
        ListNode curr = head;  // Initialize the current pointer to the head
        ListNode next = null;  // Initialize the next pointer to null

        while (curr != null) {
            next = curr.next;  // Store the next node
            curr.next = prev;  // Reverse the pointer of the current node
            prev = curr;       // Move the previous pointer to the current node
            curr = next;       // Move the current pointer to the next node
        }

        return prev; // The previous pointer is now the head of the reversed list
    }

    public static void main(String[] args) {
        reverse_linked_list_20240125 solution = new reverse_linked_list_20240125();

        // Test case 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead1 = solution.reverseList(head1);
        System.out.print("Reversed List 1: ");
        printList(reversedHead1); // Expected Output: 5 4 3 2 1

        // Test case 2
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode reversedHead2 = solution.reverseList(head2);
        System.out.print("Reversed List 2: ");
        printList(reversedHead2); // Expected Output: 2 1

        // Test case 3
        ListNode head3 = new ListNode(1);
        ListNode reversedHead3 = solution.reverseList(head3);
        System.out.print("Reversed List 3: ");
        printList(reversedHead3); // Expected Output: 1

        // Test case 4 (Empty List)
        ListNode head4 = null;
        ListNode reversedHead4 = solution.reverseList(head4);
        System.out.print("Reversed List 4: ");
        printList(reversedHead4); // Expected Output: (empty list - prints nothing)
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
