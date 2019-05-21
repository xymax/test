package com.bittech.test;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class Message<T> {
    private T message;
    
    public T getMessage() {
        return message;
    }
    
    public void setMessage(T message) {
        this.message = message;
    }
}
