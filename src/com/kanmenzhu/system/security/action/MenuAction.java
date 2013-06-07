package com.kanmenzhu.system.security.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.kanmenzhu.system.security.entity.LuMenu;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.system.security.service.MenuService;
import com.kanmenzhu.system.security.service.UserService;
import com.kanmenzhu.web.BaseAction;

public class MenuAction extends BaseAction {
	
	private MenuService menuService;
	private UserService userService;
	
	private List<LuMenu> menuList;
	private List<LuMenu> submenuList;
	private Map<Integer, List<LuMenu>> menuMap;
	private LuMenu menu;
	private LuUser user;

	public String regist(){
		logger.info("####添加单位####");
		return "regist";
	}
	
	public String add(){
		if (null!=menu) {
			if (StringUtils.isNotBlank(menu.getName())&&StringUtils.isNotBlank(menu.getLink())) {
				menuService.save(menu);
			}
		}
		return list();
	}
	
	public String list(){
		menuMap=new HashMap<Integer, List<LuMenu>>();
		menuList = menuService.getPermissionByUid(getCurrentUser().getId(), 0);
		for (LuMenu mu : menuList) {
			submenuList=new ArrayList<LuMenu>(5);
			submenuList = menuService.getPermissionByUid(getCurrentUser().getId(), mu.getId());
			menuMap.put(mu.getId(), submenuList);
		}
		user = getCurrentUser();
		return "list";
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public LuMenu getMenu() {
		return menu;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public void setMenu(LuMenu menu) {
		this.menu = menu;
	}

	public List<LuMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<LuMenu> menuList) {
		this.menuList = menuList;
	}

	public List<LuMenu> getSubmenuList() {
		return submenuList;
	}

	public void setSubmenuList(List<LuMenu> submenuList) {
		this.submenuList = submenuList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public LuUser getUser() {
		return user;
	}

	public void setUser(LuUser user) {
		this.user = user;
	}

	public Map<Integer, List<LuMenu>> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<Integer, List<LuMenu>> menuMap) {
		this.menuMap = menuMap;
	}
	
}
