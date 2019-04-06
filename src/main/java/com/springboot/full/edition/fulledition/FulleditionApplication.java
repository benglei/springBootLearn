package com.springboot.full.edition.fulledition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//扫描：该包下相应的class,主要是MyBatis的持久化类.是包的路径
@MapperScan(basePackages = {"com.springboot.full.edition.fulledition.noMapperXML","com.springboot.full.edition.fulledition.haveMapperXML"})
@SpringBootApplication
public class FulleditionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FulleditionApplication.class, args);
    }

}
