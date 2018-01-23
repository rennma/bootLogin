package com.yijiupi.util;

/**
 * 该类是用于读取properties文件的工具类.
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 */
import java.io.*;
import java.util.Properties;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 *
 */
public class PropertyUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtils.class);

	/** jdk提供的读取属性文件的类. */
	private static Properties prop;

	/** 该静态代码块用于初始化，获得读取属性文件uploadPath.properties的字符输入流. */
	static {
		try {
			loadProps();
		} catch (FileNotFoundException e) {
			// 非正常退出.
			LOGGER.info(e.getMessage());
			System.exit(1);
		} catch (IOException e) {
			// 非正常退出.
			LOGGER.info(e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * 同步的静态私有方法，用于加载属性文件.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	synchronized static private void loadProps() throws IOException {
		prop = new Properties();
		InputStreamReader in = null;
		try {
			// 获得一个字符输入流
			in = new InputStreamReader(
					PropertyUtils.class.getClassLoader().getResourceAsStream("/uploadPath.properties"), "UTF-8");
			// 将这个流交给Properties类的实例.
			prop.load(in);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("文件未找到");
		} catch (IOException e) {
			throw new IOException("读取文件时发生异常");
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (IOException e) {
				throw new IOException("关闭IO流时发生异常");
			}
		}
	}

	/**
	 * 该方法用于根据键名从属性文件中获得一个值.
	 * 
	 * @param Key
	 *            String类型要获取属性的值.
	 * @return String 获取到的属性的值.
	 * @throws IOException
	 */
	public static String getProperty(String key) throws IOException {
		if (null == prop) {
			loadProps();
		}
		return prop.getProperty(key);
	}

	/**
	 * 该方法用于根据键名从属性文件中获得一个值，如果未找到对应键名、会返回指定的默认值.
	 * 
	 * @param Key
	 * @param defaultValue
	 *            String类型 调用该方法的代码指定该方法返回的默认值. String类型要获取属性的值.
	 * @return String 获取到的属性的值.
	 * @throws IOException
	 */
	public static String getProperty(String key, String defaultValue) throws IOException {

		if (null == prop) {
			loadProps();
		}
		return prop.getProperty(key, defaultValue);
	}
}
