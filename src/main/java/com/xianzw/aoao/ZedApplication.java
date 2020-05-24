package com.xianzw.aoao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.xianzw.aoao.properties.JwtProperties;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.xianzw.aoao.mapper")
@EnableConfigurationProperties({JwtProperties.class})
public class ZedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZedApplication.class, args);
	}

}
