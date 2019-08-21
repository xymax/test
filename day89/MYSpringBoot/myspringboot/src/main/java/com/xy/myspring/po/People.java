package com.xy.myspring.po;

public class People {
    private String pName;

    private int pAge;


    public People() {
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    @Override
    public String toString() {
        return "People{" +
                "pName='" + pName + '\'' +
                ", pAge=" + pAge +
                '}';
    }
}
