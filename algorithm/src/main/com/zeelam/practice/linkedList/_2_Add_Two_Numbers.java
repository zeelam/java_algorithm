package com.zeelam.practice.linkedList;

/**
 * 2. Add Two Numbers
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _2_Add_Two_Numbers {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode dummyHead = new ListNode(0);
    ListNode last = dummyHead;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int v1 = 0;
      if (l1 != null) {
        v1 = l1.val;
        l1 = l1.next;
      }
      int v2 = 0;
      if (l2 != null) {
        v2 = l2.val;
        l2 = l2.next;
      }
      int sum = v1 + v2 + carry;
      carry = sum / 10;
      last.next = new ListNode(sum % 10);
      last = last.next;
    }
    if (carry > 0) {
      last.next = new ListNode(1);
    }
    return dummyHead.next;

  }

}
