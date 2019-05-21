package com.bittech.test;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class MyClass<T extends String,E> {
    private T t;
    private E e;
    
    public void setE(E e) {
        this.e = e;
    }
    
    public T getT() {
        return t;
    }
    
    public E getE() {
        return e;
    }
    
    public void setT(T t) {
        this.t = t;
    }
}
