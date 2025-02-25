// Problem: Valid Parentheses

/**
 * Problem Statement:
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

import java.util.Stack;

class ValidParentheses {

    /**
     * Determines if a string containing parentheses is valid.
     *
     * @param s The input string containing parentheses.
     * @return True if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Use a stack to keep track of open parentheses.
        Stack<Character> stack = new Stack<>();

        // Iterate through the string.
        for (char c : s.toCharArray()) {
            // If it's an open parenthesis, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If it's a close parenthesis, check if the stack is empty or if the top of the stack
                // doesn't match the close parenthesis.
                if (stack.isEmpty()) {
                    return false; // No matching open parenthesis.
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false; // Mismatched parentheses.
                }
            }
        }

        // If the stack is empty at the end, it means all open parentheses have been matched.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();

        // Test cases
        String s1 = "()";
        System.out.println(s1 + ": " + validator.isValid(s1)); // Output: true

        String s2 = "()[]{}";
        System.out.println(s2 + ": " + validator.isValid(s2)); // Output: true

        String s3 = "(]";
        System.out.println(s3 + ": " + validator.isValid(s3)); // Output: false

        String s4 = "([)]";
        System.out.println(s4 + ": " + validator.isValid(s4)); // Output: false

        String s5 = "{[]}";
        System.out.println(s5 + ": " + validator.isValid(s5)); // Output: true

        String s6 = "";
        System.out.println(s6 + ": " + validator.isValid(s6)); // Output: true

        String s7 = "(";
        System.out.println(s7 + ": " + validator.isValid(s7)); // Output: false
    }
}
/*
Time and Space Complexity:
Time Complexity: O(n), where n is the length of the string s. We iterate through the string once.

Space Complexity: O(n) in the worst case, where n is the length of the string s. This happens when the string contains only opening parentheses, which will all be pushed onto the stack.  In the best case (e.g. "()()()"), the stack grows and shrinks, and in some cases, can have a minimal size relative to n, but the worst case remains O(n).
*/
