package com.bittech.function;

/**
 * Author: secondriver
 * Created: 2019/5/14
 */
public class TestClassMemberMethodRef {
    
    public static void main(String[] args) {
        
        //p1 > p2  return  >0
        //p1 = p2  return  0
        //p1 < p2  return  <0
        IUtil3<Integer, Integer> iUtil3 = (p1, p2) -> {
            return p1 - p2;//Integer
        };
        
        //int -> Integer
        //Integer   Integer(object).compareTo(Integer)
        //Integer   compare(Integer,Integer)
//        Integer a = new Integer(10);
//        a.compareTo(new Integer(12));
    
        //通过类型::成员方法进行方法引用
        IUtil3<Integer, Integer> iUtil31 = Integer::compareTo;
        System.out.println(iUtil31.compare(10,20));
        
    }
    
    
}

@FunctionalInterface
interface IUtil3<P, R> {
    /**
     * 比较类型为P的参数p1和p2 返回R
     *
     * @param p1
     * @param p2
     * @return
     */
    //y  = f(m, n) [m n 同一类型]
    R compare(P p1, P p2);
}