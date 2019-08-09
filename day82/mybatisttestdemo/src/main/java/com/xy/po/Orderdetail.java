package com.xy.po;

public class Orderdetail {
    private Integer id;

    private Integer itemsId;

    private Integer itemsNum;

    private Integer ordersId;

    public Orderdetail() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    @Override
    public String toString() {
        return "Orderdetail{" +
                "id=" + id +
                ", itemsId=" + itemsId +
                ", itemsNum=" + itemsNum +
                ", ordersId=" + ordersId +
                '}';
    }
}
