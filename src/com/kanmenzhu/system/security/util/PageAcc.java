package com.kanmenzhu.system.security.util;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PageAcc {
	private ResultSet rs=null;
	private String sacc="";
	private String userid="";
	private int i=0;
	String acc="";
    private String[] bacc = {"0","0","0","0"};
    HttpServletRequest request;
    public PageAcc(){
		acc="0000";
	}
	/**
	 * ȡ���ҳ�浱ǰ�û���Ȩ��
	 * @param pgname ҳ���ļ���eg. login.jsp
	 * @return
	 */
    public String getAcc(String pgname){
    	HttpSession session = ((HttpServletRequest) request).getSession();
    	userid=(String)session.getAttribute("userId");
    	if(userid!=null){
    		if("1".equals(userid)){//�����û���Ȩ��1111
    			acc="1111";
    		}else{

    			AccDb stmt=new AccDb();
    			stmt.Connect();
    			rs=stmt.executeQuery("select ACCESS from T_QXGL_QX where MENUID in" +
    					"(select MENUID from T_QXGL_MENU where LINKPAGE='"+pgname+"') and" +
    					" ROLEID in(select ROLEID from T_QXGL_ROLEUSER where USERID=" +
    					userid+")");
    			try {
    				while(rs.next()){
    					sacc=rs.getString("ACCESS");
    					for(i=0;i<4;i++){
    						if((sacc.substring(i,i+1)).equals("1")){
    							bacc[i]="1";
    						}
    					}
    				}
    				/*
    				 * �����Ƿ��ǲ����˵�ҳ��
    				 */
    				rs=stmt.executeQuery("select count(*) from T_QXGL_UN where PAGENAME='"+pgname+"'");
    				rs.next();
    				if(rs.getInt(1)>0){
    					acc="1111";
    				}else{
    					acc=bacc[0]+bacc[1]+bacc[2]+bacc[3];
    				}
    				
    				rs.close();
    				stmt.disConnect();
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}

    		}

    	}else{
    		acc="ffff";//��¼��ʱ��
    	}
    	return acc;
    }
}
