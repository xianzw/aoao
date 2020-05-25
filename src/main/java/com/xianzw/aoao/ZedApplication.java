package com.xianzw.aoao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.xianzw.aoao.mapper")
public class ZedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZedApplication.class, args);
	}

}
