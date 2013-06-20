package com.kanmenzhu.system.security.util;

import java.util.HashSet;
import java.util.Set;



public class UserInfo {
	int USERID;
	String loginName;
	String userName;
	String userDec;
	String delTag;
	String memo;
	String pwd;
	private Set addresses = new HashSet();
	
	public UserInfo(){
		
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public int getUSERID() {
		return USERID;
	}

	public void setUSERID(int userid) {
		USERID = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}

