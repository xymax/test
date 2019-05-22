package com.bittech.annotation;

/**
 * Author: secondriver
 * Created: 2019/5/21
 */

public class Factory {
    
    private Factory() {
    }
    
    public static Fruit getFruit() {
        MyAnnotation myAnnotation = ObjectDesc.class.getAnnotation(MyAnnotation.class);
        Class cls = myAnnotation.target();
        try {
            return (Fruit) cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {//JDK7
            e.printStackTrace();
        }
        return null;
    }
    
}
