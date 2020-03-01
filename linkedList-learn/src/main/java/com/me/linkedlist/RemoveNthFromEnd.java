package com.me.linkedlist;

/**
 * @author: create by Rhine
 * @date:2020/3/1 21:42
 * @description: 删除列表的倒数第N个节点 leetcode 19 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {

    public ListNode myRemoveNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode slow = preHead;
        ListNode fast = preHead;
        int midNum = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            midNum++;
        }

        int listCount;
        if (fast == null) {
            listCount = 2 * midNum - 1;
        } else {
            listCount = 2 * midNum;
        }

        int m = listCount - n + 1;

        ListNode start;
        int startIndex;
        if (m > midNum) {
            start = slow;
            startIndex = midNum;
        } else {
            start = preHead;
            startIndex = 0;
        }

        while (startIndex < m - 1) {
            start = start.next;
            startIndex++;
        }

        start.next = start.next.next;

        return preHead.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode slow = preHead;
        ListNode fast = preHead;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return preHead.next;
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
