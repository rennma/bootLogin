package com.yijiupi.login;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * springboot应用程序主配置类，也是该应用启动类.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
@MapperScan("com.yijiupi.login.dao")
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
