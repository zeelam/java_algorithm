package com.zeelam.practice.stack;

import java.util.Stack;

/**
 * 224. Basic Calculator
 * https://leetcode.com/problems/basic-calculator/
 *
 * Given a string s representing an expression, implement a basic calculator to evaluate it.
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 */
public class _224_Basic_Calculator {

    public int calculate(String s) {
        s = "(" + s + ")";
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            if (c == ')') {
                int sum = 0;
                int num = 0;
                int position = 0;
                while (!stack.peek().equals("(")) {
                    String top = stack.pop();
                    if (top.equals("+") || top.equals("-")) {
                        if (top.equals("+")) {
                            sum += num;
                        } else {
                            sum -= num;
                        }
                        num = 0;
                        position = 0;
                    } else {
                        num += (int) (Integer.parseInt(top) * Math.pow(10, position));
                        position++;
                    }
                }
                stack.pop();
                stack.push(String.valueOf(sum + num));
            } else {
                stack.push(String.valueOf(c));
            }
        }
        int result = 0;
        for (String str : stack) {
            result += Integer.parseInt(str);
        }
        return result;
    }

}
