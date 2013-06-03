package com.kanmenzhu.web;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kanmenzhu.system.security.entity.LuUser;

/**
 * 基础action
 * @author ch_w
 *
 */
public class BaseAction {
	public final String SUCC="success";
	public final String FAIL="fail";
	private LuUser currentUser;
	/**用户登录信息*/
	public static final String SESSION_USER_INFO="session_user";
	/***/
	protected Logger logger=LoggerFactory.getLogger(getClass());
	/**获取当前登录的用户*/
	public LuUser getCurrentUser() {
		//return (LuUser)ServletActionContext.getRequest().getSession().getAttribute(SESSION_USER_INFO);
		return currentUser;
	}
	public void setCurrentUser(LuUser currentUser) {
		this.currentUser = currentUser;
	}
}
