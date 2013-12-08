package com.kanmenzhu.utils.pagination;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页工具类,分页前需要使用到
 * @author w_ch
 *
 */
public class PageUtil {

	public static PageBean getPbReq(HttpServletRequest req){
		PageBean pb=new PageBean();
		String baseUrl=req.getRequestURL().toString();
		if(baseUrl.startsWith("/")){
			baseUrl=baseUrl.substring(1);
		}
		
		//if(baseUrl.indexOf("?"))
		Map<String,String[]> paramMap=req.getParameterMap();
		StringBuilder sb=new StringBuilder();
		if(null!=paramMap){
			for(Object k:paramMap.keySet()){
				//String[] v=
				if(PageBean.CUR_PAGE.equals(k)){
					pb.setCurPage(Integer.valueOf(paramMap.get(k)[0]));
					continue;
				}
				sb.append(k).append("=").append((String)paramMap.get(k)[0]).append("&");
			}
		}
		if(sb.length()>0){
			pb.setBaseUrl(baseUrl+"?"+sb.toString());
		}else{
			pb.setBaseUrl(baseUrl);
		}
		if(0==pb.getCurPage()){
			pb.setCurPage(1);
		}
		//pb.setCurPage(1);
		return pb;
	}
}
