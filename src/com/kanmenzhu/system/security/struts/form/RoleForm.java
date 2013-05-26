package com.kanmenzhu.system.security.struts.form;
/**
 * ���/�޸Ľ�ɫ 
 */
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.converters.StringArrayConverter;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class RoleForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5431360513788270890L;
	private String roleName;
	private String roleDec;
	private String delTag;
	private String ug_id;
	private String method;
	private int roleId;
	public String getRoleDec() {
		return roleDec;
	}
	public void setRoleDec(String roleDec) {
		this.roleDec = roleDec;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDelTag() {
		return delTag;
	}
	public void setDelTag(String delTag) {
		this.delTag = delTag;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUg_id() {
		return ug_id;
	}
	public void setUg_id(String ug_id) {
		this.ug_id = ug_id;
	}
}
