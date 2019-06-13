package com.bittech.api;

import java.util.Map;

/**
 * Author: secondriver
 * Created: 2019/6/11
 */
public class TestSystem {
    
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println("---------------");
        for (Map.Entry<String,String> entry :System.getenv().entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    
        System.out.println("---------------------");
    
        System.out.println(System.getenv("JAVA_HOME"));
        
        
    }
}
