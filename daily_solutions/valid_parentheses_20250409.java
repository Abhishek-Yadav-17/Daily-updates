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
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class valid_parentheses_20240228 {

    /**
     * Checks if a string containing parentheses is valid.
     *
     * @param s The input string containing parentheses.
     * @return True if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        // Use a stack to keep track of open brackets.
        Deque<Character> stack = new LinkedList<>();

        // Use a map to store the corresponding closing bracket for each open bracket.
        Map<Character, Character> bracketMap = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );

        // Iterate through the string.
        for (char c : s.toCharArray()) {
            // If the character is an open bracket, push it onto the stack.
            if (bracketMap.containsKey(c)) {
                stack.push(c);
            } else {
                // If the character is a closing bracket, check if the stack is empty or if the top of the stack
                // does not match the closing bracket.
                if (stack.isEmpty() || bracketMap.get(stack.pop()) != c) {
                    return false;
                }
            }
        }

        // If the stack is empty at the end, the string is valid.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        valid_parentheses_20240228 solution = new valid_parentheses_20240228();

        // Test cases
        String s1 = "()";
        System.out.println("'" + s1 + "' is valid: " + solution.isValid(s1)); // Output: true

        String s2 = "()[]{}";
        System.out.println("'" + s2 + "' is valid: " + solution.isValid(s2)); // Output: true

        String s3 = "(]";
        System.out.println("'" + s3 + "' is valid: " + solution.isValid(s3)); // Output: false

        String s4 = "{[]}";
        System.out.println("'" + s4 + "' is valid: " + solution.isValid(s4)); // Output: true

        String s5 = "([)]";
        System.out.println("'" + s5 + "' is valid: " + solution.isValid(s5)); // Output: false

        String s6 = "";
        System.out.println("'" + s6 + "' is valid: " + solution.isValid(s6)); // Output: true
    }

    /**
     * Time Complexity: O(n), where n is the length of the input string. This is because we iterate through the string once.
     *
     * Space Complexity: O(n) in the worst-case scenario, where n is the length of the input string. This is because the stack
     * could potentially store all the open brackets in the string if they are all open brackets. For example, "(((((".
     * In the best-case scenario, such as an empty string, the space complexity would be O(1) because the stack remains empty.
     * The Map bracketMap holds a constant number of entries, therefore, it does not affect the overall space complexity.
     * The reasoning behind the complexities:
     *
     * Time Complexity:
     * The code iterates through the input string 's' exactly once.  Each operation within the loop (checking the character,
     * pushing onto the stack, popping from the stack, and comparing characters) takes constant time, O(1). Therefore, the overall
     * time complexity is directly proportional to the length of the string 's', resulting in O(n).
     *
     * Space Complexity:
     * The space used by the algorithm depends primarily on the stack 'stack'. In the worst-case scenario, the string 's' might
     * contain only opening brackets, such as "(((".  In this case, all the opening brackets would be pushed onto the stack.
     * Therefore, the stack could grow up to the size of the input string 's', resulting in O(n) space complexity. The map
     * used for storing the bracket pairs occupies constant space as the size remains fixed regardless of the input string length.
     * Consequently, it does not contribute to the asymptotic space complexity.
     */
}
