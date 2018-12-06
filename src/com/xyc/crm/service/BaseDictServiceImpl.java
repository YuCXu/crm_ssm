package com.xyc.crm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyc.crm.mapper.BaseDictMapper;
import com.xyc.crm.pojo.BaseDict;
import com.xyc.crm.service.BaseDictService;
@Service
public class BaseDictServiceImpl implements BaseDictService{
	
	//注入Mapper
	@Resource
	private BaseDictMapper baseDictMapper;
	
	@Override
	//根据类别代码查询数据
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		List<BaseDict> list = baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
		return list;
	}

}
