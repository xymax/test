
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-04-18
 * Time: 14:36
 */
class TestMain {

    public static void createCut(MySingleList.Node headA, MySingleList.Node headB) {
        headA.next.next = headB.next.next;
    }

    public static MySingleList.Node getIntersectionNode
            (MySingleList.Node headA, MySingleList.Node headB) {
        MySingleList.Node pLong = headA;
        MySingleList.Node pShort = headB;
        int lenA = 0;
        while(pLong != null) {
            lenA++;
            pLong = pLong.getNext();
        }
        int lenB = 0;
        while(pShort != null) {
            lenB++;
            pShort = pShort.getNext();
        }
        pLong = headA;
        pShort = headB;

        int myLen = lenA-lenB;

        if(myLen < 0) {
            pLong = headB;
            pShort = headA;
            myLen = lenB-lenA;
        }
        for (int i = 0; i < myLen; i++) {
            pLong = pLong.getNext();
        }

        //起点相同了
        while (pLong != null && pShort != null && pLong != pShort) {
            pLong = pLong.getNext();
            pShort = pShort.getNext();
        }
        if(pLong == pShort && pLong != null && pShort != null){
            return pLong;
        }
        return null;
    }

    public static MySingleList.Node mergeTwoLists(
            MySingleList.Node headA, MySingleList.Node headB) {

        MySingleList mySingleList = new MySingleList();
        MySingleList.Node newHead = mySingleList.new Node(-1);
        MySingleList.Node tmpHead = newHead;
        while(headA != null && headB != null) {
            if(headA.getData() >= headB.getData()) {
                newHead.next = headB;
                newHead = headB;
                headB = headB.next;
            }else {
                newHead.next = headA;
                newHead = headA;
                headA = headA.next;
            }
        }
        if(headA != null) {
            newHead.next = headA;
        }
        if(headB != null) {
            newHead.next = headB;
        }
        return tmpHead.next;
    }

        public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(88);
        mySingleList.addFirst(88);
        mySingleList.addFirst(76);
        mySingleList.addFirst(30);
        mySingleList.addFirst(30);
        mySingleList.addFirst(12);
        mySingleList.addFirst(1);
        mySingleList.display();
        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(10);
        mySingleList2.addLast(12);
        mySingleList2.addLast(13);
        mySingleList2.addLast(14);
        mySingleList2.addLast(15);
        mySingleList2.addLast(16);
        mySingleList2.addLast(17);
        mySingleList2.display();
        System.out.println("=======================");
        MySingleList.Node cur =
                    mergeTwoLists(mySingleList.getHead(),mySingleList2.getHead());
            mySingleList.show(cur);

        /* createCut(mySingleList.getHead(),mySingleList2.getHead());
        mySingleList.display();
        mySingleList2.display();
        MySingleList.Node cur = getIntersectionNode(
                mySingleList.getHead(),mySingleList2.getHead());
        System.out.println(cur.getData());*/
    }


    public static void main4(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addFirst(88);
        mySingleList.addFirst(88);
        mySingleList.addFirst(76);
        mySingleList.addFirst(30);
        mySingleList.addFirst(30);
        mySingleList.addFirst(12);
        mySingleList.addFirst(1);
        mySingleList.display();
        MySingleList.Node cur = mySingleList.deleteDuplication();
        mySingleList.show(cur);


       /* MySingleList.Node cur = mySingleList.middleNode();
        System.out.println(cur.getData());

        mySingleList.createCycle();
        System.out.println(mySingleList.hasCycle());

        MySingleList.Node cur2 = mySingleList.detectCycle();
        System.out.println(cur2.getData());*/




        //MySingleList.Node cur2 = mySingleList.findKthToTail(8);
       // System.out.println(cur2.getData());

        //mySingleList.show(mySingleList.partition(55));
    }


    public static void main3(String[] args) throws InterruptedException {
        DoubleLinkedListImpl doubleLinkedList =
                new DoubleLinkedListImpl();
        doubleLinkedList.addIndex(0,1994);
        doubleLinkedList.addLast(40);
        doubleLinkedList.addFirst(10);
        doubleLinkedList.addFirst(40);
        doubleLinkedList.addFirst(30);
        doubleLinkedList.addFirst(40);

        doubleLinkedList.addLast(50);
        doubleLinkedList.addLast(60);
        //40 30 20 10 99 50 60
        doubleLinkedList.display();
        doubleLinkedList.addIndex(3,40);
        doubleLinkedList.display();
        doubleLinkedList.addIndex(9,40);
        doubleLinkedList.display();
        System.out.println("=====================");
        doubleLinkedList.clear();
        Thread.sleep(1000);

        //doubleLinkedList.removeAllKey(40);
        //doubleLinkedList.display();
       /* System.out.println(doubleLinkedList.remove(40));
        doubleLinkedList.display();

        System.out.println(doubleLinkedList.remove(1996));
        doubleLinkedList.display();
        System.out.println(doubleLinkedList.remove(10));
        doubleLinkedList.display();*/

    }

    //循环单链表的测试用例
    public static void main2(String[] args) throws InterruptedException {
        HeadSingleListImpl headSingleList = new
                HeadSingleListImpl();
        headSingleList.addFirst(10);
        headSingleList.addFirst(20);
        headSingleList.addFirst(30);
        headSingleList.addFirst(40);
        headSingleList.display();//40 30 20 10
        headSingleList.addLast(88);
        headSingleList.addLast(20);
        headSingleList.addLast(108);
        headSingleList.display();//40 30 20 10 88 98 108
        headSingleList.clear();
        Thread.sleep(1000);
        System.out.println("hello bit");

        /* headSingleList.addIndex(0,20);
        //77 40 30 20 10 88 98 108
        headSingleList.display();
        headSingleList.addIndex(8,20);
        //77 40 30  20 10 88 98 108  67
        headSingleList.display();
        headSingleList.addIndex(3,97);
        //77 40 30  97 20 10 88 98 108  67
        headSingleList.display();
        headSingleList.removeAllKey(20);
        headSingleList.display();*/
        /*System.out.println(headSingleList.contains(9999));
        System.out.println(headSingleList.remove(97));
        headSingleList.display();
        System.out.println(headSingleList.remove(77));
        headSingleList.display();
        System.out.println(headSingleList.remove(67));
        headSingleList.display();*/
    }

    //单链表的测试
    public static void main1(String[] args) throws InterruptedException {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addIndex(0,10);
        mySingleList.addIndex(1,99);
        mySingleList.addIndex(2,20);
        mySingleList.addIndex(3,30);
        mySingleList.addIndex(4,88);
        mySingleList.addLast(40);
        mySingleList.addIndex(6,88);
        //System.out.println(mySingleList.contains(21));
        mySingleList.display();//10 99 20 30 88 40 88
        MySingleList.Node res = mySingleList.reverseList();
        mySingleList.show(res);
        //mySingleList.clear();
        //Thread.sleep(1000);
        //System.out.println("hello bit");

        /*mySingleList.removeAllKey(88);
        mySingleList.display();*///10 99 20 30  40
       /* mySingleList.remove(10);
        mySingleList.display();//99 20 30 88 40 98
        mySingleList.remove(98);
        mySingleList.display();//99 20 30 88 40
        mySingleList.remove(30);
        mySingleList.display();//99 20 88 40*/

       /* mySingleList.addFirst(10);
        mySingleList.addFirst(20);
        mySingleList.addFirst(30);
        mySingleList.addFirst(40);
        mySingleList.addFirst(50);*/

    }
}
