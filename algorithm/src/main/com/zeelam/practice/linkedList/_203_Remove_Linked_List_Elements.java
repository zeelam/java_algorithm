package com.zeelam.practice.linkedList;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 203. Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _203_Remove_Linked_List_Elements {

  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    ListNode newHead = new ListNode(0);
    ListNode newTail = newHead;
    while (head != null) {
      if (head.val != val) {
          newTail.next = head;
          newTail = head;
      }
      head = head.next;
    }
    newTail.next = null;
    return newHead;
  }


}
