package com.jack.healthManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jack.healthManage.mapper")
public class HealthManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthManageApplication.class, args);
	}

}
