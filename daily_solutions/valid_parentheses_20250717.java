// Problem: Valid Parentheses
## Valid Parentheses

**Problem Statement:**

Given a string `s` containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

1.  Open brackets must be closed by the same type of brackets.
2.  Open brackets must be closed in the correct order.
3.  Every close bracket has a corresponding open bracket of the same type.

**Example 1:**

Input: s = "()"
Output: true

**Example 2:**

Input: s = "()[]{}"
Output: true

**Example 3:**

Input: s = "(]"
Output: false

**Constraints:**

*   `1 <= s.length <= 104`
*   `s` consists of parentheses only '()[]{}'.

java
// filename: valid_parentheses_20240229.java
import java.util.Stack;

class valid_parentheses_20240229 {

    /**
     * Determines if the input string of parentheses is valid.
     *
     * @param s The input string containing parentheses.
     * @return True if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Use a stack to store the opening parentheses.
        Stack<Character> stack = new Stack<>();

        // Iterate through the string.
        for (char c : s.toCharArray()) {
            // If it's an opening parenthesis, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If it's a closing parenthesis, check if the stack is empty.
                if (stack.isEmpty()) {
                    return false; // No matching opening parenthesis.
                }

                // Pop the top element from the stack.
                char top = stack.pop();

                // Check if the closing parenthesis matches the opening parenthesis.
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // Mismatched parentheses.
                }
            }
        }

        // If the stack is empty, it means all opening parentheses have been closed.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20240229 solution = new valid_parentheses_20240229();

        String s1 = "()";
        System.out.println(s1 + ": " + solution.isValid(s1)); // Output: true

        String s2 = "()[]{}";
        System.out.println(s2 + ": " + solution.isValid(s2)); // Output: true

        String s3 = "(]";
        System.out.println(s3 + ": " + solution.isValid(s3)); // Output: false

        String s4 = "([)]";
        System.out.println(s4 + ": " + solution.isValid(s4)); // Output: false

        String s5 = "{[]}";
        System.out.println(s5 + ": " + solution.isValid(s5)); // Output: true
    }
}


**Time and Space Complexity:**

*   **Time Complexity:** O(n), where n is the length of the input string `s`.  We iterate through the string once. Stack operations (push and pop) take O(1) time.
*   **Space Complexity:** O(n) in the worst-case scenario, where the input string contains only opening parentheses. In this case, the stack will store all the opening parentheses, and the stack size will be proportional to the length of the input string. In the best case, if the input string has a mix of opening and closing parentheses, or is just empty, it's O(1) because the stack could be mostly empty. However, O(n) accurately describes the worst-case space usage.

**Explanation:**

1.  **Stack Data Structure:** We use a stack to keep track of the opening parentheses. The stack follows the LIFO (Last-In, First-Out) principle, which is perfect for matching parentheses. The most recently opened parenthesis must be the first one to be closed.

2.  **Iteration:** We iterate through the input string character by character.

3.  **Opening Parentheses:** If we encounter an opening parenthesis ('(', '{', or '['), we push it onto the stack.

4.  **Closing Parentheses:** If we encounter a closing parenthesis (')', '}', or ']'), we check the following:
    *   **Empty Stack:** If the stack is empty, it means there's no corresponding opening parenthesis for this closing parenthesis, so the string is invalid.
    *   **Matching Parentheses:** We pop the top element from the stack. If the popped element doesn't match the closing parenthesis (e.g., closing parenthesis is ')' but the popped element is '['), the string is invalid.

5.  **Final Check:** After iterating through the entire string, if the stack is empty, it means all opening parentheses have been closed correctly, and the string is valid. If the stack is not empty, it means there are unmatched opening parentheses, and the string is invalid.