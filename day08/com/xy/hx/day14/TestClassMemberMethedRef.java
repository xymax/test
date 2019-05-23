package com.xy.hx.day14;

public class TestClassMemberMethedRef {
    public static void main(String[] args) {
        IUtil3<Integer,Integer> iUtil3=(p1, p2) -> {
            return p1-p2; //Integer
        };
        //int --》Integer
        //Integer Integer(Object).compareTo(Integer)
        //Integer  compare(Integer ,Integer)
//        Integer a=new Integer(10);
//        a.compareTo(new Integer(12));
        IUtil3<Integer,Integer> iUtil31=Integer::compareTo;
        iUtil31.compare(10,20);
        System.out.println(iUtil31.compare(10,30));

    }
}
//比较类型为P的参数p1和p2 返回R
interface IUtil3<P,R>{
    R compare(P p1,P p2);
}