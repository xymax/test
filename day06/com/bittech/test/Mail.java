package com.bittech.test;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class Mail<T> {
    public void send(T t){
        System.out.println(t);
    }
    public <T> T send1(T t){
        return t;
    }
}
