package com.kanmenzhu.dao;

public interface BaseDao {
	void save(Object o);
	void delete(Object o);
	void update(Object o);
	void saveOrUpdate(Object o);
}
