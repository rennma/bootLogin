package com.yijiupi.login.threadLocal;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 该类使用ThreadLocal做容器，在请求进入controller之前截取session全部属性，在请求离开controller之后将所有改变过的属性同步到session中.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public class UserSessionThreadLocal {

	/**
	 * ThreadLocal存放Collection数组，第一个元素时Hashset<String>,存放所有要添加到session中的属性的key，
	 * 第二个是HashMap<String,Object>,存放session中所有属性的键值对，第三个元素是HashSet<String>,
	 * 存放要从session删除的元素的key.
	 */
	private static final ThreadLocal<Object[]> USER_SESSION_THREADLOCAL = new ThreadLocal() {

		@Override
		protected Object initialValue() {
			Object[] objects = { new HashSet<String>(), new HashMap<String, Object>(), new HashSet<String>() };
			this.set(objects);
			return objects;
		}

	};

	/**
	 * 该方法获得session中所有属性的键值对
	 * 
	 * @return HashMap<String,Object>,存放session中所有属性的键值对
	 */
	public static HashMap<String, Object> getSessionAttributes() {

		return new HashMap((HashMap<String, Object>) USER_SESSION_THREADLOCAL.get()[1]);

	}

	/**
	 * 该方法返回所有要同步到session中的属性的key.
	 * 
	 * @return HashSet<String>,存放所有要同步到session中的属性的key.
	 */
	public static HashSet<String> getSessionAttributesNameToAdd() {
		return (HashSet<String>) USER_SESSION_THREADLOCAL.get()[0];
	}

	/**
	 * 更改session中属性的值
	 * 
	 * @param attributeName
	 *            要设置属性的key
	 * @param attributeValue
	 *            要设置属性的值
	 */
	public static void setSessionAttribute(String attributeName, Object attributeValue) {
		((HashMap<String, Object>) USER_SESSION_THREADLOCAL.get()[1]).put(attributeName, attributeValue);
		((HashSet<String>) USER_SESSION_THREADLOCAL.get()[0]).add(attributeName);
	}

	/**
	 * 根据指定key获取session中属性的值.
	 * 
	 * @param attributeName
	 *            要获取的session中的属性的key.
	 * @return 获取到的session中的属性的值.
	 */
	public static Object getSessionAttribute(String attributeName) {
		return ((HashMap<String, Object>) USER_SESSION_THREADLOCAL.get()[1]).get(attributeName);
	}

	/**
	 * 根绝指定的key删除对应属性.
	 * 
	 * @param attributeName
	 *            要删除的session中的属性的key
	 */
	public static void removeSessionAttribute(String attributeName) {
		((HashSet<String>) USER_SESSION_THREADLOCAL.get()[0]).remove(attributeName);
		((HashMap<String, Object>) USER_SESSION_THREADLOCAL.get()[1]).remove(attributeName);
		((HashSet<String>) USER_SESSION_THREADLOCAL.get()[2]).add(attributeName);
	}

	/**
	 * 获取同步到session时要从session中删除的属性的key的集合.
	 * 
	 * @return HashSet<String> 返回session中要删除的属性的key的集合.
	 */
	public static HashSet<String> getSessionAttributesToRemove() {
		return ((HashSet<String>) USER_SESSION_THREADLOCAL.get()[2]);
	}
}
