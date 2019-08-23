package com.xy.red;

import com.xy.hongbao.OpenMode;

import java.util.ArrayList;


//平均分配方式。

//将总的钱totalMoney分给totalCount个人
public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list=new ArrayList<>();

        int avg=totalMoney/totalCount;
        int mod=totalMoney%totalCount;

        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }
        list.add(avg+mod);
        return list;
    }
}
