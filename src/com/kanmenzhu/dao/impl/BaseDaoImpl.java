package com.kanmenzhu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kanmenzhu.bean.BaseBean;
import com.kanmenzhu.dao.BaseDao;

public abstract class BaseDaoImpl<T extends BaseBean> extends HibernateDaoSupport implements BaseDao<T> {

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
	public List<T> findByHql(String hql,int startRow,int endRow,Object... params){
		Session session=getSession();
		Query query=session.createQuery(" from "+getEntityName()+" s order by s.id desc");
		if(startRow>0)
			query.setFirstResult(startRow);
		if(endRow>startRow)
			query.setMaxResults(endRow);
		return (List<T>)query.list();
	}
	
	public List<T> getAll(int startRow,int endRow){
		Session session=getSession();
		Query query=session.createQuery(" from "+getEntityName()+" s order by s.id desc");
		if(startRow>0)
			query.setFirstResult(startRow);
		if(endRow>startRow)
			query.setMaxResults(endRow);
		return (List<T>)query.list();
	}

	/**
	 * 获取实体类名
	 * @return
	 */
	public abstract String getEntityName();
	
	@Override
	public void saveOrUpdate(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
		
	}
	
	public T get(Integer id,Class<T> clz){
		return getHibernateTemplate().get(clz, id);
	}

}
