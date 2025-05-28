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

// filename: merge_two_sorted_lists_20240229.java

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

public class merge_two_sorted_lists_20240229 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val).append(" ");
                current = current.next;
            }
            return sb.toString().trim();
        }
    }

    /**
     * Merges two sorted linked lists into one sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merging process.
        ListNode dummy = new ListNode(-1);
        // Tail pointer to keep track of the last node in the merged list.
        ListNode tail = dummy;

        // Iterate while both lists have elements.
        while (list1 != null && list2 != null) {
            // Compare the values of the current nodes in both lists.
            if (list1.val <= list2.val) {
                // Append the smaller node from list1 to the merged list.
                tail.next = list1;
                // Move the list1 pointer to the next node.
                list1 = list1.next;
            } else {
                // Append the smaller node from list2 to the merged list.
                tail.next = list2;
                // Move the list2 pointer to the next node.
                list2 = list2.next;
            }
            // Move the tail pointer to the newly added node.
            tail = tail.next;
        }

        // If one of the lists is exhausted, append the remaining elements of the other list.
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        // Return the head of the merged list (excluding the dummy node).
        return dummy.next;
    }


    /**
     * Main method for testing the mergeTwoLists function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        merge_two_sorted_lists_20240229 solution = new merge_two_sorted_lists_20240229();

        // Test case 1
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode mergedList1 = solution.mergeTwoLists(list1, list2);
        System.out.println("Test Case 1: " + mergedList1); // Expected: 1 1 2 3 4 4

        // Test case 2
        ListNode list3 = null;
        ListNode list4 = null;
        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        System.out.println("Test Case 2: " + (mergedList2 == null ? "null" : mergedList2.toString())); // Expected: null

        // Test case 3
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        System.out.println("Test Case 3: " + mergedList3); // Expected: 0

        //Test case 4
        ListNode list7 = new ListNode(5);
        ListNode list8 = new ListNode(1, new ListNode(2, new ListNode(4)));
         ListNode mergedList4 = solution.mergeTwoLists(list7, list8);
        System.out.println("Test Case 4: " + mergedList4); // Expected: 1 2 4 5
    }

    /**
     * Time and Space Complexity Analysis:
     *
     * Time Complexity: O(m + n), where m and n are the lengths of list1 and list2, respectively.
     * The `while` loop iterates at most m + n times, comparing and merging nodes from both lists.
     *
     * Space Complexity: O(1). We are creating a dummy node, but the space used for the merged list is reused from existing lists.
     * We don't allocate new nodes proportional to m+n. The space complexity is dominated by the pointers and constant variables used during the merge process.
     */
}
