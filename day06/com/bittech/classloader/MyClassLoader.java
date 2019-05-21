package com.bittech.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
public class MyClassLoader extends ClassLoader {
    
    //用户自定义的类加载器
    //com.bittech.classloader.Member1
    public Class loadClasses(String className) {
        byte[] byteCodeData = loadData(className);
        //Class类 -> Class文件 -> ByteCode二进制流
        return super.defineClass(className, byteCodeData, 0, byteCodeData.length);
    }
    
    private byte[] loadData(String className) {
        //Class文件的路径：E:\worskpace\java2_rocket_code\javase-function-514\out\production\javase-function-514\com\bittech\classloader\Member1.class
        //Member1的类名：com.bittech.classloader.Member1
        //String classpath = "E:\\worskpace\\java2_rocket_code\\javase-function-514\\out\\production\\javase-function-514\\";//classpath:
        // 环境变量配置，或者系统属性，命令行参数
        String classpath = "D:\\";
        String classFile = classpath + className.replace(".", "\\\\") + ".class";
        
        try (FileInputStream in = new FileInputStream(classFile);
             ByteArrayOutputStream out = new ByteArrayOutputStream()
        ) {
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            byte[] byteCodeData = out.toByteArray();
            return byteCodeData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
    
    
}
