package com.xy.hx.test;

/*
 * 编写代码，以给定值x为基准将链表分割成两部分，
 * 所有⼩于x的结点排在⼤于或等于x的结点之前
 * */
public class TestDemo02 {
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode partition(ListNode pHead, int x) {
        if (pHead.next == null) {
            return pHead;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode j = dummyHead, i = dummyHead.next, i1 = dummyHead;
        for (; i != null; i = i.next, i1 = i1.next) {
            if (i.val < x && j.next.val >= x) {
                int temp = j.next.val;
                j.next.val = i.val;
                i.val = temp;
                j = j.next;
            }
        }
        return dummyHead.next;
    }
}
