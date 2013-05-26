package com.kanmenzhu.system.security.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	public List queryPwdForUser(Map map)throws Exception;
	public Integer creatUser(Map map)throws Exception ;
	public List queryUserByCon(Map map)throws Exception;
	public List queryUser(Map map)throws Exception;
	public List queryUserBydelTag(Map map)throws Exception;
	public List queryUserRole(Map map)throws Exception;
	public int markUserDeltag(Map map)throws Exception;
	public int delUserByUserid(Integer userid)throws Exception;
	public int delQxByUserid(Integer userid)throws Exception;
	public int modiPwd(Map map)throws Exception;
	public List queryUserById(Integer map)throws Exception;
	public int modiUser(Map map)throws Exception;
	public List queryRoleByRolename(String map)throws Exception;
	public List queryRoleById(Integer map)throws Exception;
	public List queryRoleByCon(Map map)throws Exception;
	public List queryRoleByDeltag(String map)throws Exception;
	public int creatRole(Map map)throws Exception;
	public int markRoleDeltag(Map map)throws Exception;
	public int modiRole(Map map)throws Exception;
	public List queryRoleNotConUser(Integer  map)throws Exception;
	public List queryRoleConUser(Integer  map)throws Exception;
	public List queryUserNotConRole(Integer  map)throws Exception;
	public List queryUserConRole(Integer  map)throws Exception;
	public int adjustRoleUser(Map map)throws Exception;
	public int delQxByUR(Map map)throws Exception;
	public List queryAllMenu()throws Exception;
	public List queryAccessByRoleid(Integer map)throws Exception;
	public int delAccessByRoleid(Integer map)throws Exception;
	public int setAccessToRole(Map map)throws Exception;
	public List queryMainMenuByUserid(Integer userid)throws Exception;
	public List querySubMenuByCon(Map map)throws Exception;
	public List countSubMenuConLink(Map map)throws Exception;
	public List countMainMenuConSub(Map map)throws Exception;
	public List countMainMenu(Map map)throws Exception;
	public List queryMainMenuNameBySubid(String mnstartid)throws Exception;
	public List queryAccessByPage(Map map)throws Exception;
	
	public List queryForList(String queryStatmentId,Map map)throws Exception;
	public int delOpera(String queryStatmentId,Map map)throws Exception;
	public int insertOpera(String queryStatmentId,Map map)throws Exception;
	public int updateOpera(String queryStatmentId,Map map) throws Exception;
	
	
}
