package com.kanmenzhu.service.impl;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.service.BaseService;

public  abstract class BaseServiceImpl implements BaseService {
	
	protected BaseDao dao;
	
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

	public BaseDao getDao() {
		return dao;
	}

	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	
}
