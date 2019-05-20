package com.xy.bit.day11;

public abstract class GoBuying {
    public final void browseGoods(){
        System.out.println("1.选择商品");
    }
    public final void selectGoods(){
        System.out.println("2.选择商品");
    }
    public final void callService(){
        System.out.println("3.客服咨询");
    }
    public final void computPrice(){
        System.out.println("4.结算");
    }
    public abstract void orderPrice();
    public abstract void sendService();
    public final void showOrder(){
        System.out.println("7.查看订单");
    }
    public final void process(){
        browseGoods();
        selectGoods();
        callService();
        computPrice();
        orderPrice();
        sendService();
        showOrder();
    }
    public boolean isCallService(){
        return true;
    }

}

class Jd extends GoBuying{
    @Override
    public void orderPrice() {
        System.out.println("5.您好，欢迎使用支付宝。");

    }

    @Override
    public void sendService() {
        System.out.println("6.您好，京东为您配送");
    }
    public boolean isCallService(){
        return false;
    }
}
class TestDemo02{
    public static void main(String[] args) {
        GoBuying goBuying=new Jd();
        goBuying.process();
    }
}