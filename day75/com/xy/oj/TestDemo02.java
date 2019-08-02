package com.xy.oj;
/*
* 密码要求:
1.长度超过8位
2.包括大小写字母.数字.其它符号,以上四种至少三种
3.不能有相同长度超2的子串重复
说明:长度超过2的子串

输入描述:

一组或多组长度超过2的子符串。每组占一行

输出描述:

如果符合要求输出：OK，否则输出NG

输入例子:

021Abc9000
021Abc9Abc1
021ABC9000
021$bc9000

输出例子:

OK
NG
NG
OK
* */

import java.util.Scanner;

public class TestDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String res = "OK";
            String str = scanner.nextLine();
            if (str.length() <= 8) res = "NG";
            else {
                for (int i = 0; i < str.length() - 2; i++) {
                    String subStr = str.substring(i, i + 3);
                    if (str.substring(i + 1).contains(subStr)) {
                        res = "NG";
                        break;
                    }
                }
                if (res.equals("OK")) {
                    int upp = 0;
                    int low = 0;
                    int num = 0;
                    int oth = 0;
                    for (char ch : str.toCharArray()) {
                        if (ch >= 'A' && ch <= 'Z') upp = 1;
                        else if (ch >= 'a' && ch <= 'z') low = 1;
                        else if (ch >= '0' && ch <= '9') num = 1;
                        else oth = 1;
                    }
                    if (upp + low + num + oth < 3) res = "NG";
                }
            }
            System.out.println(res);
        }
    }
}

