package com.xy.Static;

public class Penson {
    private int id; //学号



    private String name;
    private int age;
    static String room;
    private static int idCounter; //学号计数器，每当new一个新对象时候计数器++。

    public Penson() {
        idCounter++;
    }

    public Penson(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public String getName() {

        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
