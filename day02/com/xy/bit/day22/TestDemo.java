package com.xy.bit.day22;

public class TestDemo {
    public static MySingListImpl.Node getIntersectionNode(MySingListImpl.Node headA, MySingListImpl.Node headB) {
        MySingListImpl.Node pLong = headA;
        MySingListImpl.Node pShort = headB;
        int lenA = 0;
        while (pLong != null) {
            lenA++;
            pLong = pLong.getNext();
        }
        int lenB = 0;
        while (pShort != null) {
            lenB++;
            pLong = pShort.getNext();
        }
        pLong = headA;
        pShort = headB;
        int myLen = lenA - lenB;//A链表和B链表的差值。
        if (myLen < 0) {
            pLong = headB;
            pShort = headA;
            myLen = lenB - lenA;
        }
        for (int i = 0; i < myLen; i++) {
            pLong = pLong.getNext();//起点相同了。
        }
        while (pLong != null && pShort != null && pLong != pShort) {
            pLong = pLong.getNext();
            pShort = pShort.getNext();
        }
        if (pLong == pShort && pLong != null && pShort != null) {
            return pLong;
        }
        return null;
    }
}









