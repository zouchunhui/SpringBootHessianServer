package com.yuanjian.hessian.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuanjian.hessian.demo.service.ZBTypeService;

@RestController
@RequestMapping("/api/")
public class demoController {
	
	@Autowired
	ZBTypeService zbTypeService;
	
	@RequestMapping("/getDemo")
	public String getDemo(){
		return zbTypeService.getZBTypeById(16L);
	}

}
