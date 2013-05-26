package com.kanmenzhu.system.security.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.mapper.ActionMapping;

import com.kanmenzhu.system.security.service.UserService;
import com.kanmenzhu.web.BaseAction;

public class MenuAction extends BaseAction {
	public UserService menuService;
	/**
	 * ��ѯָ����ɫ�����в˵���Ȩ����Ϣ������ʾ��Ȩ������ҳ���ϡ�
	 */
	public ActionForward queryAccessByRoleid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String roleid=request.getParameter("rid");
		List list=this.menuService.queryAccessByRoleid(Integer.valueOf(roleid));
		List list1=this.menuService.queryAllMenu();
		List list2=this.menuService.queryRoleById(new Integer(Integer.parseInt(roleid)));
		String rolename=((Map)list2.get(0)).get("ROLENAME").toString();
		request.setAttribute("rolename", rolename);
		request.setAttribute("acclist", list);
		request.setAttribute("menulist", list1);
		request.setAttribute("roleid", roleid);
		return mapping.findForward("qxmanage");
		
		
	}
	/**
	 * ��ѯ���л�Ľ�ɫ
	*/
	public ActionForward queryActiveRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String deltag="0";
		List list=this.menuService.queryRoleByDeltag(deltag);
		request.setAttribute("rolelist", list);
		return mapping.findForward("selrole");
	}
	/**
	 * Ȩ�޹����м�ת����ʵ�����塣(����ͳһ)
	*/
	public ActionForward setAccess(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("setaccess");
	}
	/**
	 *���˵���ҳ�棩Ȩ�޸����ɫ 
	*/
	public ActionForward setAccessToRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] selSubmit=request.getParameterValues("selSub");
		String menuid;
		String access;
		Integer roleid=new Integer (Integer.parseInt(request.getParameter("rid")));
		this.menuService.delAccessByRoleid(roleid);//�����Ŀ���ɫ��Ȩ����Ϣ
		Map map=new HashMap();
		int length=selSubmit.length;
		while(length>0){//д����Ȩ��
			length--;
			menuid=selSubmit[length].substring(0,8);//�˵�ID
			access=selSubmit[length].substring(8);
			map.put("menuid", menuid);
			map.put("access", access);
			map.put("roleid", roleid);
			this.menuService.setAccessToRole(map);
			map.clear();
		}
		
		List list=this.menuService.queryAccessByRoleid(roleid);
		List list1=this.menuService.queryAllMenu();
		List list2=this.menuService.queryRoleById(roleid);
		String rolename=((Map)list2.get(0)).get("ROLENAME").toString();
		request.setAttribute("rolename", rolename);
		request.setAttribute("acclist", list);
		request.setAttribute("menulist", list1);
		request.setAttribute("roleid",roleid.toString());
		return mapping.findForward("qxmanage");
		
	}
	/**
	 *���Ȩ����ʾ2��3��4���˵� 
	*/
	public ActionForward showMenu(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userid=(String)request.getSession().getAttribute("userId");
//		Integer userid=new Integer(Integer.parseInt((String)request.getSession().getAttribute("userId")));
		
		if(userid==null||"".equals(userid)){//��¼��ʱ
			request.setAttribute("retuMsg", "�Բ���,��¼��ʱ,�����µ�¼!");
			request.setAttribute("retuPara", "3");
			request.setAttribute("retuPage", "login.jsp");
			return mapping.findForward("retuinfo");
		}
		String mnstartid=request.getParameter("mnstartid").toString();
		Map smap=new HashMap();
		Map gmap=new HashMap();
		String mntotal2;//2���˵�����
		String mntotal2sub;//��3���Ӳ˵���2���˵�����(LINKPAGE=null)
		String mntotal2nosub;//��3���Ӳ˵���2���˵�����
		String mntotal34link;//��4���Ӳ˵���3���Ӳ˵�+4���Ӳ˵��ĸ���.
		String menuid;
		String menulevel;
		String mainmenuname;
		
		smap.put("userid", Integer.valueOf(userid));
		smap.put("mnstartid", mnstartid);
		
		List total2=this.menuService.countMainMenu(smap);//���û����ܷ��ʵ���mnstartid��ͷ��2���˵�����������Ӳ˵������Ӳ˵���
		List total2sub=this.menuService.countMainMenuConSub(smap);//���û����ܷ��ʵ���mnstartid��ͷ��2���˵�����(���Ӳ˵�)
		List allsubmenu=this.menuService.querySubMenuByCon(smap);//���û������ܷ��ʵ���msnstartid��ͷ�Ĳ˵��б�(1���˵�����)
		List submenu34=this.menuService.countSubMenuConLink(smap);//���û������ܷ��ʵ���msnstartid��ͷ��3/4���˵������Ӹ���
		List lmainmenuname=this.menuService.queryMainMenuNameBySubid(mnstartid);//�û�������һ�����˵���ơ�
		
		gmap=(Map)total2.get(0);
		mntotal2=gmap.get("totalmn").toString();
		gmap=(Map)total2sub.get(0);
		mntotal2sub=gmap.get("totalmn").toString();
		mntotal2nosub=String.valueOf((Integer.parseInt(mntotal2)-Integer.parseInt(mntotal2sub)));
		gmap=(Map)submenu34.get(0);
		mntotal34link=gmap.get("totalmn").toString();
		gmap=(Map)lmainmenuname.get(0);
		mainmenuname=gmap.get("MENUNAME").toString();
		
		for(int i=0;i<allsubmenu.size();i++){//��ÿ���˵����ϼ����ʶ
			gmap=(Map)allsubmenu.get(i);
			menuid=gmap.get("MENUID").toString();
			if("0000".equals(menuid.substring(4))){
				menulevel="2";
			}else
				if("00".equals(menuid.substring(6))){
					menulevel="3";
				}else
					menulevel="4";
			gmap.put("menulevel", menulevel);
		}
		request.setAttribute("mainmenuname", mainmenuname);
		request.setAttribute("mntotal2", mntotal2);
		request.setAttribute("mntotal2sub", mntotal2sub);
		request.setAttribute("mntotal2nosub", mntotal2nosub);
		request.setAttribute("mntotal34link", mntotal34link);
		request.setAttribute("allsubmenu", allsubmenu);
		return mapping.findForward("showmenu");
	}
	/**
	 *��ǰ�û����ܷ��ʵ������˵� 
	*/
	public ActionForward queryMainMenuByUserid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userid=request.getSession().getAttribute("userId").toString();
		List list=this.menuService.queryMainMenuByUserid(new Integer(userid));
		Map map=new HashMap();
		for(int i=0;i<list.size();i++){
			map=(Map)list.get(i);
			map.put("MENUID", (map.get("MENUID").toString()).substring(0,2));//ȡǰ��λ
		}
		request.setAttribute("mainmenulist",list);
		return mapping.findForward("head");
	}
	
	public UserService getMenuService() {
		return menuService;
	}

	public void setMenuService(UserService menuService) {
		this.menuService = menuService;
	}
	

}
