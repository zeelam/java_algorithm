package com.zeelam.practice.stack;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */
public class _150_Evaluate_Reverse_Polish_Notation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (token.equals("+")) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(second + first);
                }
                if (token.equals("-")) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(second - first);
                }
                if (token.equals("*")) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(second * first);
                }
                if (token.equals("/")) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(second / first);
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
