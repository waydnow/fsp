package com.kanmenzhu.system.security.entity;

import com.kanmenzhu.bean.BaseBean;

// Generated 2013-5-29 22:00:52 by Hibernate Tools 3.4.0.CR1

/**
 * LuUser generated by hbm2java
 */
public class LuUser extends BaseBean {

	private String name;
	private String loginName;
	private String pwd;
	private String pwdCopy;
	private Integer deptId;
	public String getPwdCopy() {
		return pwdCopy;
	}

	public void setPwdCopy(String pwdCopy) {
		this.pwdCopy = pwdCopy;
	}

	private String phone;
	private String mobile;
	private String email;
	private Integer deltag;
	private String headImg;
	private String memo;
	private String depName;
	private String role;

	public LuUser() {
	}

	public LuUser(String name, String loginName, String pwd) {
		this.name = name;
		this.loginName = loginName;
		this.pwd = pwd;
	}

	public LuUser(String name, String loginName, String pwd, Integer deptId,
			String phone, String mobile, String email, Integer deltag,
			String headImg, String memo) {
		this.name = name;
		this.loginName = loginName;
		this.pwd = pwd;
		this.deptId = deptId;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.deltag = deltag;
		this.headImg = headImg;
		this.memo = memo;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDeltag() {
		return this.deltag;
	}

	public void setDeltag(Integer deltag) {
		this.deltag = deltag;
	}

	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	/**
	 * 密码比较
	 * @param u 待比较的用户
	 * @return
	 */
	public boolean pwdEquals(LuUser u){
		return u.getPwd()==null?false:u.getPwd().equals(this.pwd);
	}

	@Override
	public String toString() {
		return super.toString()+"LuUser [name=" + name + ", loginName=" + loginName + ", pwd="
				+ pwd + ", deptId=" + deptId + ", phone=" + phone + ", mobile="
				+ mobile + ", email=" + email + ", deltag=" + deltag + "]";
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
