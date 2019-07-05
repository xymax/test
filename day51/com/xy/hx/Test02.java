package com.xy.hx;

import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = "";
        String s2 = "";
        ArrayList<Character> list = new ArrayList();
        while (scanner.hasNext()) {
            s1 = scanner.next();
            if (s1 == "") return;
            if (s2 == "") return;
            s1 = scanner.next();
            s2 = scanner.next();
            for (int i = 0; i < s1.length(); i++) {
                //如果str2中不包含str1.charAt[i],就将这个字符添加到list中
                if (!(s2.contains(s1.charAt(i) + ""))) {
                    list.add(s1.charAt(i));
                }
            }
            //遍历list，将list中的元素输出
            for (int k = 0; k < list.size(); k++) {
                System.out.print(list.get(k) + "");
            }

        }


    }


}

