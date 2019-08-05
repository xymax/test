package com.xy.oj;
/*
* 简单错误记录
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

输入描述:

一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

文件路径为windows格式

如：E:\V1R2\product\fpgadrive.c 1325

输出描述:

将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1 

结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。

如果超过8条记录，则只输出前8条记录.

如果文件名的长度超过16个字符，则只输出后16个字符

示例：

示例1

输入

E:\V1R2\product\fpgadrive.c 1325

输出

fpgadrive.c 1325 1

分析：

首先来总结一下题目的意思和需要注意的点：

（1）只要文件名和行号相同，就合并为一条错误，将这条错误记录的错误数加1；

（2）结果按记录的错误数由大到小排序输出，这个排序必须具有稳定性，先输入的记录排在前面；

（3）记录最多8条错误记录其实是将排序结果只输出前8条；

（4）当文件名长度（包括后缀如.c）大于16时，只需要在输出时将文件名缩小到后16位，记录错误时按原文件名，这样就不会因为缩减后的名字相同而合并。

创建两个ArrayList集合names,sum，names用来存文件名和行号，sum用来存这条记录的错误数，存储完毕之后，将两个集合转为数组并排序，最后输出前8条记录，并在输出过程中校验文件名。

*
*
*
*
*
*
*
集合转数组的两种方法：
*  //已有集合list
String[]  arr1 = new String[list.size()];
list.toArray(arr1);
//第二种
String[] arr2 = (String[])list.toArray(new String[0]);
* */

import java.util.*;

public class TestDemo02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        while (in.hasNext()) {
            String[] strs = (in.next()).split("\\\\");
            String name = strs[strs.length - 1];
            name = name + " " + in.next();
            int index = names.indexOf(name);
            if (index != -1) {//存在
                sum.set(index, sum.get(index) + 1);
            } else {
                names.add(name);
                sum.add(1);
            }
        }
        String[] namestmp = new String[names.size()];
        names.toArray(namestmp);
        Integer[] sumtmp = new Integer[sum.size()];
        sum.toArray(sumtmp);
        //排序
        for (int i = 0; i < namestmp.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < namestmp.length; j++) {
                if (sumtmp[j] > sumtmp[maxIndex]) {
                    maxIndex = j;
                }
            }
            String name1 = namestmp[maxIndex];
            System.arraycopy(namestmp, i, namestmp, i + 1, maxIndex - i);
            namestmp[i] = name1;
            Integer sum1 = sumtmp[maxIndex];
            System.arraycopy(sumtmp, i, sumtmp, i + 1, maxIndex - i);
            sumtmp[i] = sum1;
        }
        //输出
        for (int i = 0; i < Math.min(namestmp.length, 8); i++) {
            String name = namestmp[i];
            String a = name.split(" ")[0];
            String b = name.split(" ")[1];
            if (a.length() > 16) {
                name = a.substring(a.length() - 16) + " " + b;
            }
            System.out.println(name + " " + sumtmp[i]);
        }
    }
}

