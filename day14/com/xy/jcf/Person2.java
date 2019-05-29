package com.biitech.jcf;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * Author: secondriver
 * Created: 2019/5/28
 */
public class Person2 implements Serializable, Comparable<Person2> {
    
    private String name;
    private transient Integer age;
    private String[] skills;
    private Date birthday;
    
    public Person2() {
    
    }
    
    public Person2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
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
    
    public String[] getSkills() {
        return skills;
    }
    
    public void setSkills(String[] skills) {
        this.skills = skills;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + Arrays.toString(skills) +
                ", birthday=" + birthday +
                '}';
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return Objects.equals(name, person2.name) &&
                Objects.equals(age, person2.age) &&
                Arrays.equals(skills, person2.skills) &&
                Objects.equals(birthday, person2.birthday);
    }
    
    @Override
    public int hashCode() {
        int result = Objects.hash(name, age, birthday);
        result = 31 * result + Arrays.hashCode(skills);
        return result;
    }
    
    @Override
    public int compareTo(Person2 o) {
        // 策略
        int a = this.age;
        int b = o.getAge();
        return -1*Integer.compare(a, b);
    }
}
