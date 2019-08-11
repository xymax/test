package com.xy.random;

import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

import java.util.Random;
import java.util.Scanner;

/*
 * 用代码猜数字小游戏：
 * 你说一个数字，我告诉你你猜的数字是大了还是小了。看谁猜的次数小。
 *
 * //二分法查找
 *
 * 1.先产生一个随机数字就不在发生变化。Random
 * 2.键盘输入，使用Scanner
 * 3.获取键盘输入的nextInt数字
 * 4.已经得到两个数字，进行判断
 * 4.1如果他猜大了告诉他大了
 * 4.2如果他猜小了告诉他小了
 * 4.3猜中，游戏结束。
 * */
public class Demo04Random {
    public static void main(String[] args) {
        int x = new Random().nextInt(100)+1; //匿名对象
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入你要猜的数字");
            int num = scanner.nextInt();
            if (num > x) {
                System.out.println("抱歉，你猜的数字有点大");
            }
            else if (num < x) {
                System.out.println("抱歉，你猜的数字有小了");
            }else {
                System.out.println("恭喜你，猜中了");
                break;
            }
        }
        System.out.println("游戏结束");
    }
}
