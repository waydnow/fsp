package com.kanmenzhu.system.security.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.converters.IntegerArrayConverter;
import org.apache.commons.beanutils.converters.StringArrayConverter;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.aop.framework.HashMapCachingAdvisorChainFactory;

import com.wondersgroup.framework.base.BaseAction;
import com.wondersgroup.qxgl.service.UserService;
import com.wondersgroup.qxgl.struts.form.QueryInputForm;
import com.wondersgroup.qxgl.struts.form.RoleForm;

public class RoleAction extends BaseAction{
	public UserService qxglRoleService;
	
	//�½���ɫ
	public ActionForward creatRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RoleForm roleForm=(RoleForm)form;
		String rolename=roleForm.getRoleName();
		String roledec=roleForm.getRoleDec();
		
		//System.out.println(rolename+":"+roledec);
		List list=this.qxglRoleService.queryRoleByRolename(rolename);
		if(list.size()>0){
			request.setAttribute("retuMsg", "��ɫ���Ѵ���,��ѡ�������ɫ!");
			request.setAttribute("retuPara", "2");
			request.setAttribute("retuPage", "qxgl/addrole.jsp");
			return mapping.findForward("retuinfo");
		}else{
			Map map=new HashMap();
			map.put("rolename", rolename);
			map.put("roledec", roledec);
			this.qxglRoleService.creatRole(map);
			request.setAttribute("retuMsg", "����½�ɫ�ɹ�!");
			request.setAttribute("retuPara", "0");
			return mapping.findForward("retuinfo");
		}
	}

	/**
	 * ���ص���ɫ������ҳ��
	 */
	public ActionForward queryRoleByCon(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QueryInputForm queryInputForm=(QueryInputForm)form;
		Map map=new HashMap();
		List list;
		String deltag=null;
		String qRole=queryInputForm.getInputText();
		deltag=queryInputForm.getState();
		if("deleted".equals(deltag))
			deltag="1";
		else
			deltag="0";
		/**�˴�Ϊ�޸�ǰ*/
		if(qRole==null||"".equals(qRole.trim())){
			map.put("deltag", deltag);
			list = this.qxglRoleService.queryRoleByDeltag(deltag);
		}else{
			map.put("deltag", deltag);
			map.put("rolename", qRole);
		try {
			list=this.qxglRoleService.queryRoleByCon(map);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("retuMsg", "�򿪽�ɫ�б�ʧ��!");
			request.setAttribute("retuPara","0");
			return mapping.findForward("succ");
		}
		}
		request.setAttribute("rolelist", list);
		return mapping.findForward("rolemanager");
	
	}
	
	//���ɫ����ɾ����
	public ActionForward markRoleDeltag(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map map=new HashMap();
		Integer roleid=Integer.valueOf(request.getParameter("roleid"));
		map.put("roleid",roleid);
		map.put("deltag", request.getParameter("dt"));
		this.qxglRoleService.markRoleDeltag(map);
		String deltag="0";
		List list=this.qxglRoleService.queryRoleByDeltag(deltag);
		request.setAttribute("rolelist", list);
		return mapping.findForward("rolemanager");		
	}
	//�޸Ľ�ɫ��Ϣ
	public ActionForward modiRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		RoleForm roleForm=(RoleForm)form;
		String roledec=roleForm.getRoleDec();
		String roleid=String.valueOf(roleForm.getRoleId());
		Map map=new HashMap();
		map.put("roledec", roledec);
		map.put("roleid", Integer.valueOf(roleid));
		int retu=this.qxglRoleService.modiRole(map);
		request.setAttribute("retuMsg", "�޸Ľ�ɫ��Ϣ�ɹ�!");
		request.setAttribute("retuPara", "0");
		return mapping.findForward("retuinfo");
	}
	//ͨ���ɫID���ɫ��Ϣ
	public ActionForward queryRoleById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String rid=request.getParameter("rid");
		Integer roleid=(Integer)Integer.valueOf(rid);
		List list=this.qxglRoleService.queryRoleById(roleid);
		RoleForm rinfo=(RoleForm)form;
		Map map=(Map)list.get(0);
		rinfo.setRoleId(((Integer)map.get("ROLEID")).intValue());
		rinfo.setRoleDec(map.get("ROLEDEC").toString());
		rinfo.setRoleName(map.get("ROLENAME").toString());
		request.setAttribute("rinfo", rinfo);
		return mapping.findForward("modirole");
	}
	//��ѯָ�������û��������Ľ�ɫ��Ϣ��ID�Լ������ڸ��û��Ľ�ɫ���ϡ��Է��ص��û�����ҳ���еĽ�ɫ���������б��
	public ActionForward queryRoleByUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username="";
		String uid=request.getParameter("uid");
		Integer userid=(Integer)Integer.valueOf(uid);
		List list1=this.qxglRoleService.queryRoleConUser(userid);
		List list2=this.qxglRoleService.queryRoleNotConUser(userid);
		List list3=this.qxglRoleService.queryUserById(userid);
		if(list3.size()>0){
			Map map=(Map)list3.get(0);
			username=map.get("USERNAME").toString();
		}
		request.setAttribute("username", username);	
		request.setAttribute("userid", userid);
		request.setAttribute("roleinuser", list1);
		request.setAttribute("rolenotinuser", list2);
		return mapping.findForward("roletz");
	}
	//��ѡ���Ľ�ɫ����ָ�����û���
	public ActionForward setRoleToUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] selval=request.getParameterValues("selSubmit");
		String userid=request.getParameter("userid");
		int selNum=0;
		Map dmap=new HashMap();
		Map imap=new HashMap();
		dmap.put("opname", "USERID");
		dmap.put("opid", Integer.valueOf(userid));
		this.qxglRoleService.delQxByUR(dmap);//ɾ��ǰ�û������н�ɫ
		if(selval!=null){
			selNum=selval.length;
		}
		//System.out.println("selNum"+selNum);
		for(int i=0;i<selNum;i++){
			imap.put("userid", Integer.valueOf(userid));
			imap.put("roleid", Integer.valueOf(selval[i]));
			//System.out.println(i+"uid:"+imap.get("roleid").toString());
			this.qxglRoleService.adjustRoleUser(imap);
		}
		request.setAttribute("retuMsg", "����ɹ�!");
		request.setAttribute("retuPara", "2");
		request.setAttribute("retuPage", "qxglQueryUR.do?method=queryUserByCon");
		return mapping.findForward("retuinfo");
	}
	//��ѯָ��ָ����ɫ���������û���Ϣ��ID�Լ������ڸý�ɫ���û����ϡ��Է��ص���ɫ����ҳ���е��û����������б��
	public ActionForward queryUserByRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String rolename="";
		String rid=request.getParameter("rid");
		Integer roleid=(Integer)Integer.valueOf(rid);
		List list1=this.qxglRoleService.queryUserConRole(roleid);
		List list2=this.qxglRoleService.queryUserNotConRole(roleid);
		List list3=this.qxglRoleService.queryRoleById(roleid);
		if(list3.size()>0){
			Map map=(Map)list3.get(0);
			rolename=map.get("ROLENAME").toString();
		}
		request.setAttribute("roleid", rid);
		request.setAttribute("rolename", rolename);
		request.setAttribute("userinrole", list1);
		request.setAttribute("usernotinrole", list2);
		return mapping.findForward("usertz");
	}
	//��ɫ�����û�����ѡ�����û�����ĳһ��ɫ��
	public ActionForward setUserToRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] selval=request.getParameterValues("selSubmit");
		String roleid=request.getParameter("rid");
		//System.out.println("roleid:"+roleid);
		int selNum=0;
		Map dmap=new HashMap();
		Map imap=new HashMap();
		dmap.put("opname", "ROLEID");
		dmap.put("opid", Integer.valueOf(roleid));
		this.qxglRoleService.delQxByUR(dmap);//ɾ��ǰ�û������н�ɫ
		if(selval!=null){
			selNum=selval.length;
		}
		//System.out.println("selNum"+selNum);
		for(int i=0;i<selNum;i++){
			imap.put("roleid", Integer.valueOf(roleid));
			imap.put("userid", Integer.valueOf(selval[i]));
			this.qxglRoleService.adjustRoleUser(imap);
		}
		request.setAttribute("retuMsg", "����ɹ�!");
		request.setAttribute("retuPara", "2");
		request.setAttribute("retuPage", "qxglQueryRole.do?method=queryRoleByCon");
		return mapping.findForward("retuinfo");
	}
	public UserService getQxglRoleService() {
		return qxglRoleService;
	}


	public void setQxglRoleService(UserService qxglRoleService) {
		this.qxglRoleService = qxglRoleService;
	}

}
