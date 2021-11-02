package com.zeelam.practice.linkedList;

/**
 * 86. Partition List
 * https://leetcode-cn.com/problems/partition-list/
 *
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _86_Partition_List {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode partition(ListNode head, int x) {
    if (head == null) return null;

    ListNode leftHead = new ListNode(0);
    ListNode leftTail = leftHead;
    ListNode rightHead = new ListNode(0);
    ListNode rightTail = rightHead;

    while (head != null) {
      if (head.val < x) {
        leftTail.next = head;
        leftTail = head;
      } else {
        rightTail.next = head;
        rightTail = head;
      }
      head = head.next;
    }
    rightTail.next = null;
    leftTail.next = rightHead.next;
    return leftHead.next;
  }

}
