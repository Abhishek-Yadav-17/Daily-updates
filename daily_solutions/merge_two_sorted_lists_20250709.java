// Problem: Merge Two Sorted Lists
java
/**
 * LeetCode Problem: 21. Merge Two Sorted Lists
 *
 * Problem Statement:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */

/**
 * Filename: merge_two_sorted_lists_20240128.java
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class merge_two_sorted_lists_20240128 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Merges two sorted linked lists into one sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the logic of building the merged list.
        ListNode dummyNode = new ListNode(-1);
        // Tail pointer to keep track of the last node in the merged list.
        ListNode tail = dummyNode;

        // Iterate while both lists have elements.
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes in both lists.
            if (list1.val <= list2.val) {
                // Append the node from list1 to the merged list.
                tail.next = list1;
                // Move the list1 pointer to the next node.
                list1 = list1.next;
            } else {
                // Append the node from list2 to the merged list.
                tail.next = list2;
                // Move the list2 pointer to the next node.
                list2 = list2.next;
            }
            // Move the tail pointer to the newly added node.
            tail = tail.next;
        }

        // If one of the lists is exhausted, append the remaining nodes from the other list.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the head of the merged list (excluding the dummy node).
        return dummyNode.next;
    }

    /**
     * Main method for testing the mergeTwoLists function.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        merge_two_sorted_lists_20240128 solution = new merge_two_sorted_lists_20240128();

        // Test case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList1 = solution.mergeTwoLists(list1, list2);
        System.out.print("Test Case 1: ");
        printList(mergedList1); // Output: 1->1->2->3->4->4->NULL

        // Test case 2
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        System.out.print("Test Case 2: ");
        printList(mergedList2); // Output: NULL

        // Test case 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        System.out.print("Test Case 3: ");
        printList(mergedList3); // Output: 0->NULL
    }

    /**
     * Helper function to print the linked list.
     * @param head The head of the linked list.
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("NULL");
    }

    /**
     * Time and Space Complexity:
     *
     * Time Complexity: O(n + m), where n is the length of list1 and m is the length of list2.
     *                  We iterate through both lists at most once.
     *
     * Space Complexity: O(1).  We are using a constant amount of extra space. We are manipulating the existing lists in place.
     *                  Note that this assumes the call stack for the recursive method does not count towards the space complexity.
     *                  If the recursive stack were to be considered, the space complexity would be O(n + m)
     *                  in the worst case where the input lists are heavily skewed.
     */
}
