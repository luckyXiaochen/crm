package com.xiaochen.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaochen.crm.mapper.BaseDictDao;
import com.xiaochen.crm.pojo.BaseDict;

@Service
//@Transactional
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictDao baseDictDao;
	public List<BaseDict> selectBaseDictByCode(String code) {
		return baseDictDao.selectBaseDictByCode(code);
	}
	
}
