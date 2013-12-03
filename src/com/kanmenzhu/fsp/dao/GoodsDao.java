package com.kanmenzhu.fsp.dao;

import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.fsp.entity.LuGoods;

/**
 * 货物相关dao
 * @author ch_w 2013-6-1
 *
 */
public interface GoodsDao extends BaseDao<LuGoods> {

	public List<LuGoods> getGoodsByTag(int deltag);

}
