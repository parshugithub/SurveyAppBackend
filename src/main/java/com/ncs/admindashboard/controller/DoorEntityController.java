package com.ncs.admindashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.admindashboard.entity.DoorEntity;
import com.ncs.admindashboard.entity.SiteEntity;
import com.ncs.admindashboard.service.DoorEntityService;

@RestController
@RequestMapping("/doorentity")
public class DoorEntityController
{
	@Autowired
	DoorEntityService service;
	
	
	@PostMapping(value = "/create", produces = "application/json")
	public @ResponseBody DoorEntity doorEntityCreate(@RequestBody DoorEntity doorEntity) throws Exception {
		System.out.println("calli");
		System.out.println(doorEntity.toString());
		DoorEntity doorEntityResponse = service.doorEntityCreate(doorEntity);
		return doorEntityResponse;
		

	}
	
	@GetMapping(value = "/getdoorentity")
	public @ResponseBody List<DoorEntity> getDoorEntity()
	{
		List<DoorEntity> getDoorEntityResponse = service.getDoorEntity();
		return getDoorEntityResponse;
		
	}
}
