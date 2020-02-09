package com.me.linkedlist;

/**
 * @author: create by Rhine
 * @date:2020/2/9 22:46
 * @description: 单链表的反转 leetcode 206 https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        ListNode p = myReverseList(n1);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    /**
     * reverse list -- my solution
     *
     * @param head
     * @return
     */
    public static ListNode myReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p;
        ListNode q = head;
        while ((p = head.next) != null) {
            head.next = p.next;
            p.next = q;
            q = p;
        }

        return q;
    }

    /**
     * reverse list -- leetcode solution
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
