package com.xy.hx;

import java.util.*;

public class Parenthesis {
    public static void main(String[] args) {
        System.out.println(chkParenthesis("()()()()(a", 10));
    }



    public static boolean chkParenthesis(String A, int n) {
        char[] a = A.toCharArray();
        int i = 0; //左括号数
        for (int j = 0; j < A.length(); j++) {
            char c = a[j];
            if (c == '(') {
                i++;
            } else if (c == ')') {
                if (i > 0) {
                    i--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return i == 0;
    }

}
