package com.bittech.annotation;

import java.io.Serializable;

/**
 * Author: secondriver
 * Created: 2019/5/18
 */
@SuppressWarnings(value = {"unused"})
@Deprecated
@MyAnnotation
public class Member implements Serializable {
    
    
    @Override
    @Deprecated
    public String toString() {
        return super.toString();
    }
}
