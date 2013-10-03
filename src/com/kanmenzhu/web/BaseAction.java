package com.kanmenzhu.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kanmenzhu.system.security.entity.LuUser;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础action
 * @author ch_w
 *
 */
public class BaseAction extends ActionSupport {
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
	/**
	 * ajax 响应
	 * 
	 * @param respBody
	 * @param type 0:text/html,1:json
	 */
	protected String ajaxResp(String respBody,int type){
		HttpServletResponse resp=ServletActionContext.getResponse();
		if(type==0){
			resp.setContentType("text/html;charset=utf-8");//解决中文乱码
		}else{//
			resp.setContentType("application/json;charset=utf-8");//解决中文乱码
		}
		try {
			resp.getWriter().write(respBody);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
