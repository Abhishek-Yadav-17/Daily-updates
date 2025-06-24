// Problem: Valid Parentheses
java
/**
 * LeetCode Problem: 20. Valid Parentheses
 *
 * Problem Statement:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */

import java.util.Stack;

public class valid_parentheses_20240227 {

    /**
     * Determines if the given string of parentheses is valid.
     *
     * @param s The string containing parentheses.
     * @return True if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Use a stack to keep track of the open brackets.
        Stack<Character> stack = new Stack<>();

        // Iterate through the string.
        for (char c : s.toCharArray()) {
            // If it's an open bracket, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If it's a close bracket, check if the stack is empty or if the top of the stack
            // is the corresponding open bracket.
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // No matching open bracket
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }

        // If the stack is empty at the end, it means all open brackets have been closed.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20240227 solution = new valid_parentheses_20240227();

        // Test cases
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

        String s6 = "]";
        System.out.println(s6 + ": " + solution.isValid(s6)); // Output: false
    }

    /**
     * Time Complexity: O(n), where n is the length of the string s. This is because we iterate through the string once.
     *
     * Space Complexity: O(n) in the worst case, where n is the length of the string s. In the worst case, the stack could contain all the open brackets in the string. For example, "(((((((".
     * Reason: Space is needed for the stack that could grow linearly with input string size in worst case
     */
}
