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

public class valid_parentheses_20240227 {

    /**
     * Determines if the input string of parentheses is valid.
     *
     * @param s The input string containing parentheses.
     * @return True if the string is valid, false otherwise.
     *
     * Time Complexity: O(n), where n is the length of the string s. We iterate through the string once.
     * Space Complexity: O(n) in the worst case, where n is the length of the string s. This occurs when the string contains only opening brackets,
     *                    in which case the stack will grow to a size of n.
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
                // If it's a closing bracket, check if the stack is empty or if the top of the stack doesn't match.
                if (stack.isEmpty()) {
                    return false; // No corresponding opening bracket.
                }

                char top = stack.pop();

                // Check if the brackets match
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched brackets.
                }
            }
        }

        // If the stack is empty, it means all brackets were matched.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20240227 solution = new valid_parentheses_20240227();

        // Test cases
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "{[]}";
        String s5 = "([)]";

        System.out.println(s1 + ": " + solution.isValid(s1));   // Output: true
        System.out.println(s2 + ": " + solution.isValid(s2));   // Output: true
        System.out.println(s3 + ": " + solution.isValid(s3));   // Output: false
        System.out.println(s4 + ": " + solution.isValid(s4));   // Output: true
        System.out.println(s5 + ": " + solution.isValid(s5));   // Output: false
    }
}
