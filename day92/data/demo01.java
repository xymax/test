package com.xy.data;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo01 {
    public static void main(String[] args) {
      method();
    }

    private static void method() {
        Date date=new Date();
        System.out.println(date);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年-MM月-dd日 HH时:mm分:ss秒");
        String format = sdf.format(date);
        System.out.println(format);

        try {
            Date parse = sdf.parse("2019年-08月-25日 22时:05分:09秒");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
