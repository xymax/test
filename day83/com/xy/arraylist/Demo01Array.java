package com.xy.arraylist;
/*
* 定义一个数组，用来储存三个Penson对象
* 数组有个缺点，一旦创建就不会发生变化。
*
* */
public class Demo01Array {
    public static void main(String[] args) {
        //创建一个长度为3的数组，用来存放Penson对象。
        Penson[] array=new Penson[3];

        Penson one=new Penson("zs",15);
        Penson two=new Penson("lisi",25);
        Penson three= new Penson("ww",36);

        //将三个对象放在数组中

        array[0]=one;
        array[1]=two;
        array[2]=three;

        System.out.println(array[0].getName());
        System.out.println(array[1]);
        System.out.println(array[2]);









    }
}