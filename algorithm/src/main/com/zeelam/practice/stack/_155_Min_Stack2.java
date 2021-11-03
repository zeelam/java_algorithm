package com.zeelam.practice.stack;

import java.util.Stack;

/**
 * 155. Min Stack
 * https://leetcode-cn.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _155_Min_Stack2 {

  private ListNode head;

  public _155_Min_Stack2() {
    head = new ListNode(0, Integer.MAX_VALUE, null);
  }

  public void push(int val) {
    head = new ListNode(val, Math.min(val, head.min), head);
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }

  public static class ListNode {
    public int val;
    public int min;
    public ListNode next;

    public ListNode(int val, int min, ListNode next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }

}
