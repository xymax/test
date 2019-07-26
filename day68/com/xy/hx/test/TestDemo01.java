package com.xy.hx.test;

import java.util.Scanner;

/*
* 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。

为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如在图1中，第3串是小红想做的珠串；那么第1串可以买，因为包含了全部她想要的珠子，还多了8颗不需要的珠子；第2串不能买，因为没有黑色珠子，并且少了一颗红色的珠子。



输入格式：

每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。

输出格式：

如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。

输入样例1：
ppRYYGrrYBR2258
YrR8RrY
输出样例1：
Yes 8
*
* */
public class TestDemo01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String tanzhu=scanner.next();
        boolean[] tanzhu1=new boolean[tanzhu.length()];
        String Buy=scanner.next();
        boolean[] Buy1=new boolean[Buy.length()];
        int count=0;
        for(int i=0;i<tanzhu1.length;i++){
            tanzhu1[i]=true;
        }
        for(int i=0;i<Buy1.length;i++){
            Buy1[i]=true;
        }
        for(int i=0;i<Buy.length();i++){
            for(int j=0;j<tanzhu1.length;j++){
                if(Buy.charAt(i)==tanzhu.charAt(j)&&tanzhu1[j]==true&&Buy1[i]==true){
                    count++;
                    tanzhu1[j]=false;
                    Buy1[i]=true;
                    break;

                }

            }

        }
        if(count==Buy.length()){
            int e=tanzhu1.length-count;
            System.out.println("yes"+" "+e);
        }else {
            int e=Buy.length()-count;
            System.out.println("No"+" "+e);
        }
    }
}
