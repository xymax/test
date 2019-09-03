package com.xy;
/*
* 异常 ：指的是程序在执行过程中，出现的非正常的情况，最终会导致JVM的非正常停止。
*
* 在Java等面向对象的编程语言中，异常本身是一个类，产生异常就是创建异常对象并抛出了一个异常对象。Java处
理异常的方式是中断处理。
* */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
*
*
* java.lang.Throwable类是所有异常和错误的超类
* Exception：编译时异常，就是在写代码时候出现的异常
* RuntimeException:运行时异常，java在运行时出现的问题。
*
* 异常就相当于程序出现了点小毛病，把异常处理掉程序就可以基础运行。
*
* Error：相当于程序得一个无法治愈的毛病，必须修改代码，抛异常或者铺货异常都不行
*
* */
public class TestDemo01 {
    public static void main(String[] args) {
        //格式化日期
        SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
        try {//可能出现异常的代码
            Date data = sdf.parse("1999-09-09");///将字符串类型的日期解析为Data打得日期。

        } catch (ParseException e) {
            //异常的处理结果
            e.printStackTrace();
        }

    }

}
