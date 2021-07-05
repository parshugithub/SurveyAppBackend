package com.ncs.admindashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.admindashboard.entity.UserType;
import com.ncs.admindashboard.service.UserTypeService;

@RestController
@RequestMapping("userType")
public class UserTypeController 
{
	@Autowired
	UserTypeService service;
	
	@PostMapping(value = "create")
	public @ResponseBody UserType createUserType(@RequestBody UserType usertypeRequest)
	{
		UserType userTypeResult = service.createUserType(usertypeRequest);
		return userTypeResult;
		
	}

}
