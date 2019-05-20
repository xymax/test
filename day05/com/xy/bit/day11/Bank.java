package com.xy.bit.day11;

public abstract class Bank {
    public final void takeNamber(){
        System.out.println("1取号");
    }
    public abstract  void transact();
    public final void evaluate() {
        System.out.println("3.业务评价");
    }

    final void process(){
        takeNamber();
        transact();
        evaluate();
    }
    public boolean isEvaluate() {
        return true;
    }
}

class Use1 extends Bank{
    @Override
    public void transact() {
        System.out.println("我要存一个亿");
    }
}
class Use2 extends Bank{
    @Override
    public void transact() {
        System.out.println("我要取一个亿");
    }
}

class TestDemo{
    public static void main(String[] args) {
        Bank bank=new Use1();
        bank.process();
        System.out.println("=========");
        Bank bank2 =new Use2();
        bank2.process();
    }

}