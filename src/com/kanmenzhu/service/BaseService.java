package com.kanmenzhu.service;

import com.kanmenzhu.bean.BaseBean;

public interface BaseService<T extends BaseBean> {

	void save(Object o);
	void delete(Object o);
	void update(Object o);
	void saveOrUpdate(Object o);
	T  get(Integer id,Class<T> clz);
}
