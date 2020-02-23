package com.me.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: create by Rhine
 * @date:2020/2/23 10:40
 * @description: 循环链表 leetcode 141 https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class CycleLinkedList {

    /**
     * my solution
     *
     * @param head
     * @return
     */
    public boolean myHasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            } else {
                set.add(curr);
            }

            curr = curr.next;
        }

        return false;
    }

    /**
     * leetcode solution
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
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
