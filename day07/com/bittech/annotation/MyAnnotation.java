package com.bittech.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: secondriver
 * Created: 2019/5/21
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
public @interface MyAnnotation {
    
    /**
     * 标识的类
     *
     * @return
     */
    Class<?> target();
    
}
