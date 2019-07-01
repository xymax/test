package com.xy.hx;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int count=0;
            String A=scanner.nextLine();
            String B=scanner.nextLine();
            for (int i = 0; i <A.length() ; i++) {
                StringBuilder stringBuilder=new StringBuilder();
                if (i==0){
                    stringBuilder.append(B);
                    stringBuilder.append(A);
                }else if (i==0){
                    stringBuilder.append(A);
                    stringBuilder.append(B);
                }else {
                    stringBuilder.append(A.substring(0,i));
                    stringBuilder.append(B);
                    stringBuilder.append(A.substring(i));
                }
                if (ispalindrome(stringBuilder.toString())){
                    count++;
                }

            }
            System.out.println(count);
        }

    }


    public static boolean ispalindrome(String s){
        if (s==null||s.length()==0){
            return true;
        }
        int i=0;
        int j=s.length()-1;
        while (i<j){
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
