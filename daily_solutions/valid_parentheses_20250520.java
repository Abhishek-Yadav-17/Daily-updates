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
 *
 */

import java.util.Stack;

public class valid_parentheses_20240229 {

    /**
     * Determines if a string containing parentheses is valid.
     *
     * @param s The input string containing parentheses.
     * @return True if the string is valid, false otherwise.
     *
     * Time Complexity: O(n), where n is the length of the string. We iterate through the string once.
     * Space Complexity: O(n) in the worst case, where n is the length of the string. This happens when the string
     * consists of only opening parentheses, which are all pushed onto the stack. In the best case (empty string)
     * or evenly balanced cases the space is O(n/2) = O(n)
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
                    return false; // No matching opening parenthesis.
                }

                // Pop the top element from the stack.
                char top = stack.pop();

                // Check if the parentheses match.
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched parentheses.
                }
            }
        }

        // If the stack is empty, it means all opening parentheses have been closed.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20240229 solution = new valid_parentheses_20240229();

        // Test cases
        String s1 = "()";
        System.out.println(s1 + ": " + solution.isValid(s1)); // Expected: true

        String s2 = "()[]{}";
        System.out.println(s2 + ": " + solution.isValid(s2)); // Expected: true

        String s3 = "(]";
        System.out.println(s3 + ": " + solution.isValid(s3)); // Expected: false

        String s4 = "{[]}";
        System.out.println(s4 + ": " + solution.isValid(s4)); // Expected: true

        String s5 = "([)]";
        System.out.println(s5 + ": " + solution.isValid(s5)); // Expected: false

        String s6 = "{{[()]}}";
        System.out.println(s6 + ": " + solution.isValid(s6)); // Expected: true

        String s7 = "(";
        System.out.println(s7 + ": " + solution.isValid(s7)); // Expected: false

        String s8 = "";
        System.out.println(s8 + ": " + solution.isValid(s8)); // Expected: true
    }
}
