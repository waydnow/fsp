package com.kanmenzhu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.kanmenzhu.bean.BaseBean;
import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.utils.pagination.PageBean;

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
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHql(final String hql,final int startRow,final int endRow,final Object... params){
		/*List<T> list = (List<T>)getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
			throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				for (int i = 0; i < params.length; i++) {
					query.setParameter(i, params[i]);
				}
				query.setFirstResult(startRow);
				query.setMaxResults(endRow);
				List<T> list = query.list();
				return list;
			}
		}); */
		Session session=getSession();
		//HibernateTemplate  ht=getHibernateTemplate();
		Query query=session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		if(startRow>0)
			query.setFirstResult(startRow);
		if(endRow>startRow)
			query.setMaxResults(endRow);
		List<T> rt=(List<T>)query.list();
		return rt;
	}
	@Override
	public List<T> findByHql(String hql,PageBean pb,Object... params){
		Session session=getSession();
		Query query=session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		query.setFirstResult(pb.getStartRow());
		query.setMaxResults(pb.getPageSize());
		List<T> rt=(List<T>)query.list();
		pb.setTotal(getCount(hql, params));
		//session.close();
		return rt;
	}
	private int getCount(String hql,Object... params){
		hql="select count(*) "+hql;
		Session session=getSession();
		Query query=session.createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List rt=query.list();
		if(rt!=null){
			Object o=rt.get(0);
			return ((Long)rt.get(0)).intValue();
		}
		return 0;
	}
	
	public List<T> getAll(int startRow,int endRow){
		Session session=getSession();
		Query query=session.createQuery(" from "+getEntityName()+" s order by s.id desc");
		if(startRow>0)
			query.setFirstResult(startRow);
		if(endRow>startRow)
			query.setMaxResults(endRow);
		List<T> rt=(List<T>)query.list();
		//session.close();
		return rt;
	}
	public List<T> getAll(PageBean pb){
		Session session=getSession();
		String hql=" from "+getEntityName()+" s order by s.id desc";
		Query query=session.createQuery(hql);
		if(pb.getStartRow()>0)
			query.setFirstResult(pb.getStartRow());
		query.setMaxResults(pb.getPageSize());
		List<T> rt=(List<T>)query.list();
		if(rt!=null){
			pb.setTotal(getCount(hql));
		}
		//session.close();
		return rt;
	}

	/**
	 * 根据原生SQL查询返回实体list，用于多表关联查询返回其中一个或多个实体	
	 * @param sql 原生sql
	 * @param clz 返回的实体class
	 * @return
	 */
	public List<T> relevanceSqlQuery(String sql,Class<T>... entityClzs){
		Session session=getSession();
		Query query=session.createSQLQuery(sql).addEntity(entityClzs[0]);
		/*int i=0;
		for(Class<T> clz:entityClzs){
			query.sete
		}*/
		List<T> rt=(List<T>)query.list();
		//session.close();
		return rt;
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
