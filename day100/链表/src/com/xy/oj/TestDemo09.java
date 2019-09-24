package com.xy.oj;

import java.util.Stack;

/*
*
*
* 编写一个程序，找到两个单链表相交的起始节点
*
* 注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。


* */
public class TestDemo09 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode t = null;
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }
        while (!stackA.empty() && !stackB.empty()) {
            if (stackA.peek() == stackB.peek())
                t = stackA.pop();
            stackB.pop();
        }
        return t;
    }
}
