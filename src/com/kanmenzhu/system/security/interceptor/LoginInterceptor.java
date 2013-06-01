package com.kanmenzhu.system.security.interceptor;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;
	private Logger logger=LoggerFactory.getLogger(getClass());

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		logger.info(ServletActionContext.getRequest().getSession().getId());
		logger.info("进了我的拦截器");
		return arg0.invoke();
	}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
