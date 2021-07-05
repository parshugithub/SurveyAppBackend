package com.ncs.admindashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.admindashboard.entity.DoorMainEntiry;
import com.ncs.admindashboard.entity.SiteMainEntity;
import com.ncs.admindashboard.service.DoorMainEntityService;

@RestController
@RequestMapping("/door")
public class DoorMainEntityController 
{
	@Autowired
	DoorMainEntityService service;
	
	
	@PostMapping(value = "/create", produces = "application/json")
	public @ResponseBody DoorMainEntiry doorMainEntityCreate(@RequestBody DoorMainEntiry doorEntity,@RequestParam("siteid") long siteid,@RequestParam("clientid") long clientid) throws Exception {
		System.out.println("calli");
		System.out.println(doorEntity.toString());
		DoorMainEntiry doorEntityResponse = service.doorMainEntityCreate(doorEntity,siteid,clientid);
		return doorEntityResponse;
		

	}
	@GetMapping(value = "/getdoorentity")
	public @ResponseBody List<DoorMainEntiry> getDoorEntity(@RequestParam("siteid") long siteid,@RequestParam("clientid") long clientid)
	{
		List<DoorMainEntiry> getDoorEntityResponse = service.getdoorEntity(siteid,clientid);
		return getDoorEntityResponse;
		
	}
	@GetMapping(value = "/getsingledoor")
	public @ResponseBody DoorMainEntiry getsingelDoorEntity(@RequestParam("doorid") long doorid)
	{
	DoorMainEntiry getDoorEntityResponse = service.getsingelDoorEntity(doorid);
		return getDoorEntityResponse;
		
	}

	@PutMapping(value = "/update", produces = "application/json")
	public @ResponseBody DoorMainEntiry doorMainEntityUpadate(@RequestBody DoorMainEntiry doorEntity,@RequestParam("doorid") long doorid) throws Exception {
		System.out.println("calli");
		System.out.println(doorEntity.toString());
		DoorMainEntiry doorEntityResponse = service.doorMainEntityUpadate(doorEntity,doorid);
		return doorEntityResponse;
		

	}


}
