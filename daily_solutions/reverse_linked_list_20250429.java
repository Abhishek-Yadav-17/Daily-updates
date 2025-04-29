// Problem: Reverse Linked List
java
/**
 * LeetCode Problem: 206. Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class reverse_linked_list_20240123 {

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

        @Override
        public String toString() {
            return val + (next != null ? " -> " + next.toString() : "");
        }
    }

    /**
     * Reverses a singly linked list.
     *
     * @param head The head of the linked list.
     * @return The head of the reversed linked list.
     *
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     *                  We iterate through each node once.
     * Space Complexity: O(1), we use constant extra space.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            // Store the next node.
            next = current.next;

            // Reverse the pointer of the current node.
            current.next = prev;

            // Move prev and current one step forward.
            prev = current;
            current = next;
        }

        // prev is the new head of the reversed list.
        return prev;
    }

    public static void main(String[] args) {
        reverse_linked_list_20240123 solution = new reverse_linked_list_20240123();

        // Test case 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("Original list 1: " + head1);
        ListNode reversedHead1 = solution.reverseList(head1);
        System.out.println("Reversed list 1: " + reversedHead1);

        // Test case 2
        ListNode head2 = new ListNode(1, new ListNode(2));
        System.out.println("Original list 2: " + head2);
        ListNode reversedHead2 = solution.reverseList(head2);
        System.out.println("Reversed list 2: " + reversedHead2);

        // Test case 3: Empty list
        ListNode head3 = null;
        System.out.println("Original list 3: " + head3);
        ListNode reversedHead3 = solution.reverseList(head3);
        System.out.println("Reversed list 3: " + reversedHead3);

        // Test case 4: Single node list
        ListNode head4 = new ListNode(1);
        System.out.println("Original list 4: " + head4);
        ListNode reversedHead4 = solution.reverseList(head4);
        System.out.println("Reversed list 4: " + reversedHead4);
    }
}
