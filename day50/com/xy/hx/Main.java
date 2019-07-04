package com.xy.hx;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int max = 0;
            int count = 0;
            int index = 0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    count++;
                }else{
                    count = 0;
                }
                if(count>max){
                    index = i;
                    max = count;
                }
            }
            System.out.println(str.substring(index-max+1,index+1));
        }
    }
}






