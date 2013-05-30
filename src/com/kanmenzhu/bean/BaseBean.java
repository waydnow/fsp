package com.kanmenzhu.bean;

import java.io.Serializable;
/**
 * 实体基础类
 * @author ch_w
 *
 */
public class BaseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
