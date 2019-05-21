package com.bittech.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TestProxy {
    
    public static void main(String[] args) {
        /*
        ISubject realObject= new RealSubject();
        ISubject proxyObject = new ProxySubject(realObject);
        proxyObject.eat();
        */
        /*
        ISubject realObject= Factory.getInstance("com.bittech.proxy.RealSubject");
        ISubject proxyObject = Factory.getInstance("com.bittech.proxy.ProxySubject",realObject);
         */
        /*
        ISubject proxyObject = Factory.getProxyObject(
                "com.bittech.proxy.RealSubject",
                "com.bittech.proxy.ProxySubject"
        );
        proxyObject.eat();
         */
        
        System.out.println("动态代理");
        ISubject realSubject = new RealSubject();
        InvocationHandler handler = new RealSubjectHandler(realSubject);
        //代理对象
        ISubject proxySubject = (ISubject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                //动态生成的代理类的字节码需要类加载器，保证代理类和业务类在同一个类类加载器中
                
                new Class[]{ISubject.class, CharSequence.class},// 动态生成的代理类实现的接口，Proxy.newProxyInstance返回的代理对象（Object）向下转型
                handler//代理类动态生成的，无法动态生成业务增强，传入InvocationHandler接口的实例化对象
        );
        proxySubject.eat();
        
        System.out.println("============");
        System.out.println("类型：" + proxySubject.getClass());
        System.out.println("接口：" + Arrays.toString(proxySubject.getClass().getInterfaces()));
        System.out.println("父类:" + proxySubject.getClass().getSuperclass());
        
        System.out.println("=============");
        Constructor[] constructors = proxySubject.getClass().getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("=============");
        Method[] methods = proxySubject.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        
        //ByteCode
        //1. .java -> .class
        //2. .class  ASM   API
    }
}
