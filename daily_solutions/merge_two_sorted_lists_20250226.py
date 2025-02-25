# Problem: Merge Two Sorted Lists
"""Problem Statement:

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Solution:
"""
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def mergeTwoLists(list1, list2):
    """
    Merges two sorted linked lists into one sorted linked list.

    Args:
        list1: The head of the first sorted linked list.
        list2: The head of the second sorted linked list.

    Returns:
        The head of the merged sorted linked list.
    """

    # Create a dummy node to serve as the head of the merged list.
    dummy = ListNode()
    tail = dummy  # Use tail to point to the last node in the merged list

    # Iterate through both lists until one of them is empty.
    while list1 and list2:
        # Compare the values of the current nodes in both lists.
        if list1.val <= list2.val:
            # Append the smaller value to the merged list.
            tail.next = list1
            list1 = list1.next  # Move to the next node in list1.
        else:
            tail.next = list2
            list2 = list2.next  # Move to the next node in list2

        tail = tail.next # Move the tail pointer to the new last node.

    # If one of the lists is not empty, append the remaining nodes to the merged list.
    if list1:
        tail.next = list1
    elif list2:
        tail.next = list2

    # Return the head of the merged list (excluding the dummy node).
    return dummy.next

# Time Complexity: O(m + n), where m and n are the lengths of the two lists.
#   We iterate through both lists at most once.
#
# Space Complexity: O(1).
#   We are using constant extra space. We are not creating any new nodes, only relinking existing nodes.
#   Note: If we consider the space used by the recursive stack in a recursive implementation, the space complexity would be O(m + n) in the worst case (when one list is much longer than the other), and O(min(m, n)) on average when the lengths are similar. However, this implementation is iterative and thus uses constant space.

# Test cases
# Create linked list from list of values
def createLinkedList(values):
    head = None
    tail = None
    for val in values:
        newNode = ListNode(val)
        if head is None:
            head = newNode
            tail = newNode
        else:
            tail.next = newNode
            tail = newNode
    return head

# Convert linked list to list of values
def linkedListToList(head):
    result = []
    current = head
    while current:
        result.append(current.val)
        current = current.next
    return result

# Test case 1
list1 = createLinkedList([1, 2, 4])
list2 = createLinkedList([1, 3, 4])
merged_list = mergeTwoLists(list1, list2)
print(linkedListToList(merged_list))  # Output: [1, 1, 2, 3, 4, 4]

# Test case 2
list1 = createLinkedList([])
list2 = createLinkedList([])
merged_list = mergeTwoLists(list1, list2)
print(linkedListToList(merged_list)) # Output: []

# Test case 3
list1 = createLinkedList([])
list2 = createLinkedList([0])
merged_list = mergeTwoLists(list1, list2)
print(linkedListToList(merged_list)) # Output: [0]

# Test case 4
list1 = createLinkedList([-9,3])
list2 = createLinkedList([5,7])
merged_list = mergeTwoLists(list1, list2)
print(linkedListToList(merged_list)) # Output: [-9, 3, 5, 7]