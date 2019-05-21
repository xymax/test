package com.bittech.test;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class Test10 {
    public static void main(String[] args) {
        PointA<String> pointA = new PointA();
        pointA.setX("东经139度");
        pointA.setY("北纬35度");
        String x = pointA.getX();
        String y = pointA.getY();
        System.out.println("x = " + x +"  y = "+y);
    }
}
