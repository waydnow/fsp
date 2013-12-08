package com.kanmenzhu.service.impl;

import java.util.List;

import com.kanmenzhu.bean.BaseBean;
import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.service.BaseService;
import com.kanmenzhu.utils.pagination.PageBean;
/**
 * 基础业务类
 * @author ch_w 2013-6-1
 *
 */
public   abstract class BaseServiceImpl<T extends BaseBean>  implements BaseService<T> {
	
	protected BaseDao<T> dao;
	
	@Override
	public void save(Object o) {
		dao.save(o);
		
	}

	@Override
	public void delete(Object o) {
		dao.delete(o);
		
	}

	@Override
	public void update(Object o) {
		dao.update(o);
		
	}

	@Override
	public void saveOrUpdate(Object o) {
		dao.saveOrUpdate(o);
		
	}

	public T get(Integer id,Class<T> clz){
		return dao.get(id,clz);
	}
	
	
	public BaseDao<T> getDao() {
		return dao;
	}

	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	@Override
	public List<T> findByHql(String hql, PageBean pb, Object... params) {
		return dao.findByHql(hql, pb, params);
	}

	@Override
	public List<T> getAll(PageBean pb) {
		return dao.getAll(pb);
	}

	@Override
	public List<T> findByHql(String hql, int startRow, int endRow,
			Object... params) {
		return dao.findByHql(hql, startRow, endRow, params);
	}

	@Override
	public List<T> getAll(int startRow, int endRow) {
		return dao.getAll(startRow, endRow);
	}

	
}
