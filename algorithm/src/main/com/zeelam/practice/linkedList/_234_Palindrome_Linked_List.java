package com.zeelam.practice.linkedList;

public class _234_Palindrome_Linked_List {

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    if (head.next.next == null) return head.val == head.next.val;

    ListNode middleNode = findMiddle(head);
    ListNode inversedHead = inverseList(middleNode.next);

    while (inversedHead != null) {
      if (head.val != inversedHead.val) return false;
      inversedHead = inversedHead.next;
      head = head.next;
    }
    return true;
  }

  private ListNode inverseList(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode tmp = head.next;
      head.next = newHead;
      newHead = head;
      head = tmp;
    }
    return newHead;
  }

//  private ListNode inverseList(ListNode head) {
//    if (head == null || head.next == null) return head;
//    ListNode newHead = new ListNode(0);
//    while (head != null) {
//      ListNode tmp = head.next.next;
//      head.next.next = head;
//      head.next = null;
//
//      head = head.next;
//    }
//    return newHead.next;
//  }

  private ListNode findMiddle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

}
