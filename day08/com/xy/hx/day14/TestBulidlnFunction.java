package com.xy.hx.day14;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestBulidlnFunction {
   /* public static void main1(String[] args) {
        Function<Integer,String>
    }

    public static void main2(String[] args) {
        Supplier<String> supplier=()->{
            return "hello,world";
        };*/
   public static void main(String[] args) {
       Predicate<String> predicate="##123shdbs"::startsWith;
       System.out.println(predicate.test("##"));
   }

    }











    //把函数当成参数来传递
//    public static void print(Function<Integer,String>function,Integer p){
//        System.out.println(function.apply(p));
//    }
//    public static void print(Supplier<?>)
//}
