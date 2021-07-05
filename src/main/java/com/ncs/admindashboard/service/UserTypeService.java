package com.ncs.admindashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.admindashboard.entity.UserType;
import com.ncs.admindashboard.repository.UserTypeRepository;

@Service
@Transactional
public class UserTypeService {
	@Autowired
	UserTypeRepository userRepo;

	public UserType createUserType(UserType usertypeRequest) 
	{
		UserType response = userRepo.save(usertypeRequest);
		return response;
	}

}
