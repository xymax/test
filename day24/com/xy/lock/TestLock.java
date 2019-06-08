package com.bittech.thread.lock;

/**
 * Author: secondriver
 * Created: 2019/6/8
 */
public class TestLock {
    
    //    private static StringBuffer sb = new StringBuffer();
//    private final static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        //lock
//        synchronized(sb) {
//            sb.append("a");//lock,unlock
//            sb.append("b");//lock,unlock
//            sb.append("c");//lock,unlock
//        }
//        //unlock
//        System.out.println(sb.toString());
        
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        
        /*
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Thread-Safe
        //Thread-Unsafe
        String str = simpleDateFormat.format(new Date());
        System.out.println(str);*/
    }
}
