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

// filename: merge_two_sorted_lists_20240124.java

public class merge_two_sorted_lists_20240124 {

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
     * Merges two sorted linked lists into one sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     *
     * Time Complexity: O(m + n), where m and n are the lengths of list1 and list2, respectively.
     *                  This is because we iterate through both lists once.
     *
     * Space Complexity: O(1), because we are using constant extra space. We are not creating new nodes,
     *                   but rather rearranging pointers of existing nodes. In the worst case,
     *                   if recursion is used, the space complexity would be O(m+n) due to the call stack.
     *                   But the solution below is iterative so uses O(1) space.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the head of the merged list.
        ListNode dummyHead = new ListNode(-1);

        // Create a pointer to traverse the merged list.
        ListNode tail = dummyHead;

        // Iterate while both lists have elements.
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes in both lists.
            if (list1.val <= list2.val) {
                // Append the smaller node from list1 to the merged list.
                tail.next = list1;
                list1 = list1.next;
            } else {
                // Append the smaller node from list2 to the merged list.
                tail.next = list2;
                list2 = list2.next;
            }
            // Move the tail pointer to the next node in the merged list.
            tail = tail.next;
        }

        // If one list is exhausted, append the remaining elements of the other list.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the head of the merged list (excluding the dummy node).
        return dummyHead.next;
    }

    public static void main(String[] args) {
        merge_two_sorted_lists_20240124 solution = new merge_two_sorted_lists_20240124();

        // Test case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        System.out.print("Test Case 1: ");
        printList(mergedList); // Expected output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 ->

        // Test case 2
        list1 = null;
        list2 = new ListNode(0);
        mergedList = solution.mergeTwoLists(list1, list2);
        System.out.print("Test Case 2: ");
        printList(mergedList); // Expected output: 0 ->

        // Test case 3
        list1 = null;
        list2 = null;
        mergedList = solution.mergeTwoLists(list1, list2);
        System.out.print("Test Case 3: ");
        printList(mergedList); // Expected output:

        //Test case 4
        list1 = new ListNode(5);
        list2 = new ListNode(1, new ListNode(2, new ListNode(4)));
        mergedList = solution.mergeTwoLists(list1, list2);
        System.out.print("Test Case 4: ");
        printList(mergedList);
    }


    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println();
    }
}
