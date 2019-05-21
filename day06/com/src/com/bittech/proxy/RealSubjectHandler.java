package com.bittech.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 该类：用于增强真实业务类对象的(被代理对象target）
 * <p>
 * Author: secondriver
 * Created: 2019/5/18
 */
public class RealSubjectHandler implements InvocationHandler {
    
    private final Object target;
    
    public RealSubjectHandler(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //invoke调用时
        //method :  此时调用代理接口的method
        //args   :  此时调用代理接口的method方法传入的参数
        
        System.out.println("做饭");//code ...
        Object returnValue = method.invoke(this.target, args);
        System.out.println("洗碗");
        
        return returnValue;
    }
}
