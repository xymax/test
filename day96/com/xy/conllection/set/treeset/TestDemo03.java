package com.xy.conllection.set.treeset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;

public class TestDemo03 {


    static class Penson{
        private String name;
        private Integer age;

        public Penson(String name, Integer age) {
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

        @Override
        public String toString() {
            return "Penson{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }



    static class CompareAge1 implements Comparator<Penson> {

        @Override
        public int compare(Penson o1, Penson o2) {
            return o1.getAge()-o2.getAge();
        }
    }


    static class CompareAge2 implements Comparator<Penson>{

        @Override
        public int compare(Penson o1, Penson o2) {
            return o2.getAge()-o1.getAge();
        }
    }


    public static void main(String[] args) {
        Set<Penson> set=new TreeSet<>(new CompareAge1());
        set.add(new Penson("张三",20));
        set.add(new Penson("李四",26));
        set.add(new Penson("李四",21));
        set.add(new Penson("李四",18));
        set.add(new Penson("王五",22));
        System.out.println(set);

        System.out.println("================================");
        Set<Penson> set1=new TreeSet<>(new CompareAge2());
        set1.add(new Penson("张三",20));
        set1.add(new Penson("李四",26));
        set1.add(new Penson("李四",21));
        set1.add(new Penson("李四",18));
        set1.add(new Penson("王五",22));
        System.out.println(set1);



    }


}
