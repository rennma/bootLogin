package com.yijiupi.login.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置一个自定义配置文件，有这个类负责引入.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
@Configuration
@ConfigurationProperties(prefix = "path", ignoreUnknownFields = false)
@PropertySource("classpath:config/relativeUploadPath.properties")
public class RelativeUploadPathProperties {

	/** 图片存储的具体路径. */
	private String imagePath;

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
