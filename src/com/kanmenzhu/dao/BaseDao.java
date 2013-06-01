package com.kanmenzhu.dao;

import java.util.List;

import com.kanmenzhu.bean.BaseBean;

public interface BaseDao<T extends BaseBean> {
	void save(Object o);
	void delete(Object o);
	void update(Object o);
	void saveOrUpdate(Object o);
	T get(Integer id,Class<T> clz);
	/**
	 * 根据sql查询
	 * @param hql
	 * @param startRow 开始行 -1表示无视
	 * @param endRow 结束行 -1表示无视
	 * @param params 查询条件中的参数
	 * @return
	 */
	public List<T> findByHql(String hql,int startRow,int endRow,Object... params);
	/**
	 * 获取指定表中所有数据
	 * @param startRow 开始行 -1表示无视
	 * @param endRow 结束行 -1表示无视
	 * @return
	 */
	public List<T> getAll(int startRow,int endRow);
	
}
