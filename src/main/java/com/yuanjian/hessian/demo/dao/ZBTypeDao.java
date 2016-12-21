package com.yuanjian.hessian.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yuanjian.hessian.demo.bean.ZBType;



@Mapper
public interface ZBTypeDao {

	ZBType getZBTypeById(@Param("id")Long id);
}
