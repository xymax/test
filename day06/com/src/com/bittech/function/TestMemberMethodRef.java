package com.bittech.function;

/**
 * Author: secondriver
 * Created: 2019/5/14
 */
public class TestMemberMethodRef {
    
    public static void main(String[] args) {
        
        IUtil2<String> iUtil2 = new IUtil2<String>() {
            @Override
            public String switchParam() {
                return "Hello".toUpperCase();
            }
        };
        System.out.println(iUtil2.switchParam());
        
        //String  成员方法   toUpperCase()
        IUtil2<String> iUtil21 = "Hello"::toUpperCase;
        System.out.println(iUtil21.switchParam());
    }
    
}

// y = f();
@FunctionalInterface
interface IUtil2<R> {
    //String toUpperCase();
    R switchParam();
}