package com.yijiupi.login.interceptor;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.yijiupi.login.threadLocal.UserSessionThreadLocal;

/**
 * 拦截截取用户session的类.
 * 
 * @author 魏阳军
 * @date 2018年1月24日 14:41
 * @since jdk1.8.0
 */
public class UserSessionThreadLocalInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserSessionThreadLocalInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Enumeration<String> sessionAttributesName = session.getAttributeNames();
		String attributeName;
		Map<String, Object> userSession = UserSessionThreadLocal.getUserSession();
		while (sessionAttributesName.hasMoreElements()) {
			attributeName = sessionAttributesName.nextElement();
			userSession.put(attributeName, session.getAttribute(attributeName));
		}
		LOGGER.info("有用户请求访问，已截取到用户session全部属性");
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		HashSet<String> attributesNameSet = UserSessionThreadLocal.getUserSessionAttributesName();
		String[] attributesNameIterator = (String[]) attributesNameSet.toArray();
		Map<String, Object> userSession = UserSessionThreadLocal.getUserSession();
		for (String attributeName : attributesNameIterator) {
			session.setAttribute(attributeName, userSession.get(attributeName));
		}
		LOGGER.info("服务器返回信息给浏览器，userSession中的数据全部被添加到HttpSession中了");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
