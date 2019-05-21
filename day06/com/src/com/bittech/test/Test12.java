package com.bittech.test;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class Test12 {
    public static void main(String[] args) {
        Message<String> message = new Message<>();
        message.setMessage("你是最棒的");
        fun(message);
    }
    
    private static void fun(Message<? super String> message) {
        message.setMessage("你好");
        System.out.println(message.getMessage());
    }
}
