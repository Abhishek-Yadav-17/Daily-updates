// Problem: Valid Parentheses

/**
 * LeetCode Problem 20: Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 */

import java.util.Stack;

public class valid_parentheses {

    /**
     * Determines if a string containing parentheses is valid.
     *
     * @param s The string to validate.
     * @return True if the string is valid, false otherwise.
     *
     * Time Complexity: O(n), where n is the length of the string. We iterate through the string once.
     * Space Complexity: O(n) in the worst case, where n is the length of the string. This occurs when the string contains only opening brackets.
     */
    public boolean isValid(String s) {
        // Use a stack to keep track of opening brackets.
        Stack<Character> stack = new Stack<>();

        // Iterate through the string.
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If it's a closing bracket, check if the stack is empty.
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket.
                }

                // Check if the closing bracket matches the top of the stack.
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched brackets.
                }
            }
        }

        // If the stack is empty, all brackets were matched.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses solution = new valid_parentheses();

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

        String s6 = "";
        System.out.println(s6 + ": " + solution.isValid(s6)); // Output: true

        String s7 = "(";
        System.out.println(s7 + ": " + solution.isValid(s7)); // Output: false

        String s8 = "){";
        System.out.println(s8 + ": " + solution.isValid(s8)); // Output: false
    }
}
