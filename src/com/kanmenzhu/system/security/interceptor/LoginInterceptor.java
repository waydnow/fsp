package com.kanmenzhu.system.security.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.web.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {
	private static final long serialVersionUID = 1L;
	private Logger logger=LoggerFactory.getLogger(getClass());

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String, Object> session=ActionContext.getContext().getSession();
		LuUser user=(LuUser)session.get(BaseAction.SESSION_USER_INFO);
		if(null==user){
			logger.warn("未登录");
		}else{
			logger.info("已登录,user:"+user);
			Object action= arg0.getAction();
			if(action instanceof BaseAction){
				((BaseAction)action).setCurrentUser(user);
			}
		}
		
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
