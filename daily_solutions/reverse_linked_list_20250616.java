// Problem: Reverse Linked List
java
/**
 * LeetCode Problem 206: Reverse Linked List
 *
 * Problem Statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

// filename: reverse_linked_list_20240229.java
public class reverse_linked_list_20240229 {

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
     * Time Complexity: O(n), where n is the number of nodes in the list.  We iterate through each node once.
     * Space Complexity: O(1), as we only use a constant amount of extra space for pointers.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // Store the next node
            curr.next = prev;    // Reverse the link: current node points to the previous
            prev = curr;          // Move the previous pointer forward
            curr = nextTemp;      // Move the current pointer forward
        }

        return prev; // prev will be the new head of the reversed list
    }


    public static void main(String[] args) {
        reverse_linked_list_20240229 solution = new reverse_linked_list_20240229();

        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode reversedHead1 = solution.reverseList(head1);
        printList(reversedHead1); // Expected output: 5 -> 4 -> 3 -> 2 -> 1 -> NULL

        // Test case 2: 1 -> 2 -> NULL
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode reversedHead2 = solution.reverseList(head2);
        printList(reversedHead2); // Expected output: 2 -> 1 -> NULL

        // Test case 3: NULL
        ListNode head3 = null;
        ListNode reversedHead3 = solution.reverseList(head3);
        printList(reversedHead3); // Expected output: NULL

        // Test case 4: 1 -> NULL
        ListNode head4 = new ListNode(1);
        ListNode reversedHead4 = solution.reverseList(head4);
        printList(reversedHead4); // Expected output: 1 -> NULL
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }
}
