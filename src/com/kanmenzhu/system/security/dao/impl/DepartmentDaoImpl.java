package com.kanmenzhu.system.security.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.DepartmentDao;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuUser;
import com.kanmenzhu.utils.pagination.PageBean;

public class DepartmentDaoImpl extends BaseDaoImpl<LuDepartment> implements DepartmentDao{

	@Override
	public LuDepartment getDepartmentByUser(LuUser user) {
		String hql = "from LuDepartment lu where lu.id = ? and lu.status=0";
		List<LuDepartment> departments = getHibernateTemplate().find(hql,user.getDeptId());
		if(departments!=null){
			if(departments.size()>=1){
				logger.info("用户"+user.getName()+"绑定了"+departments.size()+"部门");
				return departments.get(0); 
			}
		}
		return null;
	}
	
	@Override
	public List<LuDepartment> getByType(String type) {
		String hql = "from LuDepartment lu where lu.type = ? and lu.status=0";
		List<LuDepartment> departments = getHibernateTemplate().find(hql,type);
		if(departments!=null){
			return departments;
		}
		return null;
	}

	@Override
	public List<LuDepartment> getByName(PageBean pb, String name) {
		String hql=" from "+getEntityName()+" s where s.name like ? and s.status=0 order by s.id desc";
		List<LuDepartment> dplist = findByHql(hql, pb, "%"+name+"%");
		return dplist;
	}
	
	@Override
	public String getEntityName() {
		return "LuDepartment";
	}

	@Override
	public List<LuDepartment> getSupperBySchool(int id) {
		String hql=" from "+getEntityName()+" s where s.openDepts like '%"+id+",%' or s.openDepts like '%,"+id+",%' or s.openDepts like '%,"+id+"' or s.openDepts = '"+id+"' and s.status=0 order by s.id desc";
		List<LuDepartment> dplist = new ArrayList<LuDepartment>();
		dplist = getHibernateTemplate().find(hql);
		return dplist;
	}

}
