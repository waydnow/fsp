package com.kanmenzhu.system.security.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kanmenzhu.system.security.entity.LuMenu;
import com.kanmenzhu.system.security.service.MenuService;
import com.kanmenzhu.web.BaseAction;

public class MenuAction extends BaseAction {
	
	private MenuService menuService;
	
	private List<LuMenu> menuList;
	private List<LuMenu> submenuList;
	private LuMenu menu;

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
		menuList = menuService.getPermissionByUid(getCurrentUser().getId(), null);
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
	
	
}
