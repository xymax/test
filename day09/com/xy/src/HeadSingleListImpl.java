/**
 * Created with IntelliJ IDEA.
 * Description:  带头结点的循环单链表
 * User: GAOBO
 * Date: 2019-04-20
 * Time: 14:42
 */
public class HeadSingleListImpl implements ICLinked{
    //节点类
    class Node {
        private int data;
        private Node next;
        //头结点
        public Node() {
            this.data = -1;
        }
        //数据节点
        public Node(int data) {
            this.data = data;
        }
    }
    private Node head;
    public HeadSingleListImpl() {
        this.head = new Node();
        this.head.next = this.head;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }

    @Override
    public void addLast(int data) {
        Node cur = this.head;
        while (cur.next != this.head) {
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }
    //index-1的位置
    private Node searchIndex(int index) {
        checkIndex(index);
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if(index < 0 || index > getLength()) {
            throw new UnsupportedOperationException("index不合法");
        }
    }

    @Override
    public boolean addIndex(int index,int data) {
        Node pre = searchIndex(index);
        Node node = new Node(data);
        node.next = pre.next;
        pre.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head.next;
        while(cur != this.head) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //如果找不到返回空
    private Node searchPre(int key) {
        Node pre = this.head;
        //......
        while(pre.next != this.head) {
            if(pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        Node pre = searchPre(key);
        if(pre == null) {
            throw new UnsupportedOperationException("没有" +
                    "key这个关键字");
        }
        Node del = pre.next;
        int oldData = del.data;
        pre.next = del.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur != this.head) {
            if(cur.data == key) {
                pre.next = cur.next;
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        //cur指向第一个数据节点
        Node cur = this.head.next;
        while(cur != this.head) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while(cur != this.head) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        //防止内存泄漏
        while(this.head.next != this.head) {
            Node cur = this.head.next;

            this.head.next = cur.next;
        }
        //头结点置为空
        this.head = null;
    }
}
