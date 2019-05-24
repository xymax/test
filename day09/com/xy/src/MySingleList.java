import org.omg.CORBA.PUBLIC_MEMBER;
import sun.plugin.cache.OldCacheEntry;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2019-04-18
 * Time: 21:07
 */
public class MySingleList implements ILinked{

    //节点
    class Node {
        private int data;
        public Node next;
        public Node(int data) {
            this.data = data;
            //this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }
    private Node head;

    public Node getHead() {
        return head;
    }

    public MySingleList(){
        this.head = null;
    }


    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        //第一次插入的时候，没有任何的数据节点
        if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        //write
        if(this.head == null) {
            this.head = node;
        }else {
            Node cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            //cur所指向的位置就是尾节点
            cur.next = node;
        }
    }
    //检查Index的合法性
    private void checkIndex(int index) {
        if(index < 0 || index > getLength()) {
            throw new UnsupportedOperationException("Index不合法");
        }
    }
    //找到index-1的位置  函数返回该位置的节点引用
    private Node searchIndex(int index) {
        int count = 0;
        Node cur = this.head;
        while(count < index-1){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        //头插法
        if(index == 0) {
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //查找关键字Key的前驱
    //如果找不到返回null
    private Node searchPre(int key) {
        Node pre = this.head;
        //头结点是要删除的数据节点
        if(pre.data == key) {
            return this.head;
        }
        while(pre.next != null) {
            if(pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    @Override
    public int remove(int key) {
        int oldData = 0;
        Node pre = searchPre(key);
        if(pre == null) {
            throw new UnsupportedOperationException("不存在key节点");
        }
        //是头结点的时候
        if(pre == head && pre.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node del = pre.next;
        oldData = del.data;
        pre.next = del.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head == null) {
            return;
        }
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            count++;
            cur =cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        //this.head = null;
        while(this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }
    //单链表的逆置
    /*public Node reverseList() {
        Node cur = this.head;
        Node prev = null;
        Node reverseHead = null;
        while(cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }*/
    public Node reverseList(){
        Node cur = this.head;
        Node reverseHead = null;//新的头结点
        Node prev = null;//前驱
        while(cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }
    public void show(Node resHead) {
        Node cur = resHead;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    //OJ第三题：单链表的中间节点
    public Node middleNode() {
        int len = getLength()/2;
        Node cur = this.head;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }
    public Node findKthToTail(int k) {
        Node fast =this.head;
        Node slow= this.head;
        if(k<=0||k>getLength()||fast==null){
            return  null;
        }
        for(int i=0;i<k-1;i++){
            fast=fast.next;
        }

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return  slow;
    }

    /*public Node findKthToTail(int k) {
        Node fast = this.head;
        Node slow = this.head;
        if(fast == null || k <= 0) {// || k > getLength()
            System.out.println("没有这个节点");
            return null;
        }
        //fast-->k-1
        while(k-1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {
                System.out.println("没有这个节点");
                return null;
            }
        }
        //同时走
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }*/

    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        //pHead:用来遍历原有的单链表
        Node pHead = this.head;
        while(pHead != null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if(pHead.data < x) {
                if(beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = pHead;
                    beforeEnd = pHead;
                }
            }else {//>=x
                if(afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = pHead;
                    afterEnd = pHead;
                }
            }
            pHead = pHeadNext;
        }
        //原来的单链表走完了
        if(beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //构造一个环
    public void createCycle() {
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next.next.next;
    }

    public boolean hasCycle() {
    Node fast = this.head;
    Node slow = this.head;
    while(fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow){
            return true;
        }
    }
    return false;
    }

    /*  public boolean hasCycle() {
      Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;//break;
            }
        }
        return false;
    }*/
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = this.head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /*public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        slow = this.head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }*/

    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node tmpHead = newHead;
        Node cur = this.head;
        while (cur != null) {
            if(cur.next != null &&
                    cur.data == cur.next.data) {
                //cur所指向的节点是一个重复的节点
            while (cur.next != null && cur.data == cur.next.data) {
                cur = cur.next;
            }
            cur = cur.next;
            //cur--->
            newHead.next = cur;
            //在这个地方应该串起---》 2 2 3 3
            }else {
                //没有找到重复的节点
                newHead.next = cur;
                newHead = cur;
                cur = cur.next;
            }
        }
        return tmpHead.next;
    }

    public boolean chkPalindrome() {
        if(this.head == null) {
            return false;
        }else if(this.head.next == null) {
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node p = slow.next;
        Node pNext = p.next;
        while(p != null) {
            p.next = slow;
            slow = p;
            p = pNext;
            if(p != null) {
                pNext = p.next;
            }
        }
        while(head != slow) {
            if(head.data != slow.data) {
                return false;
            }
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
}
