package com.yijiupi.login.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.yijiupi.login.threadLocal.UserSessionThreadLocal;

/**
 * 拦截截取用户session的类，每当浏览器访问服务器.该类会将session中的所有属性复制到ThreadLocal中，服务器响应信息给浏览器时，
 * 该类会将被添加到ThreadLocal中的属性复制到session中，也就是说，ThreadLocal在controller层起session的作用 .
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public class UserSessionThreadLocalInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserSessionThreadLocalInterceptor.class);

	@Autowired
	private UserSessionThreadLocal userSessionThreadLocal;

	/*
	 * 在用户请求进入controller层之前，该拦截器会将session中的属性全部截取到ThreadLocal中.
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 获取session中全部属性的key的集合.
		HttpSession session = request.getSession();

		Enumeration<String> sessionAttributesName = session.getAttributeNames();

		// 该变量存放循环时每一次的属性的key.
		String attributeName;

		// 将Httpsession中的全部属性放入ThreadKLocal中.
		Map<String, Object> userSession = userSessionThreadLocal.getUserSessionAttributes();
		while (sessionAttributesName.hasMoreElements()) {
			attributeName = sessionAttributesName.nextElement();
			userSession.put(attributeName, session.getAttribute(attributeName));
		}

		// 处理完毕，放行.
		LOGGER.info("有用户请求访问，已截取到用户session全部属性");
		LOGGER.info(userSession.toString());
		LOGGER.info(Thread.currentThread().getName());
		LOGGER.info(userSessionThreadLocal.getUserSessionAttributes().toString());
		return true;
	}

	/*
	 * 在用户请求离开controller之后、响应的视图被渲染之前，将对ThreadLocal的修改和删除全部同步到HttpSession中.
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.
	 * http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();

		// 获得被Set到ThreadLocal中的全部属性的key的集合.
		Object[] toAddAttributesNameArray = userSessionThreadLocal.getUserSessionAttributesNameToAdd();

		// 获得ThreadLocal中全部属性的集合.
		Map<String, Object> userSession = userSessionThreadLocal.getUserSessionAttributes();
		LOGGER.info(Thread.currentThread().getName());
		LOGGER.info(userSessionThreadLocal.getUserSessionAttributes().toString());
		// 根据key的集合和属性的集合把进行了Set操作的属性全部同步到HttpSession中.
		for (Object attributeName : toAddAttributesNameArray) {
			session.setAttribute((String) attributeName, userSession.get(attributeName));
		}

		// 获得被从ThreadLocal中删除的全部属性的key的集合.
		Object[] toRemoveAttributesNameArray = userSessionThreadLocal.getUserSessionAttributesToRemove();

		// 根据上一步获得的key的集合将session中对应属性删除.
		for (Object attributeName : toRemoveAttributesNameArray) {
			session.removeAttribute((String) attributeName);
		}

		LOGGER.info("服务器返回信息给浏览器，userSession中的数据全部被添加到HttpSession中了");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
