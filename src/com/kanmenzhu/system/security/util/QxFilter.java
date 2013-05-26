package com.kanmenzhu.system.security.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class QxFilter implements Filter {
	private static Logger log = Logger.getLogger(QxFilter.class.getName());
	protected FilterConfig filterConfig = null;
	private String noAuthUrl;
	private String loginUrl;
	private String url="",surl="";

	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig = null;

	}
	private String[] getClientIpMac(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for"); 
		if(ip == null || ip.length() == 0){ 
			ip = request.getRemoteAddr(); 
			log.info("Remote ip:"+ip);
		} 
		//return ip; 
		return null;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)throws IOException, ServletException {
		getClientIpMac((HttpServletRequest) request);
		String url=((HttpServletRequest) request).getRequestURI();
		String method=((HttpServletRequest) request).getParameter("method");
		String userid=(String)((HttpServletRequest) request).getSession().getAttribute("userId");
		
		
		
		if(!("login".equals(method)||"logOut".equals(method))&&("".equals(userid)||userid==null)){//�û�id sessionΪ��,δ��¼���¼��ʱ.
			((HttpServletResponse) response).sendRedirect("qxgl/noAuth.jsp"); //��Ȩ��ת������ҳ��
			return;
		}
//		System.out.println("url:"+url);
//		System.out.println("Method:"+method);
		chain.doFilter(request,response);
	}

	public void init(FilterConfig filterConfig) throws ServletException { 
		this.filterConfig = filterConfig; 
		this.noAuthUrl = filterConfig.getInitParameter("noAuthUrl");
		this.loginUrl = filterConfig.getInitParameter("loginUrl");
		
	}

}
