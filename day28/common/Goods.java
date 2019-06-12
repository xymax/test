package com.bittech.common;

/**
 * Author: secondriver
 * Created: 2019/6/11
 */
public class Goods {
    
    private String id;
    private String name;
    private Double price;
    
    public Goods(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
