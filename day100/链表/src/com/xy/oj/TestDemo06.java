package com.xy.oj;

/*
* 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前

给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
*
* */
public class TestDemo06 {

    public class ListNode {
        int val;
        ListNode next = null;


        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);

        ListNode leftHead = left;
        ListNode rightHead = right;

        while (pHead != null) {
            if (pHead.val < x) {
                left.next = pHead;
                left = left.next;
            } else {
                right.next = pHead;
                right = right.next;
            }
            pHead = pHead.next;
        }
        left.next = rightHead.next;
        right.next = null;
        return leftHead;

    }

}
