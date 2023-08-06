package com.rp3.marco4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Dale {

    public static void main(String[] args) {
        SpringApplication.run(Dale.class, args);
    }
}