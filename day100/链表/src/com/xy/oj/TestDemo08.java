package com.xy.oj;

/*
*
*
* 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。

给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。

测试样例：
1->2->2->1
返回：true
* */


import java.util.Stack;

public class TestDemo08 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public boolean chkPalindrome(ListNode A) {
        //定义一个栈，利用先进后出的原则，其实就是将链表反转了。
        Stack<Integer> stack=new Stack<>();
        ListNode p=A;
        ListNode q=A;
        while(q!=null){
            stack.push(q.val);
            q=q.next;
        }
        while(p!=null){
            int a=stack.pop();
            if(a!=p.val){
                return false;
            }
            p=p.next;
        }
        return true;

    }
}
