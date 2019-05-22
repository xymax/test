package com.bittech.hw;

import java.util.Date;

/**
 * Author: secondriver
 * Created: 2019/5/21
 */
public class TestBeanUtils {
    
    public static void main(String[] args) {
        
        Teacher teacher = new Teacher();
        teacher.setAge(28);
        teacher.setBirthday(new Date());
        teacher.setName("Jack");
        
        Student student = new Student();
        
        System.out.println("copy before:");
        System.out.println(teacher);
        System.out.println(student);
        
        System.out.println("copy after:");
        
        BeanUtils.copy(teacher, student);
        
        System.out.println(teacher);
        System.out.println(student);
        
        //BeanUtils.copy(teacher,null);
    }
}

class Teacher {
    
    private String name;
    private Integer age;
    private Date birthday;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}

class Student {
    
    private String name;
    private String skill;
    private Integer age;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getSkill() {
        return skill;
    }
    
    public void setSkill(String skill) {
        this.skill = skill;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", age=" + age +
                '}';
    }
}
