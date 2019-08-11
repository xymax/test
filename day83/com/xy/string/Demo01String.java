package com.xy.string;
/*
* 只要是“”包括起来的都是String类的对象就算没有new，也是字符串对象
*
* 字符串的特点
* 1.字符串的内容永远不会发生变化（重点）；
* 2.字符串是可以共享使用。
* 3.字符串效果上相当于char[]字符数组，但是底层园里是byte[]字节数组。
*
*
* 创建创建字符串的3+1的方法
* 1.  public String()创建一个空白字符串，不含有任何内容
* 2.  public String（char[] array）；根据字符数组的内容直接创建字符数组。
* 3.  public String（byte[] array）；根据字节数组的内容直接创建字符数组。
* 4.直接启动
*
*
*
*
* */
public class Demo01String {
    public static void main(String[] args) {
        //1.使用空参构造
        String s=new String();
        System.out.println(s);

        //2.字符数组构造
        char[] charArray={'A','B','C'};

        String s1=new String(charArray);
        System.out.println(s1);

        //根据字节数组创建

        byte[] bytes={97,98,99};
        String s2=new String(bytes);
        System.out.println("第三个字符串"+s2);

        //直接创建
        String s3="hello";
        System.out.println(s3);



    }

}
