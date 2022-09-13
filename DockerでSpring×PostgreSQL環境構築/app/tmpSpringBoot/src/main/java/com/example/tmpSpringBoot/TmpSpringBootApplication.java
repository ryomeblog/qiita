package com.example.tmpSpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.example.tmpSpringBoot.dao")
public class TmpSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmpSpringBootApplication.class, args);
	}

}
