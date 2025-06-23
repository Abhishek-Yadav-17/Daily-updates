// Problem: Valid Parentheses
java
// filename: valid_parentheses_20240229.java

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

class valid_parentheses_20240229 {

    /**
     * Checks if a string containing parentheses is valid.
     *
     * @param s The input string containing parentheses.
     * @return True if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Use a stack to keep track of open brackets.
        Stack<Character> stack = new Stack<>();

        // Iterate over the characters in the string.
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack.
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If the character is a closing bracket, check if the stack is empty.
                if (stack.isEmpty()) {
                    return false; // No matching open bracket.
                }

                // Pop the top element from the stack.
                char top = stack.pop();

                // Check if the closing bracket matches the opening bracket.
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false; // Mismatched brackets.
                }
            }
        }

        // If the stack is empty at the end, the string is valid.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20240229 solution = new valid_parentheses_20240229();

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

        String s7 = "]";
        System.out.println(s7 + ": " + solution.isValid(s7)); // Output: false
    }
}

/*
 * Time Complexity: O(n), where n is the length of the string s. We iterate over the string once.
 *
 * Space Complexity: O(n) in the worst case, where n is the length of the string s. The stack can grow to a maximum size of n/2 if the string contains only opening brackets. In the best case, it would be O(1) if the string contains consecutive pairs like "()()".
 *
 * Reasoning:
 * The algorithm uses a stack to keep track of the opening brackets encountered so far. When a closing bracket is encountered, it checks if the stack is empty or if the top element of the stack matches the corresponding opening bracket. If either of these conditions is false, the string is invalid. If the stack is empty at the end of the iteration, the string is valid. The stack ensures that brackets are closed in the correct order.
 */
