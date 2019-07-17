package com.xy.hx.test;
/*
* 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。

例如：

1^3=1

2^3=3+5

3^3=7+9+11

4^3=13+15+17+19
* */
import java.util.*;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int m = sc.nextInt();
                Double m3 = Math.pow(m,3);
                Double m3temp = 0.0;
                StringBuffer sb = new StringBuffer();
                for(int i=1; ; i+=2) {
                    for(int j=i; j<i+2*m; j+=2) {
                        m3temp += j;
                    }
                    if(m3temp.equals(m3)) {
                        for(int j=i; j<i+2*m; j+=2) {
                            sb.append(j+"+");
                        }
                        break;
                    } else
                        m3temp = 0.0;
                }
                System.out.println(sb.toString().substring(0,sb.toString().length()-1));
            }
        }
    }

