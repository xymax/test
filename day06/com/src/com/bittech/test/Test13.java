package com.bittech.test;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class Test13 {
    public static void main(String[] args) {
        Message<Integer> message1 = new Message<>();
        Message<String> message2 = new Message<>();
        System.out.println(message1.getClass()==message2.getClass());
    }
}
