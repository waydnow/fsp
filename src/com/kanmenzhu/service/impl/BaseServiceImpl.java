package com.kanmenzhu.service.impl;

import com.kanmenzhu.bean.BaseBean;
import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.service.BaseService;

public  abstract class BaseServiceImpl<T extends BaseBean>  implements BaseService<T> {
	
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

	
}
