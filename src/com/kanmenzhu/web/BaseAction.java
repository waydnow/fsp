package com.kanmenzhu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础action
 * @author ch_w
 *
 */
public class BaseAction {
	public final String SUCC="success";
	public final String FAIL="fail";
	/**用户登录信息*/
	public static final String SESSION_USER_INFO="session_user";
	/***/
	protected Logger logger=LoggerFactory.getLogger(getClass());
}
