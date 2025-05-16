// Problem: Valid Parentheses
java
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
 */

import java.util.Stack;

public class valid_parentheses_20240117 {

    /**
     * Checks if a string containing parentheses is valid.
     *
     * @param s The input string containing parentheses.
     * @return true if the string is valid, false otherwise.
     *
     * Time Complexity: O(n), where n is the length of the string. We iterate through the string once.
     * Space Complexity: O(n) in the worst case, where n is the length of the string.  This happens when the stack
     *                    stores all opening parentheses before finding any closing ones (e.g., "(((((((").
     */
    public boolean isValid(String s) {
        // Use a stack to keep track of opening parentheses.
        Stack<Character> stack = new Stack<>();

        // Iterate through the string.
        for (char c : s.toCharArray()) {
            // If it's an opening parenthesis, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If it's a closing parenthesis, check if the stack is empty.
                if (stack.isEmpty()) {
                    return false; // No corresponding opening parenthesis.
                }

                // Check if the closing parenthesis matches the top of the stack.
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false; // Mismatched parentheses.
                }
            }
        }

        // If the stack is empty at the end, it means all parentheses were matched.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20240117 solution = new valid_parentheses_20240117();

        // Test cases
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "{[]}";
        String s5 = "([)]";
        String s6 = "){";
        String s7 = "(((((((";


        System.out.println(s1 + ": " + solution.isValid(s1));   // Output: true
        System.out.println(s2 + ": " + solution.isValid(s2));   // Output: true
        System.out.println(s3 + ": " + solution.isValid(s3));   // Output: false
        System.out.println(s4 + ": " + solution.isValid(s4));   // Output: true
        System.out.println(s5 + ": " + solution.isValid(s5));   // Output: false
        System.out.println(s6 + ": " + solution.isValid(s6));   // Output: false
        System.out.println(s7 + ": " + solution.isValid(s7));   // Output: false
    }
}
