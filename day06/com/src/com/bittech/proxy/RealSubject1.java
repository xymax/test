package com.bittech.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class RealSubject1 {
    
    void eat() {
        System.out.println("吃饭");
    }
    
    public static void main(String[] args) {
        //真实业务对象  被代理对象
        RealSubject1 realSubject1 = new RealSubject1();
        //增强的业务对象
        MethodInterceptor interceptor = new RealSubjectAdvance(realSubject1);
        //代理对象
        //enchaner生成代理对象
        Enhancer enhancer = new Enhancer();
        //代理类父类，处理逻辑
        enhancer.setSuperclass(realSubject1.getClass());
        enhancer.setCallback(interceptor);
        RealSubject1 proxyObject = (RealSubject1) enhancer.create();
        proxyObject.eat();
        System.out.println(proxyObject.getClass());
        
    }
    
}

//业务增强
class RealSubjectAdvance implements MethodInterceptor {
    
    private final Object target;
    
    RealSubjectAdvance(Object target) {
        this.target = target;
    }
    
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("吃饭前，做饭");
        Object returnValue = method.invoke(this.target, objects);
        System.out.println("吃饭后，洗碗");
        return returnValue;
    }
}