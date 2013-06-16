package com.kanmenzhu.web;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.http.HttpServletResponse;

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
	
	/**学校订单未提交*/
	public final int ADUIT = 0;
	/**学校提交订单，文教局审核中*/
	public final int ADUIT_ING = 1;
	/**文教局审核通过*/
	public final int ADUIT_SUCCESS = 2;
	/**文教局审核失败*/
	public final int ADUIT_FAIL = 3;
	/**供应商提交真实订单给学校*/
	public final int ADUIT_END = 4;
	
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
	/**
	 * ajax 响应
	 * @param respBody
	 */
	protected String ajaxResp(String respBody){
		HttpServletResponse resp=ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");//解决中文乱码
		try {
			resp.getWriter().write(respBody);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
