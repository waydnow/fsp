package com.kanmenzhu.system.security.action;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kanmenzhu.system.security.entity.LuMenu;
import com.kanmenzhu.system.security.entity.LuRole;
import com.kanmenzhu.system.security.service.MenuService;
import com.kanmenzhu.system.security.service.PermissionService;
import com.kanmenzhu.system.security.service.RoleService;
import com.kanmenzhu.web.BaseAction;

/**
 * 权限相关的action,基本只包含角色的权限设定
 * @author ch_w 2013-6-2
 *
 */
public class PermissionAction extends BaseAction {

	private MenuService menuService;
	private PermissionService permissionService;
	private RoleService roleService;
	/**供ztree用的数组*/
	private String initMenu;
	/**角色id*/
	private Integer rid;
	/**选择的菜单id*/
	private String selectMenuId;
	
	private List<LuRole> rlist;
	
	public String set(){
		
		
		List<LuMenu> list=menuService.getPermissionByRid(1, null);
		logger.info(list.toString());
		
		return SUCC;
	}
	/**
	 * 初始展示
	 * @return
	 */
	public String init(){
		//#########################测试代码
		rid=rid==null?-1:rid;
		//####################
		rlist=roleService.getAll(-1, -1);
		List<LuMenu> allMenu=menuService.getAll(-1, -1);
		List<LuMenu> alreadySelectList=menuService.getPermissionByRid(rid, null);
		
		HashSet<Integer> alreadySelected=new HashSet<Integer>();
		if(null!=alreadySelectList){
			for(LuMenu lm:alreadySelectList){
				alreadySelected.add(lm.getId());
			}
		}
		//logger.info(getCurrentUser().toString());
		initMenu=setZtreeData(allMenu, alreadySelected);
		
		//logger.info(initMenu);
		
		return "init";
	}
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		//#########################测试代码
				rid=rid==null?1:rid;
				//####################
		if(StringUtils.isNotBlank(selectMenuId)){
			String selectIds[]=selectMenuId.split(",");
			logger.info(Arrays.toString(selectIds));
			permissionService.savePremission(rid, selectIds);
		}
		return null;
		
	}
	
	/**
	 * 初始展示
	 * @return
	 */
	public String ajaxPermission(){
		//#########################测试代码
		rid=rid==null?-1:rid;
		//####################
		List<LuMenu> allMenu=menuService.getAll(-1, -1);
		List<LuMenu> alreadySelectList=menuService.getPermissionByRid(rid, null);
		
		HashSet<Integer> alreadySelected=new HashSet<Integer>();
		if(null!=alreadySelectList){
			for(LuMenu lm:alreadySelectList){
				alreadySelected.add(lm.getId());
			}
		}
		//logger.info(getCurrentUser().toString());
		initMenu=setZtreeData(allMenu, alreadySelected);
		
		//logger.info(initMenu);
		
		return ajaxResp(initMenu, 1);
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public String getInitMenu() {
		return initMenu;
	}
	/**
	 * 封装ztree需要的简单数据
	 * @param all 所有菜单
	 * @param alreadySel 已经选择过的id
	 * @return
	 */
	private String setZtreeData(List<LuMenu> all,HashSet<Integer> alreadySel){
		StringBuilder sb=new StringBuilder("[");
		for(LuMenu lm:all){
			sb.append("{");
			sb.append("id:").append(lm.getId());
			sb.append(",pId:").append(lm.getParentId()==null?0:lm.getParentId());
			sb.append(",name:\"").append(lm.getName()).append("\"");
			if(alreadySel.contains(lm.getId())){
				sb.append(",checked:true");
			}
			sb.append("},");
		}
		sb.append("]");
		return sb.toString();
	}
	public void setSelectMenuId(String selectMenuId) {
		this.selectMenuId = selectMenuId;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public List<LuRole> getRlist() {
		return rlist;
	}
	
	
}