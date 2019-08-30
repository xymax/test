package com.xy.conllection.set.treeset;

public class Penson implements Comparable<Penson>{
    private int age;
    private String name;

    public Penson(int age, String name) {
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
        return "Penson{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Penson o) {
        if (this.age>o.age){
            return 1;

        }else if (this.age<o.age){
            return -1;
        }else {
            return this.name.compareTo(o.name);
        }
    }
}
