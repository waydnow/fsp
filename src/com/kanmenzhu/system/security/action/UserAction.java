package com.kanmenzhu.system.security.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.entity.LuRoleUser;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.DepartmentService;
import com.kanmenzhu.system.security.service.RoleService;
import com.kanmenzhu.system.security.service.RoleUserService;
import com.kanmenzhu.system.security.service.UserService;
import com.kanmenzhu.web.BaseAction;
import com.kanmenzhu.web.RandomImageAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Logger logger=LoggerFactory.getLogger(getClass());
	
	private String verifyCode;
	
	private UserService userService;
	private DepartmentService departmentService;

	private LuUser user;
	
	private List<LuRole> roleList;
	private RoleService roleService;
	private String roleids;
	private RoleUserService ruService;
	
	private List<LuDepartment> dps;
	private LuDepartment department;
	
	public String add(){
		String msg = null;
		if (null!=user) {
			//TODO 需要添加判断是否已经存在该用户名的用户
			LuUser olduser = userService.findByLoginName(user.getLoginName());
			if (null!=olduser) {
				msg="用户名"+olduser.getLoginName()+"已经被注册！";
			}else {
				LuDepartment department = departmentService.get(user.getDeptId(), LuDepartment.class);
				if (null!=department) {
					user.setDeptId(department.getId());
					userService.save(user);
					//用户绑定角色
					String[] ids = roleids.split(",");
					for (String id : ids) {
						LuRoleUser ru = new LuRoleUser();
						ru.setRid(Integer.valueOf(id));
						ru.setUid(user.getId());
						ruService.save(ru);
					}
					logger.info("注册用户"+user.getLoginName()+",ID="+user.getId()+"绑定角色ID={"+roleids+"}");
					return welcome();
				}else {
					msg = "没有选择正确的单位信息";
				}
			}
		}else {
			msg = "用户注册失败！"; 
		}
		if (null!=msg) {
			clearMessages();
			addActionMessage(msg);
		}
		return "regist";
	}
	
	public String login(){
		String msg=null;
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(user!=null){
			if(RandomImageAction.checkVerifyCode(session, verifyCode)){
				LuUser dbUser=userService.findByLoginName(user.getLoginName());
				if(dbUser!=null&&dbUser.pwdEquals(user)){
					ActionContext.getContext().getSession().put(BaseAction.SESSION_USER_INFO,dbUser);
					msg="登录成功!";
					return SUCCESS;
				}else{
					msg="用户名错误或密码错误!";
				}
				
			}else{
				msg="验证码错误!";
			}
		}
		if(null!=msg){
			verifyCode="";
			clearMessages();
			addActionMessage(msg);
		}
		return ERROR;
	}
	
	public String welcome(){
		logger.info("####进入登录页面#####");
		return "login";
	}
	
	public String regist(){
		dps = departmentService.getAll();
		roleList = roleService.getAll(-1, -1);
		return "regist";
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public LuUser getUser() {
		return user;
	}

	public void setUser(LuUser user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public List<LuDepartment> getDps() {
		return dps;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setDps(List<LuDepartment> dps) {
		this.dps = dps;
	}

	public LuDepartment getDepartment() {
		return department;
	}

	public void setDepartment(LuDepartment department) {
		this.department = department;
	}

	public List<LuRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<LuRole> roleList) {
		this.roleList = roleList;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String getRoleids() {
		return roleids;
	}

	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}

	public RoleUserService getRuService() {
		return ruService;
	}

	public void setRuService(RoleUserService ruService) {
		this.ruService = ruService;
	}
	
	
}
