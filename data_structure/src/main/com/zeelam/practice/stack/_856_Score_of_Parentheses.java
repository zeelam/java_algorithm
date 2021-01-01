package com.zeelam.practice.stack;

import java.util.Stack;

/**
 * 856. Score of Parentheses
 * https://leetcode.com/problems/score-of-parentheses/
 *
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 */
public class _856_Score_of_Parentheses {

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                Integer top = stack.pop();
                if (top == -1) {
                    stack.push(1);
                } else {
                    int sum = top;
                    while (stack.peek() != -1) {
                        sum += stack.pop();
                    }
                    stack.pop();
                    stack.push(sum * 2);
                }
            }
        }
        int score = 0;
        for (Integer integer : stack) {
            score += integer;
        }
        return score;
    }

}
