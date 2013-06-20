package com.kanmenzhu.system.security.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.PermissionDao;
import com.kanmenzhu.system.security.entity.LuPermission;

public class PermissionDaoImpl extends BaseDaoImpl<LuPermission> implements PermissionDao{

	@Override
	public String getEntityName() {
		return "LuPermission";
	}

	@Override
	public void savePremission(final Integer rid, final Integer... menuIds) {
		//先清除这个角色的权限
		getHibernateTemplate().execute(new HibernateCallback<LuPermission>() {
			@Override
			public LuPermission doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "delete LuPermission lp where lp.roleId=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, rid);
				query.executeUpdate();
				return null;
			}
		});
		
		//再保存
		for(Integer menuId:menuIds){
			LuPermission lp=new LuPermission();
			lp.setMenuId(menuId);
			lp.setRoleId(rid);
			super.save(lp);
		}
		
	}
}
