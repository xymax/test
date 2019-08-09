package com.xy.po;

import java.util.Date;
import java.util.List;

public class Orders
{

    private Integer id;

    private Integer userid;

    private String number;

    private Date createtime;

    private String note;

    //1:1演示 orders--->user
    private User user;
    //1:m 演示 orders-->orderdetail
    private List<Orderdetail> orderdetailList;

    public List<Orderdetail> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<Orderdetail> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orders(){

    }

    public Integer getId()
    {
        return id;
    }

    public Integer getUserid()
    {
        return userid;
    }

    public void setUserid(Integer userid)
    {
        this.userid = userid;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userid=" + userid +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", note='" + note + '\'' +
                ", user=" + user +
                ", orderdetailList=" + orderdetailList +
                '}';
    }
}
