package com.ming.vo;

public class Employee {

    private int employeeId;

    private String employeeName;

    private int departNum;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getDepartNum() {
        return departNum;
    }

    public void setDepartNum(int departNum) {
        this.departNum = departNum;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", departNum=" + departNum +
                '}';
    }
}
