package com.kanmenzhu.fsp.dao;

import java.util.List;

import com.kanmenzhu.dao.BaseDao;
import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.utils.pagination.PageBean;

/**
 * 货物相关dao
 * @author ch_w 2013-6-1
 *
 */
public interface GoodsDao extends BaseDao<LuGoods> {

	public List<LuGoods> getGoodsByTag(PageBean pb, int deltag);

	public List<LuGoods> getGoodsByTag(int ok);

}
