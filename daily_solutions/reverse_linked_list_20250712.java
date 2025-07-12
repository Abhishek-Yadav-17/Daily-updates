// Problem: Reverse Linked List
java
/**
 * LeetCode Problem: 206. Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

/**
 * Filename: reverse_linked_list_20240229.java
 */

public class reverse_linked_list_20240229 {

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
     * Time Complexity: O(n), where n is the number of nodes in the list.
     *                  We iterate through each node once.
     * Space Complexity: O(1). We use constant extra space.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize 'prev' to null. This will be the new tail after reversing.
        ListNode curr = head; // Initialize 'curr' to the head of the list.
        ListNode next = null; // Temporary variable to store the next node.

        while (curr != null) {
            next = curr.next; // Store the next node before we change the current node's 'next'.
            curr.next = prev; // Reverse the pointer of the current node.
            prev = curr;      // Move 'prev' one step forward to the current node.
            curr = next;      // Move 'curr' one step forward to the next node.
        }

        return prev; // After the loop, 'prev' will be the new head of the reversed list.
    }

    public static void main(String[] args) {
        reverse_linked_list_20240229 solution = new reverse_linked_list_20240229();

        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode reversedHead1 = solution.reverseList(head1);
        printList(reversedHead1); // Expected Output: 5 -> 4 -> 3 -> 2 -> 1 -> null

        // Test case 2: 1 -> 2 -> null
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode reversedHead2 = solution.reverseList(head2);
        printList(reversedHead2); // Expected Output: 2 -> 1 -> null

        // Test case 3: null
        ListNode head3 = null;
        ListNode reversedHead3 = solution.reverseList(head3);
        printList(reversedHead3); // Expected Output: null

        // Test case 4: 1 -> null
        ListNode head4 = new ListNode(1);
        ListNode reversedHead4 = solution.reverseList(head4);
        printList(reversedHead4); // Expected Output: 1 -> null

    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
