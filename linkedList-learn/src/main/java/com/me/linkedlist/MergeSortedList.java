package com.me.linkedlist;

/**
 * @author: create by Rhine
 * @date:2020/3/1 20:23
 * @description: 合并两个有序列表 leetcode 21 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    public ListNode mergeTwoListsByRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            l1.next = mergeTwoListsByRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsByRecursion(l1, l2.next);
            return l2;
        }
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
