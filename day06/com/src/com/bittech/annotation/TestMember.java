package com.bittech.annotation;

import java.lang.annotation.Annotation;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TestMember {
    
    public static void code1() {
        Class cls = Member.class;
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
//        try {
//            Method method =cls.getMethod("toString");
//            Annotation[] annotations =method.getAnnotations();
//            for (Annotation annotation: annotations){
//                System.out.println(annotation);
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
    }
    
    public static void main(String[] args) {
        Class cls = Member.class;
        MyAnnotation myAnnotation = (MyAnnotation) cls.getDeclaredAnnotation(MyAnnotation.class);
        System.out.println(myAnnotation);
        int age = myAnnotation.age();
        String name = myAnnotation.name();
        System.out.println(name + "  " + age);
    }
}
