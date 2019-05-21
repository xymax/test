package com.bittech.test;

public class Plus {
    
    public ListNode plusAB(ListNode a, ListNode b) {
        //讲链表转换为整数
        int aValue = listNodeConvertIntValue(a);
        int bValue = listNodeConvertIntValue(b);
        //计算求和
        int sumValue = aValue + bValue;
        //将整数转换为链表
        return intValueConvertListNode(sumValue);
    }
    
    private int listNodeConvertIntValue(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = node;
        while (curr != null) {
            sb.append(curr.val);
            curr = curr.next;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
    
    private ListNode intValueConvertListNode(int value) {
        char[] charArray = String.valueOf(value).toCharArray();
        ListNode node = new ListNode(Integer.parseInt(String.valueOf(charArray[charArray.length - 1])));
        ListNode cur = node;
        //整数反转存储到链表中
        for (int i = charArray.length - 2; i >= 0; i--) {
            ListNode newNode = new ListNode(Integer.parseInt(String.valueOf(charArray[i])));
            cur.next = newNode;
            cur = newNode;
        }
        return node;
    }
    
}

class ListNode {
    int val;
    ListNode next = null;
    
    ListNode(int val) {
        this.val = val;
    }
}