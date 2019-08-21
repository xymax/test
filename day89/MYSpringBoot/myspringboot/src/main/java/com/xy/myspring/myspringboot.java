package com.xy.myspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations="classpath:applicationContext-service.xml")
@SpringBootApplication
public class myspringboot {

    public static void main(String[] args) {
        SpringApplication.run(myspringboot.class,args);
    }
}
