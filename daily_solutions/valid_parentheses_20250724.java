// Problem: Valid Parentheses
java
// Filename: valid_parentheses_20231027.java

/**
 * LeetCode Problem 20: Valid Parentheses
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

class valid_parentheses_20231027 {

    /**
     * Checks if a string containing parentheses is valid.
     *
     * @param s The input string containing parentheses.
     * @return True if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Use a stack to keep track of open brackets.
        Stack<Character> stack = new Stack<>();

        // Iterate through the string.
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If it's a closing bracket, check if the stack is empty or if the top of the stack doesn't match.
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // No matching open bracket.
                }

                char top = stack.pop(); // Get the top element from the stack.
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched brackets.
                }
            }
        }

        // If the stack is empty at the end, it means all brackets were properly closed.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20231027 solution = new valid_parentheses_20231027();

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
    }

    /**
     * Time Complexity: O(n), where n is the length of the string. This is because we iterate through the string once.
     * Space Complexity: O(n) in the worst case, where n is the length of the string. This occurs when the string contains only opening brackets. In this case, the stack will store all the opening brackets. In the average case, the space complexity will be less than O(n) because not all strings will have all opening brackets.
     */
}
