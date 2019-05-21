package com.bittech.function;

/**
 * Author: secondriver
 * Created: 2019/5/14
 */
public class TestConstructorMethodRef {
    
    public static void main(String[] args) {
        
        Person person1 = new Person();
        Person person2 = new Person(22, "jack");
        
        // y = f(m, n)
        // y = Person类型
        // m = Integer类型
        // n = String类型
        // f = 根据m n 创建一个Person
        
        //new Person()
        //new Person(Integer,String)
        ObjectFactory<Integer, String, Person> factory = (p1, p2) -> {
            return new Person(p1, p2);
        };
        Person person3 = factory.createObject(20, "Alice");
        
        
        //构造方法引用
        ObjectFactory<Integer, String, Person> factory1 =
                Person::new;
        
        Person person4 = factory1.createObject(21,"Tom");
        
        //方法引用： 打通函数实现和面向对象的方法
    }
}

class Person {
    private Integer age;
    private String name;
    
    public Person() {
    
    }
    
    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
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


@FunctionalInterface
interface ObjectFactory<P1, P2, R> {
    
    R createObject(P1 p1, P2 p2);
}