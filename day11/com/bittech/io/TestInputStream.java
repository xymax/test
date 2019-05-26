package com.bittech.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: secondriver
 * Created: 2019/5/25
 */
public class TestInputStream {
    
    public static void main(String[] args) {
        File file = new File("D:" + File.separator + "__test" + File.separator + "Hello1.text");
        //读文件，文件必须存在
        try (FileInputStream inputStream = new FileInputStream(file)) {
//            int value = -1;
//            while ((value = inputStream.read())!=-1){
//                System.out.print((char) value);
//            }
            
            //buffer :
            //1024   1 2 4  1024
            /*
            byte[] buff  = new byte[5];
            int len = -1;
            while ((len = inputStream.read(buff))!=-1){
                System.out.print(new String(buff,0,len));
            }
             */
            
            byte[] buff = new byte[5];
            inputStream.read(buff); //5
            inputStream.read(buff, 2, 2);//2
            System.out.println(new String(buff));//ABFGE
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
