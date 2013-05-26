package com.kanmenzhu.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kanmenzhu.dao.BaseDao;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

	@Override
	public void save(Object o) {
		getHibernateTemplate().save(o);
		
	}

}
