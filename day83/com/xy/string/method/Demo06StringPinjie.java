package com.xy.string.method;
/*
*
*
*定义一个方法，把数组{1,2,3}按照指定格式拼接成一个字符串。
* 格式参照如下：[word1#word2#word3]。
*
* 1.首先准备一个int 数组
* 2.定义一个方法将数组变成字符串。
* 3.格式word1#word2#word3]。
* .调用，
*
*
* */
public class Demo06StringPinjie {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        String string = fromArrayToString(arr);
        System.out.println(string);

    }

    public static String fromArrayToString(int[] arr){
        String str="[";
        for (int i = 0; i < arr.length; i++) {
            if (i==arr.length-1){
                str+="word"+arr[i]+"]";
            }else {
                str+="word"+arr[i]+"#";
            }
        }
        return str;
    }

}
