package com.xy.oj;

import java.util.LinkedList;

/*
*
* 删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
*
*
* */



public class TestDemo01 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }




    //。首先检查头结点，如果结点值与val相等，那么把头指针后移；然后遍历链表，
    // 如果当前结点值与val相等，那么将前一个结点的指针指向后一个结点。
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode curr = head;
        ListNode prev = curr;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
