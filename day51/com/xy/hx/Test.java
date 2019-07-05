package com.xy.hx;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(count(n));
        }
    }

    public static int count(int n) {
        //满足以下任何条件都将无法获得整袋。
        if (n % 2 != 0 || n == 10 || n < 6) {
            return -1;
        }
        if (n % 8 == 0) {
            return n / 8;
        }
        return (1 + n / 8);
    }
}
