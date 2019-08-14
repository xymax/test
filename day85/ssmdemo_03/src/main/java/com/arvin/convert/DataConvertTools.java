package com.arvin.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConvertTools implements Converter<String, Date> {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
    Date date = null;
    @Override
    public Date convert(String source) {
        System.out.println("source = " + source);
        try{
            date = simpleDateFormat.parse(source);
            System.out.println("date = " + date);
            return date;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
