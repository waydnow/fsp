package com.kanmenzhu.system.security.dao.impl;

import java.util.List;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.dao.DepartmentDao;
import com.kanmenzhu.system.security.entity.LuDepartment;
import com.kanmenzhu.system.security.entity.LuUser;

public class DepartmentDaoImpl extends BaseDaoImpl<LuDepartment> implements DepartmentDao{

	@Override
	public LuDepartment getDepartmentByUser(LuUser user) {
		String hql = "from LuDepartment lu where lu.id = ?";
		List<LuDepartment> departments = getHibernateTemplate().find(hql,user.getDeptId());
		if(departments!=null){
			if(departments.size()>1){
				logger.info("用户"+user.getName()+"绑定了"+departments.size()+"部门");
			}
			return departments.get(0); 
		}else{
			return null;
		}
	}

	@Override
	public List<LuDepartment> getAll() {
		String hql = "from LuDepartment";
		List<LuDepartment> dps = getHibernateTemplate().find(hql);
		return dps;
	}

	@Override
	public String getEntityName() {
		return "LuDepartment";
	}

}
