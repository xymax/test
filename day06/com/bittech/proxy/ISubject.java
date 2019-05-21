package com.bittech.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public interface ISubject {
    void eat();
}

//业务类
class RealSubject implements ISubject {
    @Override
    public void eat() {
        System.out.println("饿了要吃饭");
    }
}

class ProxySubject implements ISubject {
    private ISubject subject;
    
    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }
    
    public void prepare() {
        System.out.println("饭前收拾食材");
    }
    
    public void afterEat() {
        System.out.println("洗刷刷");
    }
    
    @Override
    public void eat() {
        this.prepare();
        this.subject.eat(); // 核心吃
        this.afterEat();
    }
}

class Factory {
    
    
    private Factory() {
    }
    
    public static <T> T getInstance(String realClassName) {
        try {
            Class cls = Class.forName(realClassName);
            return (T) cls.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("factory create object failed by class " + realClassName);
    }
    
    
    public static <T> T getInstance(String proxyClassName, Object target) {//target 被代理对象  目标对象  代理对象的构造方法中
        
        try {
            Class cls = Class.forName(proxyClassName);
            //限制：代理类只是实现代理接口
//            Class[] proxyClassInterfaces = cls.getInterfaces();
//            Class[] realClassInterfaces = target.getClass().getInterfaces();
            Constructor constructor = cls.getConstructor(cls.getInterfaces()[0]);
            
            return (T) constructor.newInstance(target);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("factory create object failed by class " + proxyClassName);
    }
    
    
    public static <T> T getProxyObject(String realClassName, String proxyClassName) {
        T realObject = Factory.getInstance(realClassName);
        T proxyObject = Factory.getInstance(proxyClassName, realObject);
        return proxyObject;
    }
}