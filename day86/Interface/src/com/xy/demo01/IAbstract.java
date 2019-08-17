package com.xy.demo01;
/*
*
* 接口中可以定义抽象方法
*
* 使用步骤：
* 1.不可以直接使用，
* 必须有一个实现类来实现接口，格式。
* public class  类名称  implements 接口名称{
* //
*
* }
* 2.必须复写接口所有抽象方法。
*
* 3.创建类的对象。
*
*
* */
public interface IAbstract {
    //抽象方法
    public abstract void method();


    void method2();  //public abstract可以省略，或者省略一部分都可以。

}
