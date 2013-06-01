package com.kanmenzhu.system.security.dao.impl;

import com.kanmenzhu.dao.impl.BaseDaoImpl;
import com.kanmenzhu.system.security.entity.LuLogs;

public class LogsDaoImpl extends BaseDaoImpl<LuLogs> {

	@Override
	public String getEntityName() {
		return "LuLogs";
	}

}
