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
import com.ncs.admindashboard.service.SiteEntityService;

@RestController
@RequestMapping("/siteentity")
public class SiteEntityController 
{
	@Autowired
	SiteEntityService service;
	
	@PostMapping(value = "/create", produces = "application/json")
	public @ResponseBody SiteEntity siteEntityCreate(@RequestBody SiteEntity siteEntity) throws Exception {
		System.out.println("calli");
		System.out.println(siteEntity.toString());
		SiteEntity siteEntityResponse = service.siteEntityCreate(siteEntity);
		return siteEntityResponse;
		

	}
	@GetMapping(value = "/getsiteentity")
	public @ResponseBody List<SiteEntity> getSiteEntity()
	{
		List<SiteEntity> getsiteEntityResponse = service.getSiteEntity();
		return getsiteEntityResponse;
		
	}

}
