package com.kanmenzhu.system.security.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class SelectForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6937652342222491814L;
	
	private String[] selSubmit;
	


	public String[] getSelSubmit() {
		return selSubmit;
	}

	public void setSelSubmit(String[] selSubmit) {
		this.selSubmit = selSubmit;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
