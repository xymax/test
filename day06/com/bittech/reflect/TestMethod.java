package com.bittech.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class TestMethod {
    
    public static void code1() {
        Class cls = Person.class;
        
        System.out.println("获取所有的方法：");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        
        System.out.println("获取指定方法");
        try {
            
            
            //1.获取对象
            Person person = (Person) cls.newInstance();
            System.out.println("Person before :" + person);
            //2.获取对象的方法，并且调用 （修改）
            //访问修饰符  返回类型  类名.方法名([参数类型列表]) 异常类型列表
            Method method = cls.getMethod("setName", String.class);
            Object returnValue = method.invoke(person, "Tom");
            System.out.println(returnValue);//null
            System.out.println("Person after :" + person);
            //3.获取对象的方法，并且调用 （取值）
            Method getNameMethod = cls.getMethod("getName");
            Object returnName = getNameMethod.invoke(person);
            System.out.println(returnName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args) {
        
        Class cls = Student.class;
        //子类继承父类的所有结构，是否能否访问取决于访问修饰符
        System.out.println("获取属性");
        //Field[] fields = cls.getFields();//返回父类和子类的公开属性
        Field[] fields = cls.getDeclaredFields();//返回子类的所有属性
        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
            System.out.println(field);
        }
        
        //自己
        System.out.println("获取指定属性");
        try {
            Field skillField = cls.getDeclaredField("skill");
            System.out.println(skillField);
            
            //使用属性
            Student student = new Student();
            student.setSkill("Java,PHP,Python,JavaScript");
//            student.getSkill()
            //true表示可以访问私有的属性
            skillField.setAccessible(true);
            //get 获取
//            Object skillValue = skillField.get(student);
//            System.out.println(skillValue);
            //set 修改
            skillField.set(student, "C++");
            System.out.println(student);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
    }
}

class Person {
    
    private int age;
    
    public String name;
    
    public Person() {
    }
    
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    
    private String school;
    private String skill;
    private LocalDateTime birthday;
    
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    
    public String getSkill() {
        return skill;
    }
    
    public void setSkill(String skill) {
        this.skill = skill;
    }
    
    public LocalDateTime getBirthday() {
        return birthday;
    }
    
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }
    
    
    @Override
    public String toString() {
        return "Student{" +
                "school='" + school + '\'' +
                ", skill='" + skill + '\'' +
                ", birthday=" + birthday +
                "} " + super.toString();
    }
}