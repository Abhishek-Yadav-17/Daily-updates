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
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 *
 */

import java.util.Stack;

public class valid_parentheses_20240127 {

    /**
     * Checks if a string of parentheses is valid.
     *
     * @param s The string to check.
     * @return True if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Use a stack to keep track of open brackets.
        Stack<Character> stack = new Stack<>();

        // Iterate over the string.
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the character is a closing bracket, check if the stack is empty.
                if (stack.isEmpty()) {
                    return false; // No corresponding opening bracket.
                }

                // Check if the closing bracket matches the opening bracket on the top of the stack.
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched brackets.
                }
            }
        }

        // If the stack is empty at the end, the string is valid.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20240127 solution = new valid_parentheses_20240127();

        // Test cases
        String s1 = "()";
        System.out.println(s1 + ": " + solution.isValid(s1)); // Output: true

        String s2 = "()[]{}";
        System.out.println(s2 + ": " + solution.isValid(s2)); // Output: true

        String s3 = "(]";
        System.out.println(s3 + ": " + solution.isValid(s3)); // Output: false

        String s4 = "{[]}";
        System.out.println(s4 + ": " + solution.isValid(s4)); // Output: true

        String s5 = "([)]";
        System.out.println(s5 + ": " + solution.isValid(s5)); // Output: false

        String s6 = "]";
        System.out.println(s6 + ": " + solution.isValid(s6)); // Output: false

        String s7 = "(";
        System.out.println(s7 + ": " + solution.isValid(s7)); // Output: false

    }

    /**
     *
     * Time Complexity: O(n), where n is the length of the string s.  We iterate through the string once.  The stack operations (push and pop) take constant time.
     *
     * Space Complexity: O(n) in the worst case, where n is the length of the string s.  In the worst-case scenario (e.g., "((((((("), all the characters in the string are opening brackets, and they will all be pushed onto the stack. In the best-case scenario (e.g., "()()()()"), the maximum stack size is still proportional to the number of opening brackets, which can be up to n/2.
     *
     *
     */
}
