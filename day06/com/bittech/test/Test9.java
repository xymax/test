package com.bittech.test;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class Test9 {
    public static void main(String[] args){
        Point point = new Point();
        point.setX(10);
        point.setY("北纬35度");
        String x = (String)point.getX();
        String y = (String)point.getY();
        System.out.println("x = " + x +" y = "+y);
    }
}
