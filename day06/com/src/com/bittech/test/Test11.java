package com.bittech.test;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class Test11 {
    public static void main(String[] args) {
        Mail<String> mail = new Mail<String>();
        mail.send("比特教育欢迎你");
        Integer x = mail.send1(10);
        System.out.println(x);
    }
}
