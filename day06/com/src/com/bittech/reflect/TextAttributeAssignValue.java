package com.bittech.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TextAttributeAssignValue {
    
    
    public static void parseTextAssignValue(String text, Object target) {
        String[] attributeNameAndValues = text.split("\\|");
        for (String nameAndValueText : attributeNameAndValues) {
            String[] nameAndValue = nameAndValueText.split(":");
            String name = nameAndValue[0];
            String value = nameAndValue[1];
            methodSetValue(target, name, value);
        }
    }
    
    private static void methodSetValue(Object object, String name, String value) {
        Class cls = object.getClass();
        //name -> setXxx
        //ename => setEname
        String setMethodName = "set" + name.substring(0, 1).toUpperCase() + (name.length() == 1 ? "" : name.substring(1));
        try {
            Method setMethod = cls.getDeclaredMethod(setMethodName, value.getClass());
            setMethod.invoke(object, value);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        
    }
}
