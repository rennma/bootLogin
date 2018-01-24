package com.yijiupi.login.threadLocal;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class UserSessionThreadLocal {
	public static final ThreadLocal<Collection[]> USER_SESSION_THREADLOCAL = new ThreadLocal() {

		@Override
		protected Object initialValue() {
			Object[] object = { new HashSet<String>(), new HashMap<String, Object>() };
			this.set(object);
			return object;
		}

	};

	public static HashMap<String, Object> getUserSession() {
		return (HashMap<String, Object>) USER_SESSION_THREADLOCAL.get()[1];
	}

	public static HashSet<String> getUserSessionAttributesName() {
		return (HashSet<String>) USER_SESSION_THREADLOCAL.get()[0];
	}

	public static void setUserSessionAttributes(String attributeName, Object attributeValue) {
		((HashMap<String, Object>) USER_SESSION_THREADLOCAL.get()[1]).put(attributeName, attributeValue);
		((HashSet<String>) USER_SESSION_THREADLOCAL.get()[0]).add(attributeName);
	}

	public static Object gUserSessionAttributes(String attributeName) {
		return ((HashMap<String, Object>) USER_SESSION_THREADLOCAL.get()[1]).get(attributeName);
	}
}
