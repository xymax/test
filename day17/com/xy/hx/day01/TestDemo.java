package com.xy.hx.day01;

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Iphone", 8999.99, 10));
        orderList.add(new Order("外星人笔记本", 12999.99, 5));
        orderList.add(new Order("MacBookPro", 18999.99, 5));
        orderList.add(new Order("Java从入门到入土.txt", 9.99, 20000));
        orderList.add(new Order("中性笔", 1.99, 200000));
        double allPrice = orderList.stream().map((obj) -> obj.getPrice() * obj.getAmount())
                .reduce(Double::sum).get();
        System.out.println("所花费的总数额为: " + allPrice);
    }


}
















