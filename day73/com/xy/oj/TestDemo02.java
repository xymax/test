package com.xy.oj;

import java.util.Scanner;

/*
*1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）

2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）

3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（

输入描述:
输入一个double数

输出描述:
输出人民币格式

示例1
输入
151121.15
输出
人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
* */
public class TestDemo02 {
    static char[] danWei = { '亿', '万', '仟', '佰', '拾', '元', '角', '分' };
    static char[] number = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double rmb = scanner.nextDouble();
            // System.out.println(rmb);

            long rmbZ = (long) rmb;

            int jfen = (int) ((rmb + 0.0001) * 100 % 100);
            // System.out.println(jfen);
            int yi = (int) (rmbZ / 100000000);// 亿
            // System.out.println(yi);
            int wan = (int) (rmbZ % 100000000 / 10000);// 万
            // System.out.println(wan);
            int yuan = (int) (rmbZ % 10000);// 元
            // System.out.println(yuan);
            StringBuilder stringBuilder = new StringBuilder("人民币");
            appendYiWanYuan(yi, wan, yuan, stringBuilder);
            appendJFen(jfen, stringBuilder);

            System.out.println(stringBuilder.toString());

        }

    }

    private static void appendJFen(int jfen, StringBuilder stringBuilder) {
        if (jfen == 0) {
            stringBuilder.append('整');
            return;
        }
        int jiao = jfen / 10;
        int fen = jfen % 10;
        if (jiao != 0) {
            stringBuilder.append("" + number[jiao] + danWei[6]);
        }
        if (fen != 0) {
            stringBuilder.append("" + number[fen] + danWei[7]);
        }

    }

    private static void appendYiWanYuan(int yi, int wan, int yuan, StringBuilder stringBuilder) {
        boolean addZere = false;
        if (yi != 0) {
            jieXiFour(yi, addZere, stringBuilder);
            stringBuilder.append(danWei[0] + "");
        }
        if (wan != 0) {
            if (yi != 0) {
                addZere = true;
            }
            jieXiFour(wan, addZere, stringBuilder);
            stringBuilder.append(danWei[1] + "");
        }
        if (yuan != 0) {
            if (wan != 0) {
                addZere = true;
            }
            jieXiFour(yuan, addZere, stringBuilder);
            stringBuilder.append(danWei[5] + "");
        }

    }
    private static void jieXiFour(int num, Boolean addZreo, StringBuilder stringBuilder) {
        int i = 2;
        int forNum = 0;
        int current = 0;
        int numCS = 1000;
        if (addZreo) {
            stringBuilder.append(number[0] + "");
        }

        for (; i < 6; i++) {
            if (num == 0) {
                break;
            }
            current = num / numCS;
            num = num % numCS;
            if (!(forNum == 0 && current == forNum)) {
                if (i == 4 && current == 1) {
                    stringBuilder.append(danWei[i] + "");
                } else {
                    if (i != 5) {
                        stringBuilder.append("" + number[current] + danWei[i]);
                    } else {
                        stringBuilder.append("" + number[current]);
                    }

                }
            }
            forNum = current;
            numCS = numCS / 10;

        }

    }
}
