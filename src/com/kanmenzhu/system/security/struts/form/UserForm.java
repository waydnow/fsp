package com.kanmenzhu.system.security.struts.form;
/**
 * /**
 * ���/�޸��û� 
 */

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.mapper.ActionMapping;

public class UserForm {
	private static final long serialVersionUID = -6238798173874662499L;
	private String loginName;
	private int userId;
	private String oldpwd;//�����룬�����޸�����ʱ�á�
	private String pwd;
	private String vpwd;//�޸�����ʱ������֤
	private String userName;
	private String userDec;
	private String delTag;
	private String yljgdm;//�����(ҽ�ƻ����)
	private String ug_id;//�û���id
	private String method;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	
	public String getDelTag() {
		return delTag;
	}
	public void setDelTag(String delTag) {
		this.delTag = delTag;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserDec() {
		return userDec;
	}
	public void setUserDec(String userDec) {
		this.userDec = userDec;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVpwd() {
		return vpwd;
	}

	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getYljgdm() {
		return yljgdm;
	}

	public void setYljgdm(String yljgdm) {
		this.yljgdm = yljgdm;
	}

	public String getUg_id() {
		return ug_id;
	}

	public void setUg_id(String ug_id) {
		this.ug_id = ug_id;
	}
	

}
