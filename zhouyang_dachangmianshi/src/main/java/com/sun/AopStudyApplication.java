package com.sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * create by qiulisun on 2021/9/26.<br>
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AopStudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopStudyApplication.class, args);
    }
}
