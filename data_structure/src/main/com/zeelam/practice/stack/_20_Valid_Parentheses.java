package com.zeelam.practice.stack;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class _20_Valid_Parentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (!stack.isEmpty()){
                if (c == ')' && !stack.pop().equals('(')) return false;
                if (c == ']' && !stack.pop().equals('[')) return false;
                if (c == '}' && !stack.pop().equals('{')) return false;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
