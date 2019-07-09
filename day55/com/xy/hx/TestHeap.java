package com.xy.hx;

import java.util.Arrays;

public class TestHeap implements Heap {

    private int[] elem;
    private int useSide;
    private static final int DEFAULT_SIZE = 10;

    public TestHeap() {
        this.elem = new int[DEFAULT_SIZE];
        this.useSide = 0;
    }


    @Override
    public void AdjustDown(int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while (child < len) {
            //判断是否有右孩子，找到最大值下标。
            if (child + 1 < len && this.elem[child] < this.elem[child + 1]) {
                ++child;
            }
            if (elem[child] > elem[parent]) {
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }

    }

    @Override
    public void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.useSide++;
        }
        for (int i = (this.elem.length - 1 - 1) >> 1; i >= 0; i++) {
            AdjustDown(i, this.useSide);
        }
    }

    @Override
    public void AdjustUp(int child, int len) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }

        }
    }

    //判断是否是满的
    private boolean isFull() {
        return this.useSide == this.elem.length;
    }

    @Override
    public void pushHeap(int item) {
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.useSide] = item;
        this.useSide++;
        AdjustUp(this.useSide - 1, this.useSide);

    }

    @Override
    public int popHeap() {
        if (this.useSide == 0) {
            throw new UnsupportedOperationException("堆为空");
        }
        int temp = 0;
        temp = this.elem[0];
        this.elem[0] = this.useSide - 1;
        this.useSide = temp;
        this.useSide--;
        AdjustDown(0, this.useSide);
        return 0;
    }


    // 返回堆顶元素，不删除数据元素
    @Override
    public int getHeapTop() {
        if (this.useSide == 0) {
            throw new UnsupportedOperationException("堆为空");
        }
        return this.elem[0];
    }


    //堆排序
    @Override
    public void HeapSort() {
        int end = this.useSide - 1;
        while (end > 0) {
            int temp = 0;
            temp = this.elem[0];
            this.elem[0] = this.useSide - 1;
            this.useSide = temp;
            AdjustDown(0, end);
            end--;
        }
    }

    @Override
    public void show() {
        for (int i = 0; i < this.useSide; i++) {
            System.out.println(this.elem[i] + " ");
        }
    }
}
