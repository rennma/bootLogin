package com.yijiupi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.yijiupi.interceptor.LoginedInterceptor;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginedInterceptor()).addPathPatterns("/logined/**");
		super.addInterceptors(registry);
	}

}
