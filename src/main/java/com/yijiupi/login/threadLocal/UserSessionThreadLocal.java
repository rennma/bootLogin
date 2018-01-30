package com.yijiupi.login.threadLocal;

import java.util.HashMap;
import java.util.HashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 该类使用ThreadLocal做容器，在请求进入controller之前截取session全部属性，在请求离开controller之后将所有改变过的属性同步到session中.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
@Component
public class UserSessionThreadLocal {

	private static Logger LOGGER = LoggerFactory.getLogger(UserSessionThreadLocal.class);
	/**
	 * ThreadLocal存放Collection数组，第一个元素时Hashset<String>,存放所有要添加到session中的属性的key，
	 * 第二个是HashMap<String,Object>,存放session中所有属性的键值对，第三个元素是HashSet<String>,
	 * 存放要从session删除的元素的key.
	 */
	private ThreadLocal<Object[]> userSessionLocal = new ThreadLocal() {

		@Override
		protected Object[] initialValue() {
			return new Object[] { new HashSet<String>(), new HashMap<String, Object>(), new HashSet<String>() };
		}
	};

	/**
	 * 该方法获得session中所有属性的键值对.
	 * 
	 * @return HashMap<String,Object>,存放session中所有属性的键值对
	 */
	public HashMap<String, Object> getUserSessionAttributes() {
		LOGGER.info(Thread.currentThread().getName());
		return new HashMap((HashMap<String, Object>) userSessionLocal.get()[1]);

	}

	/**
	 * 该方法返回所有要同步到session中的属性的key,返回完后userSessionThreadLocal中该容器会被清空.
	 * 
	 * @return HashSet<String>,存放所有要同步到session中的属性的key.
	 */
	public Object[] getUserSessionAttributesNameToAdd() {
		HashSet<String> userSessionAttributesNameToAdd = (HashSet<String>) userSessionLocal.get()[0];
		Object[] toAddAttributesNameArray = userSessionAttributesNameToAdd.toArray();
		// userSessionAttributesNameToAdd.clear();
		return toAddAttributesNameArray;
	}

	/**
	 * 更改session中属性的值
	 * 
	 * @param attributeName
	 *            要设置属性的key
	 * @param attributeValue
	 *            要设置属性的值
	 */
	public void setUserSessionAttribute(String attributeName, Object attributeValue) {
		((HashMap<String, Object>) userSessionLocal.get()[1]).put(attributeName, attributeValue);
		((HashSet<String>) userSessionLocal.get()[0]).add(attributeName);
	}

	/**
	 * 根据指定key获取session中属性的值.
	 * 
	 * @param attributeName
	 *            要获取的session中的属性的key.
	 * @return 获取到的session中的属性的值.
	 */
	public Object getUserSessionAttribute(String attributeName) {
		return ((HashMap<String, Object>) userSessionLocal.get()[1]).get(attributeName);
	}

	/**
	 * 根据指定key获取session中属性的值,该操作会删除原容器中的键值对.
	 * 
	 * @param attributeName
	 *            要获取的session中的属性的key.
	 * @return 获取到的session中的属性的值.
	 */
	public Object getUserSessionAttributeWithRemove(String attributeName) {
		return ((HashMap<String, Object>) userSessionLocal.get()[1]).remove(attributeName);
	}

	/**
	 * 根据指定的key删除对应属性.
	 * 
	 * @param attributeName
	 *            要删除的session中的属性的key
	 */
	public void removeUserSessionAttribute(String attributeName) {
		((HashSet<String>) userSessionLocal.get()[0]).remove(attributeName);
		((HashMap<String, Object>) userSessionLocal.get()[1]).remove(attributeName);
		((HashSet<String>) userSessionLocal.get()[2]).add(attributeName);
	}

	/**
	 * 获取同步到session时要从session中删除的属性的key的集合,返回完后userSessionThreadLocal中该容器会被清空.
	 * 
	 * @return HashSet<String> 返回session中要删除的属性的key的集合.
	 */
	public Object[] getUserSessionAttributesToRemove() {
		HashSet<String> userSessionAttributesNameToRemove = (HashSet<String>) userSessionLocal.get()[2];
		Object[] toAddAttributesNameToRemove = userSessionAttributesNameToRemove.toArray();
		// userSessionAttributesNameToRemove.clear();
		return toAddAttributesNameToRemove;
	}
}
