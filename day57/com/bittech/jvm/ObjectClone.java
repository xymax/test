package com.bittech.jvm;

import java.io.Serializable;

/**
 * @Author: yuisama
 * @Date: 2019-07-08 19:24
 * @Description:
 */

class Teacher implements Serializable{
    private Integer age;
    private String name;
    // getter..setter
}
class Student implements Serializable {
    private Integer age;
    private String name;
    private Teacher teacher;

}

public class ObjectClone {
    public static void main(String[] args) {

    }
}
