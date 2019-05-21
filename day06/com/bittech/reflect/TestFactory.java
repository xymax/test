package com.bittech.reflect;

/**
 * Author: secondriver
 * Created: 2019/5/14
 */
public class TestFactory {
    
    public static void main(String[] args) {
        Fruit fruit = FruitFactory.getFruitInstance("com.bittech.reflect.Orange1");
        fruit.eat();
    }
}

interface Fruit {
    void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println("吃橘子");
        
    }
}

class FruitFactory {
    private FruitFactory() {
    }
    
    public static Fruit getFruitInstance(String className) {
        //new  -> 具体类型耦合
        try {
            Class classz = Class.forName(className);
            return (Fruit) classz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        //
        throw new RuntimeException(" Factory 生产不了 " + className);
    }
}