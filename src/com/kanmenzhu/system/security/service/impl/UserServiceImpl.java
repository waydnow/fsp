package com.kanmenzhu.system.security.service.impl;

import java.util.List;
import java.util.Map;

import com.wondersgroup.qxgl.dao.QxglDao;
import com.wondersgroup.qxgl.service.UserService;

public class UserServiceImpl implements UserService{
	public QxglDao qxglLoginDao;

	public QxglDao getQxglLoginDao() {
		return qxglLoginDao;
	}
	/**
	 * ��ݿ����...
	 */
	public List queryPwdForUser(Map map)throws Exception {
		return this.qxglLoginDao.queryPwdForUser(map);
	
	}
	public Integer creatUser(Map map)throws Exception{
		return this.qxglLoginDao.creatUser(map);
	}
	
	public void setQxglLoginDao(QxglDao qxglLoginDao) {
		this.qxglLoginDao = qxglLoginDao;
	}
	public List queryUserByCon(Map map)throws Exception{
		return this.qxglLoginDao.queryUserByCon(map);
	}

	public List queryUser(Map map)throws Exception{
		return this.qxglLoginDao.queryUser(map);
	}
	public List queryUserBydelTag(Map map)throws Exception{
		return this.qxglLoginDao.queryUserBydelTag(map);
	}
	public List queryUserRole(Map map)throws Exception{
		return this.qxglLoginDao.queryUserRole(map);
	}
	public int markUserDeltag(Map map)throws Exception{
		return this.qxglLoginDao.markUserDeltag(map);
	}
	public int delUserByUserid(Integer userid)throws Exception{
		return this.qxglLoginDao.delUserByUserid(userid);
	}
	public int delQxByUserid(Integer userid)throws Exception{
		return this.qxglLoginDao.delQxByUserid(userid);
	}
	public int modiPwd(Map map)throws Exception{
		return this.qxglLoginDao.modiPwd(map);
	}
	public List queryUserById(Integer map)throws Exception{
		return this.qxglLoginDao.queryUserById(map);
	}
	public int modiUser(Map map)throws Exception{
		return this.qxglLoginDao.modiUser(map);
	}
	public List queryRoleByRolename(String map)throws Exception{
		return this.qxglLoginDao.queryRoleByRolename(map);
	}
	public List queryRoleById(Integer map)throws Exception{
		return this.qxglLoginDao.queryRoleById(map);
	}
	public List queryRoleByCon(Map map)throws Exception{
		return this.qxglLoginDao.queryRoleByCon(map);
	}
	public List queryRoleByDeltag(String map)throws Exception{
		return this.qxglLoginDao.queryRoleByDeltag(map);
	}
	public int creatRole(Map map)throws Exception{
		return this.qxglLoginDao.creatRole(map);
	}
	public int markRoleDeltag(Map map)throws Exception{
		return this.qxglLoginDao.markRoleDeltag(map);
	}
	public int modiRole(Map map)throws Exception{
		return this.qxglLoginDao.modiRole(map);
	}
	public List queryRoleNotConUser(Integer  map)throws Exception{
		return this.qxglLoginDao.queryRoleNotConUser(map);
	}
	public List queryRoleConUser(Integer  map)throws Exception{
		return this.qxglLoginDao.queryRoleConUser(map);
	}
	public List queryUserNotConRole(Integer  map)throws Exception{
		return this.qxglLoginDao.queryUserNotConRole(map);
	}
	public List queryUserConRole(Integer  map)throws Exception{
		return this.qxglLoginDao.queryUserConRole(map);
	}
	public int adjustRoleUser(Map map)throws Exception{
		return this.qxglLoginDao.adjustRoleUser(map);
	}
	public int delQxByUR(Map map)throws Exception{
		return this.qxglLoginDao.delQxByUR(map);
	}
	public List queryAllMenu()throws Exception{
		return this.qxglLoginDao.queryAllMenu();
		
	}
	public List queryAccessByRoleid(Integer map)throws Exception{
		return this.qxglLoginDao.queryAccessByRoleid(map);
	}
	public int delAccessByRoleid(Integer map)throws Exception{
		return this.qxglLoginDao.delAccessByRoleid(map);
	}
	public int setAccessToRole(Map map)throws Exception{
		return this.qxglLoginDao.setAccessToRole(map);
	}
	public List queryMainMenuByUserid(Integer userid)throws Exception{
		return this.qxglLoginDao.queryMainMenuByUserid(userid);
	}
	public List querySubMenuByCon(Map map)throws Exception{
		return this.qxglLoginDao.querySubMenuByCon(map);
	}
	public List countSubMenuConLink(Map map)throws Exception{
	 return this.qxglLoginDao.countSubMenuConLink(map);
	}
	public List countMainMenuConSub(Map map)throws Exception{
		return this.qxglLoginDao.countMainMenuConSub(map);
	}
	public List countMainMenu(Map map)throws Exception{
		return this.qxglLoginDao.countMainMenu(map);
	}
	public List queryMainMenuNameBySubid(String mnstartid)throws Exception{
		return this.qxglLoginDao.queryMainMenuNameBySubid(mnstartid); 
	}
	public List queryAccessByPage(Map map)throws Exception{
		return this.qxglLoginDao.queryAccessByPage(map);
	}
	public int delOpera(String queryStatmentId, Map map) throws Exception {
		// TODO Auto-generated method stub
		return this.qxglLoginDao.delOpera(queryStatmentId, map);
	}
	public int insertOpera(String queryStatmentId, Map map) throws Exception {
		// TODO Auto-generated method stub
		return this.qxglLoginDao.insertOpera(queryStatmentId, map);
	}
	public List queryForList(String queryStatmentId, Map map) throws Exception {
		// TODO Auto-generated method stub
		return this.qxglLoginDao.queryForList(queryStatmentId, map);
	}
	public int updateOpera(String queryStatmentId, Map map) throws Exception {
		// TODO Auto-generated method stub
		return this.qxglLoginDao.updateOpera(queryStatmentId, map);
	}
}
