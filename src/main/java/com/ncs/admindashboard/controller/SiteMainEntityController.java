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

import com.ncs.admindashboard.entity.SiteEntity;
import com.ncs.admindashboard.entity.SiteMainEntity;
import com.ncs.admindashboard.service.SiteEntityService;
import com.ncs.admindashboard.service.SiteMainEntityService;

@RestController
@RequestMapping("/sitemain")
public class SiteMainEntityController
{
	@Autowired
	SiteMainEntityService service;
	
	@PostMapping(value = "/create", produces = "application/json")
	public @ResponseBody SiteMainEntity siteMainEntityCreate(@RequestBody SiteMainEntity siteEntity,@RequestParam("custid") long custid,@RequestParam("clientid") long clientid) throws Exception {
		System.out.println("calli");
		System.out.println(siteEntity.toString());
		SiteMainEntity siteEntityResponse = service.siteMainEntityCreate(siteEntity,custid,clientid);
		return siteEntityResponse;
		

	}
	@GetMapping(value = "/getsiteentity")
	public @ResponseBody List<SiteMainEntity> getSiteEntity(@RequestParam("custid") long custid,@RequestParam("clientid") long clientid)
	{
		List<SiteMainEntity> getsiteEntityResponse = service.getSiteEntity(custid,clientid);
		return getsiteEntityResponse;
		
	}
	
	@GetMapping(value = "/getsinglesiteentity")
	public @ResponseBody SiteMainEntity getSingleSiteEntity(@RequestParam("siteid") long siteid)
	{
		SiteMainEntity getsiteEntityResponse = service.getSingleSiteEntity(siteid);
		return getsiteEntityResponse;
		
	}


	@PutMapping(value = "/update", produces = "application/json")
	public @ResponseBody SiteMainEntity siteMainEntityUpdate(@RequestBody SiteMainEntity siteEntity,@RequestParam("siteid") long siteid) throws Exception {
		System.out.println("calli");
		System.out.println(siteEntity.toString());
		SiteMainEntity siteEntityResponse = service.siteMainEntityUpdate(siteEntity,siteid);
		return siteEntityResponse;
		

	}
	
	@GetMapping(value = "/siteinfoemail",produces = "application/json")
	public @ResponseBody String emailSiteinfromation(@RequestParam("id") long id,@RequestParam("email") String email) 
	{
		//System.out.println("the update res"+update.toString());
	 String  client=service.emailSiteinfromation(id,email);
		return client;
		

	}

}
