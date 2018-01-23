package com.yijiupi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.yijiupi.constant.UserConstant;
import com.yijiupi.controller.UserCommController;
import com.yijiupi.PO.UserPO;
import com.yijiupi.VO.UserVO;

/**
 * @author 魏阳军
 * @date 2018年1月15日 16:25
 * @since jdk1.8.0
 */
public class LoginedInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginedInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("发现用户进入后台，开始拦截");
		Object userVO = request.getSession().getAttribute(UserConstant.USER_IN_SESSION);
		if (userVO instanceof UserVO) {
			LOGGER.info("用户已登录，放行");
			return true;
		}

		response.sendRedirect("../comm/login.html");
		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
