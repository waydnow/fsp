/*package com.wondersgroup.qxgl.struts.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.wondersgroup.framework.base.BaseAction;
import com.wondersgroup.qxgl.service.UserService;
import com.wondersgroup.qxgl.struts.form.QueryInputForm;
import com.wondersgroup.qxgl.struts.form.UserForm;
import com.wondersgroup.qxgl.util.Md5Security;

public class UserAction extends BaseAction {
	private String returnMsg;

	public UserService qxglLoginService;

	/**
	 * ��¼
	 * 
	 * @param mapping
	 * @param form 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	/*public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
		Map map = new HashMap();
		String md5Password = Md5Security.addMd5(userForm.getPwd());
		map.put("loginname", userForm.getLoginName());
		map.put("password", md5Password);
		List list = this.qxglLoginService.queryPwdForUser(map);
		request.setAttribute("list", list);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Map vmap = (Map) list.get(i);
				if (vmap.get("DELTAG").equals("0")) {// ������û�
					request.getSession().setAttribute("userId",
							vmap.get("USERID").toString());
					request.getSession().setAttribute("userName",
							(String)vmap.get("USERNAME"));
					request.getSession().setAttribute("loginName",
							(String)userForm.getLoginName());
					request.getSession().setAttribute("userDec",
							(String)vmap.get("USERDEC"));
					request.getSession().setAttribute("yljgdm",
						(String)vmap.get("YLJGDM"));
					request.getSession().setAttribute("qxtag",
							(String)vmap.get("QXTAG"));
					
					System.out.println("User \""+(String)userForm.getLoginName()+"\" logined in.");
					return mapping.findForward("loginSucc");
				} else {
					returnMsg = "����:�û����Ѿ���ɾ��!";
					request.setAttribute("message", returnMsg);
					return mapping.findForward("loginFail");
				}
			}
		} else {// δ�ҵ�
			returnMsg = "����:�û�����ڻ��������!";
			request.setAttribute("message", returnMsg);
			return mapping.findForward("loginFail");
		}
		return null;

	}

	/**
	 * ������û�
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	/*public ActionForward newuser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
		Map map = new HashMap();
		Map iMap=new HashMap();
		String yljgdm="";
		iMap.put("ug_id",Integer.valueOf(userForm.getUg_id()) );
		String md5Password = Md5Security.addMd5(userForm.getPwd());
		map.put("loginname", userForm.getLoginName());
		map.put("password", md5Password);
		map.put("userdec", userForm.getUserDec());
		map.put("username", userForm.getUserName());
		
		map.put("ug_id", Integer.valueOf(userForm.getUg_id()));
		List list = this.qxglLoginService.queryUser(map);// ��ѯ���û����Ƿ�ע��
		if (list.size() > 0) {
			request.setAttribute("retuMsg", "�û����Ѵ��ڣ���ѡ�������û�ע��!");
			request.setAttribute("retuPage", "qxglOpera.do?method=getUserGroup");
			request.setAttribute("retuPara", "2");
			return mapping.findForward("fail");
		} else {// �������û�
			try {//��ѯ��Ӧ�û���ID��ҽ�ƻ����
				list=this.qxglLoginService.queryForList("queryUserGroupById",iMap);
				if(list.size()>0){
					yljgdm=(String)((Map)list.get(0)).get("USERGROUP_YLJGDM");
				}
			} catch (Exception e) {
				request.setAttribute("retuMsg", "������û�ʧ��!");
				request.setAttribute("retuPara", "1");
				return mapping.findForward("fail");
			}
			yljgdm=yljgdm==null?"":yljgdm;
			map.put("yljgdm", yljgdm);
			Integer resu=this.qxglLoginService.creatUser(map);
			if(resu.intValue()>0){
				request.setAttribute("retuMsg", "������û��ɹ�!");
				request.setAttribute("retuPara", "0");
				return mapping.findForward("succ");
			}else{
				request.setAttribute("retuMsg", "������û�ʧ��!");
				request.setAttribute("retuPara", "1");
				return mapping.findForward("fail");
			}
		}
	}

	/**
	 * ��ѯ������û�
	 * �û�����ҳ����
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	/*public ActionForward queryUserByCon(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**�˴�Ϊ����ǰ���롣��ֻ��ѯ����ĳһ�û����
		QueryInputForm queryInputForm=(QueryInputForm)form;
		Map map=new HashMap();
		List list;
		String qState=null;
		String qUser=queryInputForm.getInputText();
		if(queryInputForm.getState()!=null)
			qState=queryInputForm.getState();
		if("deleted".equals(qState))
			qState="1";
		else
			qState="0";
		if(qUser==null||"".equals(qUser.trim())){
			map.put("deltag", qState);
			list = this.qxglLoginService.queryUserBydelTag(map);
		}else{
			map.put("deltag", qState);
			map.put("loginname", qUser);
			list=this.qxglLoginService.queryUserByCon(map);
		}
		//queryInputForm.setInputText(qUser);
		request.setAttribute("userlist", list);
		return mapping.findForward("usermanager");*/
		/*QueryInputForm queryInputForm=(QueryInputForm)form;
		Map map=new HashMap();
		List list;
		String qState=null;
		String qUser=queryInputForm.getInputText();
		String ug_id=(String)request.getSession().getAttribute("ug_id");
		if(queryInputForm.getState()!=null)
			qState=queryInputForm.getState();
		if("deleted".equals(qState))
			qState="1";
		else
			qState="0";
		map.put("loginname", qUser);
		map.put("deltag", qState);
		if(ug_id==null)
			ug_id="0";
		map.put("ug_id", Integer.valueOf(ug_id));
		try {
			list=this.qxglLoginService.queryForList("queryUserInUserGroup", map);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("retuMsg", "���û��б�ʧ��!");
			request.setAttribute("retuPara","0");
			return mapping.findForward("succ");
		}
		
		request.setAttribute("userlist", list);
		return mapping.findForward("usermanager");
	}


	//���û�����/ȡ��ɾ����
	/*public ActionForward markUserDeltag(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map map=new HashMap();
		Integer userid=Integer.valueOf( request.getParameter("userid"));
		String ug_id=(String)request.getSession().getAttribute("ug_id");
		map.put("userid",userid);
		map.put("deltag", request.getParameter("dt"));
		List list=null;
		this.qxglLoginService.markUserDeltag(map);
		map.put("deltag", "0");
		if(ug_id==null)
			ug_id="0";
		map.put("ug_id", Integer.valueOf(ug_id));
		try {
			list=this.qxglLoginService.queryForList("queryUserInUserGroup", map);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("retuMsg", "���û��б�ʧ��!");
			request.setAttribute("retuPara","0");
			return mapping.findForward("succ");
			// TODO: handle exception
		}
		
		request.setAttribute("userlist", list);
		return mapping.findForward("usermanager");
	}
	/**
	 * ����ɾ���û�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	/*public ActionForward delUserByUserid(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
			Integer userid=(Integer)Integer.valueOf((request.getParameter("uid").toString()));
			int retu2=this.qxglLoginService.delQxByUserid(userid);//ɾ������û��й�����Ȩ����Ϣ��
			int retu1=this.qxglLoginService.delUserByUserid(userid);//ɾ���û�
			request.setAttribute("retuMsg", "ɾ��ɹ�!");
		}catch(Exception e){
			System.out.println(e.getMessage());
			request.setAttribute("retuMsg", "����ɾ���û�ʧ��!");
		}
		request.setAttribute("retuPara", "2");
		request.setAttribute("retuPage", "qxglQueryUR.do?method=queryUserByCon");
		return mapping.findForward("succ");
		
	}
	//�޸�����
	public ActionForward modiPwd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm = (UserForm) form;
		Map map=new HashMap();
		String loginname=(String)request.getSession().getAttribute("loginName");
		String userid=(String)request.getSession().getAttribute("userId");
		map.put("loginname", loginname);
		try{
			List list=this.qxglLoginService.queryUser(map);
			Map vmap = (Map) list.get(0);
			String epwd=Md5Security.addMd5(userForm.getOldpwd());
			String newpwd=Md5Security.addMd5(userForm.getPwd());
			if("true".equals(request.getParameter("modi"))){//�޸�����
				if(vmap.get("PWD").equals(epwd)){//��������ͬ
					map.put("password", newpwd);
					map.put("userid", Integer.valueOf(userid));
					int retu=this.qxglLoginService.modiPwd(map);
					request.setAttribute("retuMsg", "�޸�����ɹ�����������Ч!");
					request.setAttribute("retuPara", "1");
					return mapping.findForward("succ");
				}else{//�������
					request.setAttribute("retuMsg", "����������޸�ʧ��!");
					request.setAttribute("retuPara", "2");
					request.setAttribute("retuPage", "qxglOpera.do?method=modiPwd");
					return mapping.findForward("succ");
				}
			}else{//��ѯ�û���Ϣ 
				request.setAttribute("uname", vmap.get("USERNAME").toString());
				request.setAttribute("lname", vmap.get("LOGINNAME").toString());
				return mapping.findForward("modipwd");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			request.setAttribute("retuMsg", "�ڲ��������,�޸�ʧ��!");
			request.setAttribute("retuPara", "2");
			request.setAttribute("retuPage", "qxglOpera.do?method=modiPwd");
			return mapping.findForward("succ");
		}
	}
	//ͨ���û�ID��ָ���û���Ϣ
	public ActionForward queryUserById(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		String uid=(String)request.getParameter("uid");
		Integer userid=(Integer)Integer.valueOf(uid);
		List list=this.qxglLoginService.queryUserById(userid);
		
		UserForm uinfo=(UserForm)form;
		Map vmap=(Map)list.get(0);
		uinfo.setUserId(((Integer)vmap.get("USERID")).intValue());
		uinfo.setUserDec(vmap.get("USERDEC").toString());
		uinfo.setUserName(vmap.get("USERNAME").toString());
		uinfo.setLoginName(vmap.get("LOGINNAME").toString());
		uinfo.setOldpwd(vmap.get("PWD").toString());
		request.setAttribute("uinfo", uinfo);
		return mapping.findForward("modiuser");
	}
	//�޸��û���Ϣ
	public ActionForward modiUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserForm userForm=(UserForm)form;
		Map map=new HashMap();
		String username=userForm.getUserName();
		String newpwd=userForm.getPwd();
		String pwd=Md5Security.addMd5(userForm.getPwd());
		if("".equals(newpwd)||newpwd==null){//����Ϊ����ʹ��ԭ����
			pwd=userForm.getOldpwd();
		}
		String userdec=userForm.getUserDec();
		String userid=String.valueOf(userForm.getUserId());
		map.put("username",username);
		map.put("password", pwd);
		map.put("userdec", userdec);
		map.put("userid", Integer.valueOf(userid));
		int retu=this.qxglLoginService.modiUser(map);
		request.setAttribute("retuMsg", "�޸��û���Ϣ�ɹ�!");
		request.setAttribute("retuPara","0");
		return mapping.findForward("succ");
	}
	
	/**
	 * ��ѯ�û��������浽select,��Ҫ����������û�
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	/*public ActionForward getUserGroup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List rlist=null;
		String ug_id=(String)request.getSession().getAttribute("ug_id");
		Map map=new HashMap();
		if(ug_id!=null&&!("".equals(ug_id))){
			map.put("ug_id",Integer.valueOf(ug_id));
			try {
				rlist=this.qxglLoginService.queryForList("queryUgByUserId", map);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}else{
			try {
				rlist=this.qxglLoginService.queryForList("queryAllUserGroup",null);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		request.setAttribute("uglist",rlist);
		return mapping.findForward("adduser");
	}
	//�˳���¼
	public ActionForward logOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().invalidate();
		return mapping.findForward("logout");
	}	
	
	//�ϴ��ļ����м�ת�����ã���ʵ������
	public ActionForward uploadFile(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return mapping.findForward("uploadfile");
	}

	public UserService getQxglLoginService() {
		return qxglLoginService;
	}

	public void setQxglLoginService(UserService qxglLoginService) {
		this.qxglLoginService = qxglLoginService;
	}

}
*/
	
	package com.kanmenzhu.system.security.action;

	import java.util.HashMap;
	import java.util.List; 
	import java.util.Map;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.apache.struts.action.ActionForm;
	import org.apache.struts.action.ActionForward;
	import org.apache.struts.action.ActionMapping;

	import com.wondersgroup.framework.base.BaseAction;
	import com.wondersgroup.qxgl.util.Md5Security;
	import com.wondersgroup.qxgl.service.UserService;
	import com.wondersgroup.qxgl.struts.form.UserForm;
	import com.wondersgroup.qxgl.struts.form.QueryInputForm;

	public class UserAction extends BaseAction {
		private String returnMsg;

		public UserService qxglLoginService;

		/**
		 * ��¼
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		public ActionForward login(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			UserForm userForm = (UserForm) form;
			Map map = new HashMap();
			String md5Password = Md5Security.addMd5(userForm.getPwd());
			map.put("loginname", userForm.getLoginName());
			map.put("password", md5Password);
			List list = this.qxglLoginService.queryPwdForUser(map);
			request.setAttribute("list", list);
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Map vmap = (Map) list.get(i);
					if (vmap.get("DELTAG").equals("0")) {// ������û�
						request.getSession().setAttribute("userId",
								vmap.get("USERID").toString());
						request.getSession().setAttribute("userName",
								(String)vmap.get("USERNAME"));
						request.getSession().setAttribute("loginName",
								(String)userForm.getLoginName());
						request.getSession().setAttribute("userDec",
								(String)vmap.get("USERDEC"));
						request.getSession().setAttribute("yljgdm",
							(String)vmap.get("YLJGDM"));
						return mapping.findForward("loginSucc");
					} else {
						returnMsg = "����:�û����Ѿ���ɾ��!";
						request.setAttribute("message", returnMsg);
						return mapping.findForward("loginFail");
					}
				}
			} else {// δ�ҵ�
				returnMsg = "����:�û�����ڻ��������!";
				request.setAttribute("message", returnMsg);
				return mapping.findForward("loginFail");
			}
			return null;

		}

		/**
		 * ������û�
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		public ActionForward newuser(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			UserForm userForm = (UserForm) form;
			Map map = new HashMap();
			String md5Password = Md5Security.addMd5(userForm.getPwd());
			map.put("loginname", userForm.getLoginName());
			map.put("password", md5Password);
			map.put("userdec", userForm.getUserDec());
			map.put("username", userForm.getUserName());
			List list = this.qxglLoginService.queryUser(map);// ��ѯ���û����Ƿ�ע��
			if (list.size() > 0) {
				request.setAttribute("retuMsg", "�û����Ѵ��ڣ���ѡ�������û�ע��!");
				request.setAttribute("retuPage", "qxgl/adduser.jsp");
				request.setAttribute("retuPara", "2");
				return mapping.findForward("fail");
			} else {// �������û�
				Integer resu=this.qxglLoginService.creatUser(map);
				if(resu.intValue()>0){
					request.setAttribute("retuMsg", "������û��ɹ�!");
					request.setAttribute("retuPara", "0");
					return mapping.findForward("succ");
				}else{
					request.setAttribute("retuMsg", "������û�ʧ��!");
					request.setAttribute("retuPara", "1");
					return mapping.findForward("fail");
				}
			}
		}

		/**
		 * ��ѯ������û�
		 * �û�����ҳ����
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */

		public ActionForward queryUserByCon(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			QueryInputForm queryInputForm=(QueryInputForm)form;
			Map map=new HashMap();
			List list;
			String qState=null;
			String qUser=queryInputForm.getInputText();
			if(queryInputForm.getState()!=null)
				qState=queryInputForm.getState();
			if("deleted".equals(qState))
				qState="1";
			else
				qState="0";
			if(qUser==null||"".equals(qUser.trim())){
				map.put("deltag", qState);
				list = this.qxglLoginService.queryUserBydelTag(map);
			}else{
				map.put("deltag", qState);
				map.put("loginname", qUser);
				list=this.qxglLoginService.queryUserByCon(map);
			}
			//queryInputForm.setInputText(qUser);
			request.setAttribute("userlist", list);
			return mapping.findForward("usermanager");
		}


		//���û�����/ȡ��ɾ����
		public ActionForward markUserDeltag(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			Map map=new HashMap();
			Integer userid=Integer.valueOf( request.getParameter("userid"));
			map.put("userid",userid);
			map.put("deltag", request.getParameter("dt"));
			this.qxglLoginService.markUserDeltag(map);
			map.put("deltag", "0");
			List list=this.qxglLoginService.queryUserBydelTag(map);
			request.setAttribute("userlist", list);
			return mapping.findForward("usermanager");
		}
		/**
		 * ����ɾ���û�
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		public ActionForward delUserByUserid(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			try{
				Integer userid=(Integer)Integer.valueOf((request.getParameter("uid").toString()));
				int retu2=this.qxglLoginService.delQxByUserid(userid);//ɾ������û��й�����Ȩ����Ϣ��
				int retu1=this.qxglLoginService.delUserByUserid(userid);//ɾ���û�
				request.setAttribute("retuMsg", "ɾ��ɹ�!");
			}catch(Exception e){
				System.out.println(e.getMessage());
				request.setAttribute("retuMsg", "����ɾ���û�ʧ��!");
			}
			request.setAttribute("retuPara", "2");
			request.setAttribute("retuPage", "qxglQueryUR.do?method=queryUserByCon");
			return mapping.findForward("succ");
			
		}
		//�޸�����
		public ActionForward modiPwd(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			UserForm userForm = (UserForm) form;
			Map map=new HashMap();
			String loginname=(String)request.getSession().getAttribute("loginName");
			String userid=(String)request.getSession().getAttribute("userId");
			map.put("loginname", loginname);
			try{
				List list=this.qxglLoginService.queryUser(map);
				Map vmap = (Map) list.get(0);
				String epwd=Md5Security.addMd5(userForm.getOldpwd());
				String newpwd=Md5Security.addMd5(userForm.getPwd());
				if("true".equals(request.getParameter("modi"))){//�޸�����
					if(vmap.get("PWD").equals(epwd)){//��������ͬ
						map.put("password", newpwd);
						map.put("userid", Integer.valueOf(userid));
						int retu=this.qxglLoginService.modiPwd(map);
						request.setAttribute("retuMsg", "�޸�����ɹ�����������Ч!");
						request.setAttribute("retuPara", "1");
						return mapping.findForward("succ");
					}else{//�������
						request.setAttribute("retuMsg", "����������޸�ʧ��!");
						request.setAttribute("retuPara", "2");
						request.setAttribute("retuPage", "qxglOpera.do?method=modiPwd");
						return mapping.findForward("succ");
					}
				}else{//��ѯ�û���Ϣ 
					request.setAttribute("uname", vmap.get("USERNAME").toString());
					request.setAttribute("lname", vmap.get("LOGINNAME").toString());
					return mapping.findForward("modipwd");
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
				request.setAttribute("retuMsg", "�ڲ��������,�޸�ʧ��!");
				request.setAttribute("retuPara", "2");
				request.setAttribute("retuPage", "qxglOpera.do?method=modiPwd");
				return mapping.findForward("succ");
			}
		}
		//ͨ���û�ID��ָ���û���Ϣ
		public ActionForward queryUserById(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.setCharacterEncoding("utf-8");
			String uid=(String)request.getParameter("uid");
			Integer userid=(Integer)Integer.valueOf(uid);
			List list=this.qxglLoginService.queryUserById(userid);
			
			UserForm uinfo=(UserForm)form;
			Map vmap=(Map)list.get(0);
			uinfo.setUserId(((Integer)vmap.get("USERID")).intValue());
			uinfo.setUserDec(vmap.get("USERDEC").toString());
			uinfo.setUserName(vmap.get("USERNAME").toString());
			uinfo.setLoginName(vmap.get("LOGINNAME").toString());
			uinfo.setOldpwd(vmap.get("PWD").toString());
			request.setAttribute("uinfo", uinfo);
			return mapping.findForward("modiuser");
		}
		//�޸��û���Ϣ
		public ActionForward modiUser(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			UserForm userForm=(UserForm)form;
			Map map=new HashMap();
			String username=userForm.getUserName();
			String newpwd=userForm.getPwd();
			String pwd=Md5Security.addMd5(userForm.getPwd());
			if("".equals(newpwd)||newpwd==null){//����Ϊ����ʹ��ԭ����
				pwd=userForm.getOldpwd();
			}
			String userdec=userForm.getUserDec();
			String userid=String.valueOf(userForm.getUserId());
			map.put("username",username);
			map.put("password", pwd);
			map.put("userdec", userdec);
			map.put("userid", Integer.valueOf(userid));
			int retu=this.qxglLoginService.modiUser(map);
			request.setAttribute("retuMsg", "�޸��û���Ϣ�ɹ�!");
			request.setAttribute("retuPara","0");
			return mapping.findForward("succ");
			
			
			
		}
		//�˳���¼
		public ActionForward logOut(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			request.getSession().invalidate();
			return mapping.findForward("logout");
		}	
		
		//�ϴ��ļ����м�ת�����ã���ʵ������
		public ActionForward uploadFile(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			return mapping.findForward("uploadfile");
		}

		public UserService getQxglLoginService() {
			return qxglLoginService;
		}

		public void setQxglLoginService(UserService qxglLoginService) {
			this.qxglLoginService = qxglLoginService;
		}

	}


