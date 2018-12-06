package com.xyc.crm.service;

import java.util.List;

import com.xyc.crm.pojo.BaseDict;

public interface BaseDictService {
	/**
	 * 根据类别代码查询数据
	 * @param dictTypeCode
	 * @return
	 */
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
