package com.bittech.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
/*
1. @interface
2. @Retention指定保存范围
3. @Target 指定注解标识的位置
4. 定义方法
    4.1 定义默认值
Spring框架大量使用Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface MyAnnotation {
    //方法
    String name() default "无名";
    
    int age() default 18;
}
