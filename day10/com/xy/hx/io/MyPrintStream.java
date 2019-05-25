package com.bittech.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * OutputStream
 * write(int b)
 * write(byte[] b)
 * <p>
 * 解决
 * write(int value)
 * write(String value)
 * write(double value)
 * <p>
 * Author: secondriver
 * Created: 2019/5/25
 */
public class MyPrintStream {
    
    private OutputStream out;
    
    public MyPrintStream(OutputStream out) {
        this.out = out;
    }
    
    public void write(int value) {
        this.write(String.valueOf(value));//49 -> "49" -> byte[]
    }
    
    public void write(double value) {
        this.write(String.valueOf(value));//10.5 -> "10.5" -> byte[]
    }
    
    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void write(String value) {
        byte[] data = value.getBytes();
        try {
            this.out.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        try (
                OutputStream out = new FileOutputStream(
                        "D:" + File.separator + "__test" + File.separator + "myprint.txt"
                )
        ) {
            MyPrintStream myPrintStream = new MyPrintStream(out);
            myPrintStream.write(65);
            myPrintStream.write(10.5);
            myPrintStream.write("HelloWorld");
            myPrintStream.flush();
        } catch (IOException e) {
        
        }
        
        
    }
}
