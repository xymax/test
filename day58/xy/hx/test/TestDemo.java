package com.xy.hx.test;

public class TestDemo {
    public static void main(String[] args) {

    }
    public void add(Byte b)
    {
        b=b++;
    }
    public void test(){
        Byte a= 127;
        Byte b= 127;
        add(++a);
        System.out.println(a+" ");
        add(b);
        System.out.println(b+" ");
    }
}
