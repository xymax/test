package com.bittech.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/*
1.  windows中
    + 文件夹和文件名称不区分大小写
    + 文件分隔符：\ 反斜杠  File.separator
    + 路径分割符：; 分号    File.pathSeparator
      example: C:\\java;D:\\maven;F:\\vscode
2. Linux/unix中
    + 文件夹和文件名称区分大小写
    + 文件分隔符：/ 正斜杠  File.separator
    + 路径分割符：: 冒号    File.pathSeparator
      example: /root:/home/zs:/etc/host
建议：
1. 文件名建议小写，主观上不要用大小写区分不同的文件
2. 文件名中不要出现特殊字符，空格
3. 尽量不要中文路径
 */
public class TestFile {
    
    public static void code1() {
        File file = new File("D:" + File.separator + "__test" + File.separator + "Hello.java");
        try {
            boolean effect = file.createNewFile();
            if (effect) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void code2() {
        File file = new File("D:" + File.separator + "__test" + File.separator + "Hello.java");
        if (file.exists()) {
            boolean effect = file.delete();
            if (effect) {
                System.out.println("文件存在，并且删除成功");
            } else {
                System.out.println("文件存在，但是删除失败");
            }
        } else {
            try {
                boolean effect = file.createNewFile();
                if (effect) {
                    System.out.println("文件不存在，创建成功");
                } else {
                    System.out.println("文件不存在，创建失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void code3() {
        //D:\\__test\\javacode\\javase521
        File directory = new File("D:" + File.separator + "__test" + File.separator + "javacode" + File.separator + "javase521");
        if (directory.exists()) {
            System.out.println("目录存在");
        } else {
            //directory.mkdirs(); //如果目录不存在，并且父目录也不存在，一并创建
            //directory.mkdir();//只会创建当前目录
            boolean effect = directory.mkdir();
            if (effect) {
                System.out.println("目录创建成功");
            } else {
                System.out.println("目录创建失败");
            }
        }
    }
    
    
    public static void code4() {
        //D:\\__test\\javacode\\javase521\\Hello.java
        File file =
                new File("D:" + File.separator + "__test" + File.separator + "javacode" + File.separator + "javase521" + File.separator +
                        "Hello.java");
        
        if (file.exists()) {
            System.out.println("Hello.java存在，不需要创建");
        } else {
            File parentFile = file.getParentFile();
            
            if (!parentFile.exists()) {
                boolean effect = parentFile.mkdirs(); //mkdir -p
                if (effect) {
                    System.out.println(parentFile.getAbsolutePath() + " 父目录不存在，创建成功");
                } else {
                    System.out.println(parentFile.getAbsolutePath() + " 父目录不存在，创建失败");
                    
                }
            }
            if (parentFile.exists()) {
                System.out.println(parentFile.getAbsolutePath() + " 父目录存在");
                
                try {
                    boolean effect = file.createNewFile();
                    if (effect) {
                        
                        System.out.println(file.getAbsolutePath() + " 创建成功");
                    } else {
                        System.out.println(file.getAbsolutePath() + " 创建失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void code5() {
        File file =
                new File("D:" + File.separator + "__test" + File.separator + "javacode" + File.separator + "javase521" + File.separator +
                        "Hello.java");
        
        System.out.println("文件名：" + file.getName());
        System.out.println("是否是文件：" + file.isFile());
        System.out.println("是否是目录：" + file.isDirectory());
        System.out.println("是否是隐藏文件：" + file.isHidden());
        System.out.println("文件大小(字节)：" + file.length());
        //1970-01-01 00:00:00 -> now ms
        System.out.println("最后修改时间：" + new Date(file.lastModified()));
        System.out.println("是否能够执行：" + file.canExecute());//.exe .msi
    }
    
    
    public static void code6() {
        File file = new File("D:" + File.separator + "__test" + File.separator + "blog");
        if (file.isDirectory()) {
//            String[] files = file.list();
//            if (files != null) {
//                for (String f : files) {
//                    System.out.println(f);
//                }
//            }

//            String[] files = file.list((f, n) -> {
//                return n.endsWith("png");
//            });
//            if (files != null) {
//                for (String f : files) {
//                    System.out.println(f);
//                }
//            }

//            File[] files = file.listFiles();
//            if (files != null) {
//                for (File f : files) {
//                    System.out.println(f.getAbsolutePath());
//                }
//            }
            
            //过滤文件
            //1.类::静态方法
            //2.类::成员方法
            //3.对象::成员方法
            //4.类名::new
            File[] files = file.listFiles(File::isFile);
            if (files != null) {
                for (File f : files) {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
    
    public static void main(String[] args) {
        File directory = new File("D:" + File.separator + "__test");
        int level = 0;
        printDirectory(level, directory);
    }
    
    public static void printDirectory(int level, File file) {
        if (file.isFile()) {
            System.out.println(space(level) + file.getName());
        } else {
            System.out.println(space(level) + file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    printDirectory(level+2, f);
                }
            }
        }
    }
    
    private static String space(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
