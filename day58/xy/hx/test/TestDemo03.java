package com.xy.hx.test;

public class TestDemo03 {
/*
* 编写函数交换两个数
* */

    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] + AB[1];

        AB[1] = AB[0] - AB[1];

        AB[0] = AB[0] - AB[1];

        return AB;

    }
}

