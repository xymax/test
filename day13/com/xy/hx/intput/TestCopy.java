package com.xy.hx.intput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis =new FileInputStream("F:\\BaiduYunDownload\\Idea\\idea的安装.mp4");
        FileOutputStream fos =new FileOutputStream("D:\\test\\a\\idea的安装.mp4");
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=fis.read())!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }

}
