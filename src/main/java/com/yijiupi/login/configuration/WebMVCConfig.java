package com.yijiupi.login.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yijiupi.login.interceptor.LoginedInterceptor;
import com.yijiupi.login.interceptor.UserSessionThreadLocalInterceptor;

/**
 * springboot应用程序WebMVC配置类.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {
	/**
	 * 向springMVC注册拦截器.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginedInterceptor()).addPathPatterns("/logined/**");
		registry.addInterceptor(new UserSessionThreadLocalInterceptor()).addPathPatterns("/logined/**");
		super.addInterceptors(registry);
	}

}
