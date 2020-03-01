package com.me.linkedlist;

/**
 * @author: create by Rhine
 * @date:2020/3/1 23:06
 * @description: 链表的中间节点 leetcode 876 https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast == null){
            return slow;
        }

        return slow.next;
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
