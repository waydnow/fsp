package com.kanmenzhu.fsp.service;

import java.util.List;

import com.kanmenzhu.fsp.entity.LuGoods;
import com.kanmenzhu.service.BaseService;

/**
 * 货物相关service
 * @author ch_w 2013-6-1
 *
 */
public interface GoodsService extends BaseService<LuGoods> {
	
	public List<LuGoods> getGoodsByTag(int deltag);

}
