package com.xy.extend.demo05;

/*
 *
 * 1.父子方法名相同，参数列表相同，
 * 可用@Override检查，不写也没事
 *
 * 2.子类方法返回值必须小于等于父类方法的放回值范围。
 *
 *
 * 3.子类方法的权限必须大于等于父类方法权限。
 * public  >  protect  >default()  >private
 *
 * default不是关键字default而是什么都不写
 *
 *
 * */
public class Zi extends Fu {
    @Override
    public String method() {

        return null;
    }
}
