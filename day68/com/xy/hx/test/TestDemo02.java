package com.xy.hx.test;
//编写程序实现下面的逻辑：
//
//有两个链表，每个链表代表一个正整数，
// 正整数的每个位按逆序存储在链表中，
//
// 要求：求出这两个正整数的和，和按照链表的形式表示。

public class TestDemo02 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode plusAB(ListNode a, ListNode b) {
            if (a == null)
                return b;
            if (b == null)
                return a;
            ListNode head = new ListNode(0);
            ListNode temp = head;
            int sum = 0;
            while (a != null || b != null || sum != 0) {//之所以判断sum!=0，当l1和l2遍历完，如果还有进位，需要处理
                if (a != null) {
                    sum += a.val;
                    a = a.next;
                }
                if (b != null) {
                    sum += b.val;
                    b = b.next;
                }
                temp.next = new ListNode(sum % 10);
                sum /= 10;
                temp = temp.next;
            }
            return head.next;
        }
    }
}

