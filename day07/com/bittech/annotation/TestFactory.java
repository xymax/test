package com.bittech.annotation;

/**
 * Author: secondriver
 * Created: 2019/5/21
 */
public class TestFactory {
    
    public static void main(String[] args) {
        
        Fruit fruit = Factory.getFruit();
        if (fruit != null) {
            fruit.eat();
        }
        
    }
}
