package com.example.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springbootmybatis.dao")//扫描指定包下接口
public class SpringBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}

}
