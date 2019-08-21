package com.xy.myspring.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
@PropertySource(value = "classpath:employee.properties")
@ConfigurationProperties(prefix = "emp")
public class Employee {

    private String empName;

    private int empAge;

    private boolean empType;

    private List list;

    private Map map;

    private People people;

    public Employee() {

    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public boolean isEmpType() {
        return empType;
    }

    public void setEmpType(boolean empType) {
        this.empType = empType;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empType=" + empType +
                ", list=" + list +
                ", map=" + map +
                ", people=" + people +
                '}';
    }
}
