// Problem: Reverse Linked List
java
/**
 * LeetCode Problem: 206. Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

/**
 * filename: reverse_linked_list_20240126.java
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
     * @param head The head of the linked list to be reversed.
     * @return The head of the reversed linked list.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // Initialize previous node to null
        ListNode current = head; // Initialize current node to head
        ListNode next = null; // Initialize next node to null

        while (current != null) {
            next = current.next;  // Store the next node
            current.next = prev; // Reverse the pointer of current node
            prev = current;      // Move prev to current node
            current = next;      // Move current to next node
        }
        return prev; // prev will be the new head of the reversed list
    }

    /**
     * Prints the elements of a linked list.
     *
     * @param head The head of the linked list.
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reverse_linked_list_20240126 solution = new reverse_linked_list_20240126();

        // Test case 1: Empty list
        ListNode head1 = null;
        ListNode reversedHead1 = solution.reverseList(head1);
        System.out.print("Reversed List 1: ");
        printList(reversedHead1); // Output: Reversed List 1:

        // Test case 2: Single element list
        ListNode head2 = new ListNode(1);
        ListNode reversedHead2 = solution.reverseList(head2);
        System.out.print("Reversed List 2: ");
        printList(reversedHead2); // Output: Reversed List 2: 1

        // Test case 3: Multiple elements list
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        head3.next.next.next.next = new ListNode(5);
        System.out.print("Original List 3: ");
        printList(head3); // Output: Original List 3: 1 2 3 4 5
        ListNode reversedHead3 = solution.reverseList(head3);
        System.out.print("Reversed List 3: ");
        printList(reversedHead3); // Output: Reversed List 3: 5 4 3 2 1
    }
}

/**
 *
 * Time and Space Complexity:
 *
 * Time Complexity: O(n), where n is the number of nodes in the linked list.
 *   - We iterate through each node of the linked list once to reverse the pointers.
 *
 * Space Complexity: O(1)
 *   - We use a constant amount of extra space, regardless of the size of the linked list. We only use a few variables (prev, current, next) to store node references during the reversal process.
 *
 * Reasoning:
 * The iterative approach reverses the linked list by changing the 'next' pointer of each node to point to its previous node.
 * We maintain three pointers:
 *   - prev: Points to the previous node in the reversed list (initially null).
 *   - current: Points to the current node being processed (initially the head of the list).
 *   - next:  Temporarily stores the next node in the original list to prevent losing the list's structure.
 *
 * The algorithm iterates through the list, reversing the pointers one at a time. In each iteration:
 * 1. We store the next node in the 'next' variable.
 * 2. We reverse the 'next' pointer of the current node to point to the 'prev' node.
 * 3. We move 'prev' to the current node.
 * 4. We move 'current' to the next node.
 *
 * After the loop finishes, 'prev' will be pointing to the new head of the reversed list.
 */
