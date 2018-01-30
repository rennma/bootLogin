package com.yijiupi.login.configuration;

import java.nio.charset.Charset;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
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
	
	@Bean
    public UserSessionThreadLocalInterceptor getUserSessionThreadLocalInterceptor(){
        return new UserSessionThreadLocalInterceptor();
    }
	
	/**
	 * 向springMVC注册拦截器.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginedInterceptor()).addPathPatterns("/logined/**");

		registry.addInterceptor(getUserSessionThreadLocalInterceptor()).addPathPatterns("/**");

		super.addInterceptors(registry);
	}

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(responseBodyConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}

}
