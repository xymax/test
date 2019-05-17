package com.xy.bit.day22;

public class MySingListImpl implements ILinked {
    class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
        public Node getNext() {
            return next;
        }
    }
    private Node head;
    public MySingListImpl() {
        this.head = null;
    }
    @Override
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    @Override
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    //检查index合法性
    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new UnsupportedOperationException("index不合法");
        }
    }
    private Node searchIndex(int index) {
        checkIndex(index);
        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }
    @Override
    public boolean addIndex(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.next;
        return true;
    }
    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    @Override
    public int remove(int key) {
        int oldData = 0;
        Node pre = searchIndex(key);
        if (pre == null) {
            throw new UnsupportedOperationException("不存在key节点");
        }
        if (pre == head && pre.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node del = pre.next;
        oldData = del.data;//先保存
        pre.next = del.next;//删除节点
        return oldData;
    }
    @Override
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        Node pre = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }
    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    @Override
    public void clear() {
        Node cur = this.head;
        while (this.head != null) {
            this.head.next = null;
            this.head = cur;
            cur = cur.next;
        }
    }
    public Node middleNode() {
        Node cur = this.head;
        int len = getLength() / 2;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }


    public Node FindKthToTail(int k) {
        Node fast = this.head;
        Node slow = this.head;
        if (k <= 0 || k > getLength()) {
            return null;
        }

        while (k - 1 > 0) {
            fast = fast.next;
            k--;
        }
        //同时走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;
        while (pHead != null) {
            if (pHead.data < x) {
                if (beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = pHead;

                } else {
                    beforeEnd.next = pHead;
                    beforeEnd = pHead;
                }
            } else {    //pHead>x
                if (afterStart == null) {
                } else {
                }
            }
        }
        return null;
    }




    //给定一个链表，判断链表中是否有环.
    //slow走一步。fast走两步，迟早相遇
    public boolean hasCycle(Node head) {
        Node fast = this.head;
        Node slow = this.head;//让fast和slow都开始从头走。
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;//退出循环。
            }
        }
        if (fast != null && slow != null && fast == slow) {//这是判断都不为null的情况
            return true;
        }
        return false;
    }


    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public Node detectCycle(Node head) {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = this.head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    //7. // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
    // 重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public Node deleteDuplication(Node pHead) {
        Node newHead = new Node(-1);   //新建一个虚拟节点。
        Node tmpHead = newHead;//保存newHead的位置。
        Node cur = this.head;
        while (cur != null) {
            if (cur.next != null//要保证cur.next也不能为null。
                    && cur.data == cur.next.data) {//判断cur的数据和cur.next数据是否相等。
                //当cur所指向的节点是一个重复的节点。
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;//cur向后走一步。
                }
                cur = cur.next;
                newHead.next = cur;
            } else {//没有找到重复的节点。
                newHead.next = cur;
                newHead = cur;
                cur = cur.next;
            }
        }
        return tmpHead.next;
    }

    //8.判断其是否为回文结构。1->2->2->1
    public boolean chkPalindrome(Node A) {
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;//走两步
            slow = slow.next;//走一步
        }
        Node p = slow.next;
        Node pNext = p.next;
        while (p != null) {
            p.next = slow;
            slow = p;
            p = pNext;
                if (p != null) {
                pNext = p.next;
            }
        }
        while (head != slow) {
            if (head.next != slow.next) {
                return false;
            }
            if (head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;

    }

    //反转链表
    public Node reverseList() {
        Node cur = this.head;
        Node prev = null;
        Node reverseHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }
}


