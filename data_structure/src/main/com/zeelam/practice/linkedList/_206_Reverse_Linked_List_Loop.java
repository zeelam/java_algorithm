package com.zeelam.practice.linkedList;
/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 206. Reverse Linked List
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _206_Reverse_Linked_List_Loop {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newList = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = newList;
            newList = node;
            node = temp;
        }
        return newList;
    }

}
