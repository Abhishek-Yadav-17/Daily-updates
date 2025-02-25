# Problem: Valid Parentheses
```python
# Problem Statement:
# Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
#
# An input string is valid if:
#
# 1. Open brackets must be closed by the same type of brackets.
# 2. Open brackets must be closed in the correct order.
# 3. Every close bracket has a corresponding open bracket of the same type.

# Solution:
def isValid(s: str) -> bool:
    """
    Checks if a string containing parentheses is valid.

    Args:
        s (str): The input string containing parentheses.

    Returns:
        bool: True if the string is valid, False otherwise.
    """
    stack = []  # Use a stack to keep track of open brackets.
    mapping = {")": "(", "}": "{", "]": "["}  # Map closing brackets to their corresponding opening brackets.

    for char in s:
        if char in mapping:  # If the character is a closing bracket
            top_element = stack.pop() if stack else '#' # Pop the top element from the stack if the stack is not empty, otherwise assign a dummy character '#'
            if mapping[char] != top_element:  # Check if the closing bracket matches the last open bracket
                return False
        else:  # If the character is an opening bracket
            stack.append(char)  # Push the opening bracket onto the stack

    return not stack  # If the stack is empty at the end, it means all brackets were closed correctly.

# Time and Space Complexity:
# Time Complexity: O(n), where n is the length of the string s. We iterate through the string once.
# Space Complexity: O(n) in the worst case, where n is the length of the string s. The stack can grow to the size of the input string if all characters are opening brackets.
# Test Cases:
print(isValid("()"))  # Output: True
print(isValid("()[]{}"))  # Output: True
print(isValid("(]"))  # Output: False
print(isValid("([)]"))  # Output: False
print(isValid("{[]}"))  # Output: True
print(isValid("")) # Output: True
print(isValid("[")) #Output: False
```