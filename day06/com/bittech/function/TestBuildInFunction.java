package com.bittech.function;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Author: secondriver
 * Created: 2019/5/14
 */
public class TestBuildInFunction {
    
    /*
        y = f(x) : 给入参 x  经过处理 返回结果 y
        y = f()  : 函数提过一个结果 y
        y(void) = f(x) : 给入参 x 处理它
        y(boolean) = f(x) :  给入参x 经过处理  返回boolean类的结果 (true  false)
    
     */
    
    public static void function() {
        Function<Integer, String> function = (x) -> {
            return String.valueOf(x);
        };
        function = String::valueOf;
        System.out.println(function.apply(10));
        
        //Lambda
        print((p) -> {
            System.out.println("xxx");
            return String.valueOf(p);
        }, 20);
    }
    
    public static void supplier() {
        Supplier<String> supplier = () -> {
            return "Hello World";
        };
        System.out.println(supplier.get());
        // T get();
        //   Object(); -> object
        print(Object::new);
    }
    
    public static void consumer() {
        Consumer<String> consumer = (x) -> {
            System.out.println(x);
        };
        consumer.accept("Hello");
        //System.out.println();
        consumer = System.out::println;
    }
    
    public static void predicate() {
        Predicate<String> predicate = (x) -> {
            if (x == null) {
                return false;
            } else {
                return x.length() > 2;
            }
        };
        System.out.println(predicate.test("hello"));
        System.out.println(predicate.test(""));
    }
    
    public static void main(String[] args) {
        
        // y = f()
        Supplier<String> supplier = () -> {
            Random random = new Random();
            return String.valueOf(random.nextInt(200));
        };
        
        // z = g(x)
        Predicate<Supplier<String>> predicate = (s) ->
        {
            String value = s.get();
            System.out.println(value);
            if (value == null) {
                return false;
            } else {
                return value.length() > 2;
            }
        };
        
        //z = g(f())
        boolean rs = predicate.test(supplier);
        System.out.println(rs);
        
    }
    
    public static void print(Function<Integer, String> function, Integer p) {
        System.out.println(function.apply(p));
    }
    
    public static void print(Supplier<?> supplier) {
        System.out.println(supplier.get());
    }
    
}
