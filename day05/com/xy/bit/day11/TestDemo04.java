package com.xy.bit.day11;

public class TestDemo04 {
    public static void main(String[] args) {

    }
    public static void main2(String[] args) {
        StringBuffer stringBuffer=new StringBuffer();
        System.out.println(Integer.toHexString(stringBuffer.hashCode()));
        stringBuffer.append("ab");
        System.out.println(Integer.toHexString(stringBuffer.hashCode()));
        stringBuffer.append("cd");
        System.out.println(Integer.toHexString(stringBuffer.hashCode()));
        System.out.println("============================");
        StringBuilder stringBuilder=new StringBuilder();
        System.out.println(Integer.toHexString(stringBuilder.hashCode()));
        stringBuilder.append("ab");
        System.out.println(Integer.toHexString(stringBuilder.hashCode()));
        stringBuilder.append("cd");
        System.out.println(Integer.toHexString(stringBuilder.hashCode()));

    }




//    StingBuffer和St
    public static void main1(String[] args) {
        String str="HelloBit";
        String str2=new String("HelloBit");
        System.out.println(str.equals(str2));
    }


}
