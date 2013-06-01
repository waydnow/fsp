package com.kanmenzhu.system.security.util;

import javax.servlet.http.HttpSession;

/**
 * 管理session的工具,便于以后扩展到缓存
 * @author ch_w
 *
 */
public class SesseionTools {

	public static void saveSession(String key,Object o,HttpSession session){
		session.setAttribute(key, o);
	}
	
	public static Object getObj(String key,HttpSession session){
		return session.getAttribute(key);
	}
	
	public static void destorySession(String key,HttpSession session){
		session.removeAttribute(key);
	}
}
