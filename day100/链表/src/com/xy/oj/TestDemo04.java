package com.xy.oj;

/*
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * */
public class TestDemo04 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        //定义两个指向头结点的指针，一个指针先走k-1步，然后两个指针开始同时走，
        //当先走的指针走到最后一个结点时，后走的指针所指向的位置就是倒数第k个结点
        if (head == null || k <= 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}



/*
*

//用栈的先进后出特性来做，测试通过
import java.util.Stack;
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode list=null;
        ListNode tmp=head;
        int n=0;
        while(tmp!=null){     //先判断链表是否具有k个节点
            tmp=tmp.next;
            n++;
        }
        if(n<k){            //少于k个节点返回null
           return list;
        }

        while(head!=null){    //大于等于k个节点，则全压入栈，再出栈k次
           stack.push(head);
           head=head.next;
        }
        for(int j=k;j>0;j--){
         list=stack.pop();
        }
         return list;
    }
}

*
*
*
* */