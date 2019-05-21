package com.bittech.test;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(fun(str));
    }
    
    static int fun(String str) {
        for (int i = 1; i <= str.length(); i++) {
            Set<String> rq = new TreeSet<>();
            for (int j = 0; j < str.length() - i; j++) {
                rq.add(str.substring(j, j + i));
            }
            if (rq.size() < Math.pow(4, i)) {
                return i;
            }
        }
        return 1;
    }
    
}
