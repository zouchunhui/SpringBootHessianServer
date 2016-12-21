package com.yuanjian.hessian.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.yuanjian.hessian.demo.dao.ZBTypeDao;
import com.yuanjian.hessian.demo.service.ZBTypeService;

@Service("zbTypeServiceImpl")
public class ZBTypeServiceImpl implements ZBTypeService{

	@Autowired
	private ZBTypeDao zbTypeDao;
	
	@Override
	public String getZBTypeById(Long id) {
		return JSON.toJSONString(zbTypeDao.getZBTypeById(id));
	}

}
