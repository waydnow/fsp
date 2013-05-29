package com.kanmenzhu.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kanmenzhu.dao.BaseDao;

public abstract class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

	@Override
	public void save(Object o) {
		getHibernateTemplate().save(o);
		
	}

	@Override
	public void delete(Object o) {
		getHibernateTemplate().delete(o);
		
	}

	@Override
	public void update(Object o) {
		getHibernateTemplate().update(o);
		
	}

	@Override
	public void saveOrUpdate(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
		
	}

}
