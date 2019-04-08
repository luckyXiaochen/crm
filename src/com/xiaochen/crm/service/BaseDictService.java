package com.xiaochen.crm.service;

import java.util.List;


import com.xiaochen.crm.pojo.BaseDict;
public interface BaseDictService {
	public List<BaseDict> selectBaseDictByCode(String code);
}
