package com.xy.red;

import com.xy.hongbao.OpenMode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Random;


/*
 *
 * 随机红包
 *
 * */
public class RandMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney,final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
//设置打开红包的方法。
        //普通红包的打开方法
        //1.最少0.1元，最对是平均数的二倍即 totalMoney/totalCount*2

        int leftMoney = totalMoney;
        int leftCount = totalCount;

        //生成随机数
        Random random = new Random();

        for (int i = 0; i < totalCount - 1; i++) {

            int money=random.nextInt(leftMoney/leftCount*2)+1;
            list.add(money);
            leftMoney-=money;
            leftCount--;
        }
        list.add(leftMoney);


        return list;
    }
}
