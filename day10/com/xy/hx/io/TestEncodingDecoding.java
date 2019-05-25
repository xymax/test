package com.bittech.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Author: secondriver
 * Created: 2019/5/25
 */
public class TestEncodingDecoding {
    
    public static void code1() {
        System.getProperties().list(System.out);
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);
        //  C:\Users\Deleteorus
        //  /home/zhangsan
        //  /home/lisi
        //  多用户操作系统
    }
    
    public static void main(String[] args) {
        
        try (OutputStream out = new FileOutputStream(
                "D:" + File.separator + "__test" + File.separator + "encoding.txt"
        )) {

//            out.write("比特科技".getBytes("ISO8859-1"));
            out.write("比特科技".getBytes(
                    StandardCharsets.ISO_8859_1
            ));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
