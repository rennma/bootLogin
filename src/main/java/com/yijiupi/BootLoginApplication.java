package com.yijiupi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@MapperScan("com.yijiupi.dao")
@SpringBootApplication
public class BootLoginApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootLoginApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BootLoginApplication.class, args);
	}
}
