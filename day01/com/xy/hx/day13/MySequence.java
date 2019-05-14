package com.xy.hx.day13;

public class MySequence implements ISequence {
    //第一步，定义它的属性和行为。
    private Object[] elem;
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;

    //提供构造方法
    public MySequence() {
        //初始化成员变量
        this.usedSize = 0;
        this.elem = new Object[DEFAULT_SIZE];
    }


    //判断是否为满的；
    public boolean isFull() {
        if (this.elem.length == this.usedSize) {
            return false;
        }
        return true;
    }


    @Override
    public boolean add(int pos, Object data) {
        //1.判断pos是否为满的。2.判断pos的合法性
        if (pos < 0 || pos > this.usedSize) {
            return false;
        }
        //是满的数组扩大为原来2倍
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        for (int i = this.usedSize - 1; i > pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
        return true;
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }


    @Override
    public int search(Object key) {
        //判断有没有
        if (key == null) {
            return -1;
        }

        //判断是否为空
        if (isEmpty()) {
            throw new UnsupportedOperationException("顺序表为空");
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean contains(Object key) {
        if (key == null) {
            return false;
        }
        if (isEmpty()) {
            throw new UnsupportedOperationException("顺序表为空");
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i].equals(key)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public Object getPos(int pos) {
        if (pos < 0 || pos > this.usedSize) {
            return null;
        }
        return this.elem[pos];
    }


    @Override
    public Object remove(Object key) {
        //删除之前先查找；
        int index = search(key);
        //如果查找不到1返回null。
        if (index == -1) {
            return null;
        }
        Object oldData = this.elem[index];
        int i = 0;
        for (i = index; i < this.usedSize - 1; i++) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[i + 1] = null;
        this.usedSize--;
        return oldData;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();

    }

    @Override
    public void clear() {
        for (int i = 0; i <this.usedSize ; i++) {
            this.elem[i]=0;
        }
        this.usedSize=0;
    }
}
