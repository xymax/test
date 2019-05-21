package com.bittech.test;
import java.lang.reflect.Field;
/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class Test14 {
    public static void main(String[] args) {
        MyClass<String,Integer> myClass = new MyClass<>();
        Field[] fields =  myClass.getClass().getDeclaredFields();
        for (Field field : fields){
            System.out.println(field.getType());
        }
    }
}
