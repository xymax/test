package com.bittech.hw;

import java.lang.reflect.Field;

/**
 * Author: secondriver
 * Created: 2019/5/21
 */
public class BeanUtils {
    
    public static void copy(Object source, Object target) {
        //1.参数校验
        if (source == null) {
            throw new IllegalArgumentException("Source object must be not null.");
        }
        if (target == null) {
            throw new IllegalArgumentException("Target object must be not null.");
        }
        
        //2.获取Class对象
        Class sourceCls = source.getClass();
        Class targetCls = target.getClass();
        
        //3.获取Class对象中的Field
        Field[] sourceFields = sourceCls.getDeclaredFields();
        Field[] targetFields = targetCls.getDeclaredFields();
        
        //4. 通过sourceFields在targetFields找它元素相同（名字和类型）
        //for(int)
        //for(var : 集合)
        for (Field sf : sourceFields) {
            for (Field tf : targetFields) {
                if (sf.getName().equals(tf.getName())
                        && sf.getType() == tf.getType()) {
                    try {
                        sf.setAccessible(true);
                        tf.setAccessible(true);
                        Object value = sf.get(source);
                        tf.set(target, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }
}
