package com.bittech.reflect;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TestEmp {
    
    public static void code1() {
        Emp emp = new Emp();
        /*
        emp.setEname("Jack");
        emp.setJob("Java Soft Engineer");//语言
        
        System.out.println(emp);
        */
        String text = "ename:Jack|job:Java Soft Engineer|skill:Java,C++"; //args , file , database, mm
        //ename : Jack
        // => Field ename ;  getEname ; getXxx setXxx
        //job   :  Java Soft Engineer
        // => Field job  ;  getJob ;   getXxx  setXxx
        //通过反射进行Emp对象的赋值
        //1. 通过属性
        //2. 通过setter
        
        //第一步：解析字符串
        String[] attributeNameAndValues = text.split("\\|");
        for (String nameAndValueText : attributeNameAndValues) {
            String[] nameAndValue = nameAndValueText.split(":");
            String name = nameAndValue[0];
            String value = nameAndValue[1];
            //第二步赋值操作
            //1. 属性赋值
//            attributeSetValue(emp, name, value);
            //2. 通过方法赋值
//            methodSetValue(emp, name, value);
        }
        
        //第三步输出Emp
        System.out.println(emp);
    }
    
    public static void main(String[] args) {
        Emp emp = new Emp();
        String text = "ename:Jack|job:Java Soft Engineer|skill:Java,C++";
        //可复用
        TextAttributeAssignValue.parseTextAssignValue(text,emp);
        System.out.println(emp);
        
        
    }
    
    //name1:value1|name2:value2|namen:valuen
    //1.  类
    //2.  String(文本信息）  Object (目标对象)
    //3.  parseSetValue();
    //4.  Object 属性赋值完成
//    private static void methodSetValue(Object object, String name, String value) {
//        Class cls = object.getClass();
//        //name -> setXxx
//        //ename => setEname
//        String setMethodName = "set" + name.substring(0, 1).toUpperCase() + (name.length() == 1 ? "" : name.substring(1));
//        try {
//            Method setMethod= cls.getDeclaredMethod(setMethodName,value.getClass());
//            setMethod.invoke(object,value);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//    }

//    private static void attributeSetValue(Object object, String name, String value) {
//        Class cls = object.getClass();
//        try {
//            Field attributeField = cls.getDeclaredField(name);
//            attributeField.setAccessible(true);
//            attributeField.set(object, value);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
}
