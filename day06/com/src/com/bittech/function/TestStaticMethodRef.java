package com.bittech.function;

/**
 * Author: secondriver
 * Created: 2019/5/14
 */
public class TestStaticMethodRef {
    
    public static void main(String[] args) {
        
        /**
         * IUtil1 函数接口 （函数）： Integer -> String
         *
         * String.valueOf(x) ： 面向对象内容， String类的静态方法
         *
         * IUtil1 -> Lambda表达式实现函数的具体逻辑
         *
         * IUtil1函数能够复用面向对象中已有的逻辑
         *
         */
//        IUtil1<Integer, String> iUtil1 = (p) -> {
//            //p 计算+字符拼接 => String
//            return String.valueOf(p);
//        };
        //iUtil1变量此时就是String.valueOf这个方法的别名
        // y  = f(x)
        // f -> { }
        // f = String::valueOf
        // f(x)
        IUtil1<Integer,String> iUtil1 = String::valueOf;
        System.out.println(iUtil1.convert(10));
        
    }
    
}

@FunctionalInterface
interface IUtil1<P, R> {
    
    /**
     * 将参数类型为Integer的参数转换为String
     * <p>
     * y = f(x)
     * x : Integer
     * y :  String
     * f : 装换逻辑（数学公式）
     *
     * @return
     */
//    String convert(Integer value);
    
    /**
     * y = f(x)
     * x : P
     * y : R
     * f : 转换逻辑（数学公式）
     *
     * @param p
     * @return
     */
    R convert(P p);
}