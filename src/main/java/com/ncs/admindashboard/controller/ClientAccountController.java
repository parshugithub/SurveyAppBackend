package com.ncs.admindashboard.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.admindashboard.config.MQTTConfig;
import com.ncs.admindashboard.dto.ClientInforDTO;
import com.ncs.admindashboard.dto.ClientListDTO;
import com.ncs.admindashboard.dto.CustomerListDTO;
import com.ncs.admindashboard.entity.ClientLogionEntity;
import com.ncs.admindashboard.service.ClientLoginService;




//@CrossOrigin(origins = "http://213.171.211.57/ncsdoorcontrol1")
@RestController
@RequestMapping("/client")
public class ClientAccountController extends MQTTConfig {
	public static String customerName = "";

	public static Long id = 0l;
	
	@Autowired
	ClientLoginService service;
	InetAddress address;
	

	
	@PostMapping(value = "/register", produces = "application/json")
	public @ResponseBody String registerCustomer(@RequestBody ClientLogionEntity customer) throws Exception {
		System.out.println("calli");
		System.out.println(customer.toString());
		ClientLogionEntity existingUser = service.registerCustomer(customer);
		if (existingUser != null) {
			return "registration successful!!!Please check your mail to confirm the mail id";
		}

		return "registration faild!!!Please check the values";

	}

	private String timerForVarifyAccout(ClientLogionEntity existingUser) {
		try {
			System.out.println("thread");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Done";
	}

	// @CrossOrigin(origins = "http://213.171.211.57/ncsdoor")
	@GetMapping(value = "/confirm-account")
	public String confirmCustomerAccount(@RequestParam("token") String confirmationToken, Model modal) {
		String message = service.confirmCustomerAccount(confirmationToken, modal);
		modal.addAttribute(message);
		return message;
		// return ResponseEntity.ok(message);

	}

	// @CrossOrigin(origins = "http://213.171.211.57/ncsdoor")
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
	public ClientLogionEntity ClientLogin(@RequestBody ClientLogionEntity login) throws Exception {
		System.out.println("calling");
		System.out.println("the object is " + login);
		String emailid = login.getEmail();
		String pass = login.getPassword();
		// String userName =login.getCreateuser().getUserName();

		System.out.println(emailid + " " + pass + "  ");
		System.out.println("calling");
		ClientLogionEntity respose = service.ClientLogin(emailid, pass);
		//LoginEvenLogsTable events = new LoginEvenLogsTable();
		if (respose != null) {
			LocalDateTime myDateObj = LocalDateTime.now();  
			 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
			 String formattedDate = myDateObj.format(myFormatObj); 
//			events.setUsername(respose.getFirstname()+" "+respose.getLastname());
//			events.setEvent("Login");
//			events.setStatus("Successful");
//			events.setDescription(respose.getFirstname()+" "+respose.getLastname()+"  logged in");
//			events.setUpdatedDate(formattedDate);
//			events.setSiteName(" ");
//			loginRepo.save(events);
			// String customerEmailId = loginUser.getEmailId();

			// loginUser.getId();
			// System.out.println(loginUser.getId());

			// customerName=customerName+ customerEmailId;
			return respose;
		}

		throw new Exception("Check the Credentails or varify the account");

	}

	
	@PutMapping(value = "/clientupdate" ,produces = "application/json")
	public @ResponseBody ClientLogionEntity updateClient(@RequestBody ClientLogionEntity requestEntity)
	{
		System.out.println("the request "+requestEntity.toString());
		ClientLogionEntity clientResponse = service.updateClient(requestEntity);
		
		return clientResponse;
		
	}
	@Override
	protected void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void config() {
		// TODO Auto-generated method stub
		
	}

	
	@PostMapping(value = "/customerregister", produces = "application/json")
	public @ResponseBody String registerCust(@RequestBody ClientLogionEntity customer,@RequestParam("parentId") long parentId) throws Exception {
		System.out.println("calli");
		System.out.println(customer.toString());
		ClientLogionEntity existingUser = service.registerCust(customer,parentId);
		if (existingUser != null) {
			return "registration successful";
		}

		return "registration faild!!!Please check the values";

	}
	
//	// @CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(value = "/userlogin", method = { RequestMethod.GET,
//			RequestMethod.POST }, produces = "application/json")
//	public CreateUserModal userLogin(@RequestBody CreateUserModal login) throws Exception {
//		System.out.println("calling");
//		System.out.println("the object is " + login);
//		String emailid = login.getUserName();
//		// String pass = login.getPassword();
//		// String userName =login.getCreateuser().getUserName();
//
//		System.out.println(emailid);
//		System.out.println("calling");
//		CreateUserModal respose = service.userLogin(emailid);
//		LoginEvenLogsTable events = new LoginEvenLogsTable();
//		if (respose != null) {
//			LocalDateTime myDateObj = LocalDateTime.now();  
//			 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
//			 String formattedDate = myDateObj.format(myFormatObj); 
//			events.setUsername(respose.getUserName());
//			events.setEvent("Login");
//			events.setStatus("Successful");
//			events.setDescription(respose.getUserName()+"  logged in");
//			events.setUpdatedDate(formattedDate);
//			events.setSiteName(" ");
//			loginRepo.save(events);
//			// String customerEmailId = loginUser.getEmailId();
//
//			// loginUser.getId();
//			// System.out.println(loginUser.getId());
//
//			// customerName=customerName+ customerEmailId;
//			return respose;
//		}
//
//		throw new Exception("Check the Credentails or varify the account");
//
//	}
//
	
	
	
	@GetMapping(value = "/getsingleclient")
	public @ResponseBody ClientLogionEntity getSingleClient(@RequestParam("id") long id) 
	{
	 ClientLogionEntity  client=service.getSingleClient(id);
		return client;
		

	}
	@GetMapping(value = "/getsinglecustomer")
	public @ResponseBody ClientLogionEntity getSingleCustomer(@RequestParam("id") long id) 
	{
	 ClientLogionEntity  client=service.getSingleCustomer(id);
		return client;
		

	}
	@PutMapping(value = "/updatecustomer",produces = "application/json")
	public @ResponseBody ClientLogionEntity updateCustomer(@RequestParam("id") long id, @RequestBody ClientLogionEntity update) 
	{
		System.out.println("the update res"+update.toString());
	 ClientLogionEntity  client=service.updateCustomer(id,update);
		return client;
		

	}
	
	@GetMapping(value = "/customeremail",produces = "application/json")
	public @ResponseBody String emailCustomerinfromation(@RequestParam("id") long id,@RequestParam("email") String email) 
	{
		//System.out.println("the update res"+update.toString());
	 String  client=service.emailCustomerinfromation(id,email);
		return client;
		

	}
	/// @CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/getClients")
	public @ResponseBody long getNumberOfClients(@RequestParam("id") long id) 
	{
		long numberOFclints =service.getNumberOfClients(id);
		return numberOFclints;
		

	}
	
	@GetMapping(value = "/getSites")
	public @ResponseBody long getNumberOfSites(@RequestParam("id") long id) 
	{
		long numberOFSites =service.getNumberOfSites(id);
		return numberOFSites;
		

	}
	
	@GetMapping(value = "/getallClitesforCustomerCreate")
	public @ResponseBody List<ClientLogionEntity> getallClitesforCustomerCreate(@RequestParam("id") long id) 
	{
		List<ClientLogionEntity> numberOFSites =service.getallClitesforCustomerCreate(id);
		return numberOFSites;
		

	}
//
	@GetMapping(value = "/getCustomer")
	public @ResponseBody long getNumberOfCustomer(@RequestParam("id") long id) 
	{
		long numberOFcustomers =service.getNumberOfCustomer(id);
		return numberOFcustomers;
		

	}
	@GetMapping(value = "/getdoor")
	public @ResponseBody long getNumberOfdoor(@RequestParam("id") long id) 
	{
		long numberOFcustomers =service.getNumberOfdoor(id);
		return numberOFcustomers;
		

	}
	
	
	@GetMapping(value = "/getallclientinfo")
	public  List<ClientInforDTO> getAll(@RequestParam("id") long id) 
	{
		List<ClientInforDTO> ClientInforDTO =service.getAll(id);
		return ClientInforDTO;
		

	}
	
	
	@GetMapping(value = "/getallclient")
	public @ResponseBody List<ClientListDTO> getAllClients(@RequestParam("id") long id) 
	{
		List<ClientListDTO> ClientInforDTO =service.getAllClients(id);
		return ClientInforDTO;
		

	}
	
	@GetMapping(value = "/getallcustomer")
	public @ResponseBody List<CustomerListDTO> getAllCustomer(@RequestParam("id") long id) 
	{
		List<CustomerListDTO> ClientInforDTO =service.getAllCustomer(id);
		return ClientInforDTO;
		

	}
//
//	// @CrossOrigin(origins = "http://localhost:4200")
//	@PutMapping(value = "/upadatsettings")
//	public @ResponseBody Customer updateCustomer(@RequestParam("id") long id, @RequestBody Customer customerUpdate) {
//		return service.updateCustomer(customerUpdate, id);
//
//	}
//
//	// @CrossOrigin(origins = "http://localhost:4200")
//	@PutMapping(value = "/changepassword")
//	public @ResponseBody Customer changePassword(@RequestParam("id") long id, @RequestBody Customer changePassObj) {
//		return service.changePassword(id, changePassObj);
//
//	}
//
//	// @CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(value = "/userloginwithforgetpassword", method = { RequestMethod.GET,
//			RequestMethod.POST }, produces = "application/json")
//	public @ResponseBody CreateUserModal userLoginWithForgetpassword(@RequestParam("username") String username) throws Exception {
//		System.out.println("calling");
//		System.out.println("the object is " + username);
//		String emailid = username;
//		// String pass = login.getPassword();
//		// String userName =login.getCreateuser().getUserName();
//
//		System.out.println(emailid);
//		System.out.println("calling");
//		CreateUserModal respose = service.userLoginWithForgetpassword(username);
//		if (respose != null) {
//			// String customerEmailId = loginUser.getEmailId();
//
//			// loginUser.getId();
//			// System.out.println(loginUser.getId());
//
//			// customerName=customerName+ customerEmailId;
//			return respose;
//		}
//
//		throw new Exception("Check the Credentails or varify the account");
//
//	}
//
//	// @CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(value = "/userloginwithsubmitcode", method = { RequestMethod.GET,
//			RequestMethod.POST }, produces = "application/json")
//	public @ResponseBody int userLoginSubmitCode(@RequestParam("code") long code) throws Exception {
//		System.out.println("calling");
//		System.out.println("the object is " + code);
//		// String emailid = login.getUserName();
//		// String pass = login.getPassword();
//		// String userName =login.getCreateuser().getUserName();
//
//		// System.out.println(emailid);
//		System.out.println("calling");
//		int respose = service.userLoginSubmitCode(code);
//		if (respose != 0) {
//			// String customerEmailId = loginUser.getEmailId();
//
//			// loginUser.getId();
//			// System.out.println(loginUser.getId());
//
//			// customerName=customerName+ customerEmailId;
//			return respose;
//		}
//
//		throw new Exception("Check the Credentails or varify the account");
//
//	}
//
//	@GetMapping(value = "/checkmqttIPaddress")
//	public @ResponseBody boolean checkIpAddress() {
//		List<String> pendingStaff = new ArrayList<>();
//		List<String> pendingPerson = new ArrayList<>();
//		List<String> pendingDoor = new ArrayList<>();
//		List<String> pendingDoorGroup = new ArrayList<>();
//		List<String> pendingSite = new ArrayList<>();
//		List<String> pendingTradeCode = new ArrayList<>();
//		String taskStatus = "pending";
//		boolean reachable = false;
//		try {
//			address = InetAddress.getByName(this.clientIp);
//			reachable = address.isReachable(1000);
//			System.out.println("the ip address is reachable " + reachable);
//			if (reachable == true) {
//				List<BackTasksModal> pendingTask = backtaskRepo.findbyPendingstatus(taskStatus);
//				System.out.println("the pending tasks are " + pendingTask.toString());
//				for (int i = 0; i < pendingTask.size(); i++) {
//					String taskInfo = pendingTask.get(i).getTaskNo();
//					if (taskInfo.contains("Staff ID")) {
//
//						if (pendingStaff.contains(taskInfo)) {
//							System.out.println("already have");
//						} else {
//							pendingStaff.add(taskInfo);
//						}
//
//					}
//
//					if (taskInfo.contains("person ID")) 
//					{
//						//pendingPerson.add(taskInfo);
//						if (pendingPerson.contains(taskInfo)) {
//							System.out.println("already have");
//						} else {
//							pendingPerson.add(taskInfo);
//						}
//					}
//					if (taskInfo.contains("Door ID")) {
//						//pendingDoor.add(taskInfo);
//						if (pendingDoor.contains(taskInfo)) {
//							System.out.println("already have");
//						} else {
//							pendingDoor.add(taskInfo);
//						}
//
//					}
//					if (taskInfo.contains("Doorgroup ID")) {
//						//pendingDoorGroup.add(taskInfo);
//						if (pendingDoorGroup.contains(taskInfo)) {
//							System.out.println("already have");
//						} else {
//							pendingDoorGroup.add(taskInfo);
//						}
//					}
//					if (taskInfo.contains("Site ID")) {
//						System.out.println("cmg site");
//						//pendingSite.contains(taskInfo);
//						 if(pendingSite.contains(taskInfo)) {
//							System.out.println("already have");
//						} else {
//							pendingSite.add(taskInfo);
//						}
//					}
//					
//					if (taskInfo.contains("TradeCode ID")) {
//						System.out.println("cmg site");
//						//pendingSite.contains(taskInfo);
//						 if(pendingTradeCode.contains(taskInfo)) {
//							System.out.println("already have");
//						} else {
//							pendingTradeCode.add(taskInfo);
//						}
//					}
//
//				}
//
//				System.out.println("the pending staff are " + pendingStaff.toString());
//				System.out.println("the pending persons are " + pendingPerson.toString());
//				System.out.println("the pending doors are " + pendingDoor.toString());
//				System.out.println("the pending doorgroups are " + pendingDoorGroup.toString());
//				System.out.println("the pending site are " + pendingSite.toString());
//				System.out.println("the pending site are " + pendingTradeCode.toString());
//
//				for (int i = 0; i < pendingStaff.size(); i++) {
//					System.out.println("calling staff for loop");
//					String str = pendingStaff.get(i);
//					String staffid = str.replaceAll("[^0-9]", "");
//					System.out.println("the staff id is " + staffid);
//					StaffModal staffmodal = getStaffInfo(Long.parseLong(staffid));
//
//					// long staffid = embeddedstaff.get(i).getStaffid();
//					String staffName = staffmodal.getFirstname() + staffmodal.getLastname();
//
//					List<Long> schedulemodal = repo.getSchedules(Long.parseLong(staffid));
//					
//					System.out.println("the staffs are " + schedulemodal.toString());
//					String expireDate = staffmodal.getExpiraydate().toString();
//					SimpleDateFormat formatter = new SimpleDateFormat("dd-m-yyyy hh:mm:ss");
//					String exipre_date = formatter.format(staffmodal.getExpiraydate());
//					for (int j = 0; j < staffmodal.getStaffgroup().size(); j++) {
//						List<StaffGroupTags> tags = staffmodal.getStaffgroup().get(j).getTags();
//						List<TotalDoorsModal> doorlist = new ArrayList<>();
//						List<TotalDoorsModal> door = staffmodal.getStaffgroup().get(j).getDoors();
//						List<Long> taglist = new ArrayList<>();
//						//List<StaffGroupTags> tagsval = staffmodal.getStaffgroup().get(j).getTags();
//						for (int k = 0; k < tags.size(); k++) {
//							long tagListvalue = tags.get(k).getTagNumber();
//							taglist.add(tagListvalue);
//
//						}
//
//						for (int l = 0; l < door.size(); l++) {
//							TotalDoorsModal doorListvalue = doorRepo.findBydoorName(door.get(l).getDoorName());
//							doorlist.add(doorListvalue);
//
//						}
//						String staff_mqtt = staffid + "_" + staffName + "_" + exipre_date + "_" + taglist + "_"
//								+ doorlist + "_" + schedulemodal.toString();
//						System.out.println("the staff mqtt is " + staff_mqtt.toString());
//						
//						 publisher.publishMessage("staffid", staff_mqtt);
//						 
//						 subscriber.subscribeMessage("staffid");
//					}
//
////					StaffModal staffinfo =
//
//					System.out.println("the staff results is " + staffmodal);
//
//				}
//				
//				for (int i = 0; i < pendingPerson.size(); i++)
//				{
//					String str = pendingPerson.get(i);
//					String personid = str.replaceAll("[^0-9]", "");
//					System.out.println("the staff id is " + personid);
//					
//					PersonModal personRes = personrepo.findById(Long.parseLong(personid)).get();
//					
//					List<PersonTagsModal> persontags = personTags.findBypersonid(Long.parseLong(personid));
//					System.out.println("thw tags are" + persontags.toString());
//
//					List<ScheduleMainModal> schedulemodal = personRes.getSchedule();
//					List<Long> sch = new ArrayList<>();
//					for (int j = 0; j < schedulemodal.size(); j++) {
//						long schduleid = schRepo.findscheduleId(schedulemodal.get(j).getScheduleId());
//						sch.add(schduleid);
//						System.out.println("schedule is " + schduleid);
//
//					}
//
//					SimpleDateFormat formatter = new SimpleDateFormat("dd-m-yyyy hh:mm:ss");
//					String exipre_date = formatter.format(personRes.getExpiraydate());
//					String personDetails = personRes.getPersonid() + "_" + personRes.getFirstName() + " " + personRes.getLastName() + "_"
//							+ exipre_date + "_" + personRes.getTradeCode() + "_" + persontags + "_" + personRes.getDoors() + "_" + sch;
//
//					System.out.println("the mqtt response is " + personDetails);
//					
//					publisher.publishMessage("personid", personDetails);
//					subscriber.subscribeMessage("personid");
//					
//					
//					
//				}
//				
//				for (int i = 0; i < pendingSite.size(); i++) 
//				{
//					String str = pendingSite.get(i);
//					String siteid = str.replaceAll("[^0-9]", "");
//					System.out.println("the staff id is " + siteid);
//					
//					CreateSiteModal siteres = dashRepo.findById(Long.parseLong(siteid)).get();
//					
//					String mqttDate = siteres.getSiteid()+"_"+siteres.getSiteName()+"_"+siteres.getDeviceId();
//					
//					publisher.publishMessage("siteid", mqttDate);
//					subscriber.subscribeMessage("siteid");
//					
//				}
//				for (int i = 0; i < pendingDoor.size(); i++)
//				{
//					String str = pendingDoor.get(i);
//					String doorid = str.replaceAll("[^0-9]", "");
//					System.out.println("the staff id is " + doorid);
//					
//					//TotalDoorsModal result = repo.findBydoorName(doorname);
//					TotalDoorsModal doores = doorrepo.findBydoorName( Long.parseLong(doorid));
//					
//					publisher.publishMessage("doorid", Long.toString(doores.getDoorId()));
//					
//					subscriber.subscribeMessage("doorid");
//					
//				}
//				
//				for (int i = 0; i < pendingDoorGroup.size(); i++)
//				{
//					String str = pendingDoorGroup.get(i);
//					String doorGroupid = str.replaceAll("[^0-9]", "");
//					System.out.println("the staff id is " + doorGroupid);
//					
//					//TotalDoorsModal result = repo.findBydoorName(doorname);
//					DoorGroupModal doorgroupes = doorgroupRepo.findById(Long.parseLong(doorGroupid)).get();
//					//DoorGroupModal result = doorRepo.findBydoorgroupid(doorgroupid);
//					ArrayList<Long> doors = new ArrayList<>();
//					List<TotalDoorsModal> doorsRes = doorgroupes.getDoors();
//					for (int m = 0; m < doorsRes.size();m++) 
//					{
//						
//						long doorid =doorsRes.get(m).getDoorId();
//						doors.add(doorid);
//					}
//					String doorGroupMqtt = doorgroupes.getDoorgroupid()+"_"+doors;
//					publisher.publishMessage("doorgroupid",doorGroupMqtt);
//					
//					subscriber.subscribeMessage("doorgroupid");
//					
//				}
//				
//				for (int i = 0; i < pendingTradeCode.size(); i++)
//				{
//					String str = pendingTradeCode.get(i);
//					String tradecodeid = str.replaceAll("[^0-9]", "");
//					System.out.println("the staff id is " + tradecodeid);
//					
//					//TotalDoorsModal result = repo.findBydoorName(doorname);
//					TradeCodeWithDoorModal tradecodepes = tradecoderepo.findById(Long.parseLong(tradecodeid)).get();
//					String res = tradecoderepo.getDoorTrade(tradecodepes.getScheduleno());
//					//DoorGroupModal result = doorRepo.findBydoorgroupid(doorgroupid);
//					ArrayList<Long> doors = new ArrayList<>();
//					long doorsRes = tradecodepes.getDoorNumber();
////					for (int m = 0; m < doorsRes.size();m++) 
////					{
////						
////						long doorid =doorsRes.get(m).getDoorId();
////						doors.add(doorid);
////					}
//					//String doorGroupMqtt = doorgroupes.getDoorgroupid()+"_"+doors;
//					publisher.publishMessage("door",res);
//					
//					subscriber.subscribeMessage("door");
//					
//				}
//
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return reachable;
//
//	}
//
//	private StaffModal getStaffInfo(long staffid) {
//		StaffModal staffmodal = staffService.findStaff(staffid);
//		return staffmodal;
//	}
//
//	@Override
//	protected void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	protected void config() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@RequestMapping(value = "/userlogout", method = { RequestMethod.GET,
//			RequestMethod.POST }, produces = "application/json")
//	public CreateUserModal userLogout(@RequestBody CreateUserModal logout) throws Exception {
//		System.out.println("calling");
//		System.out.println("the object is " + logout);
//		String emailid = logout.getUserName();
//		// String pass = login.getPassword();
//		// String userName =login.getCreateuser().getUserName();
//
//		System.out.println(emailid);
//		System.out.println("calling");
//		//CreateUserModal respose = service.userLogin(emailid);
//		LoginEvenLogsTable events = new LoginEvenLogsTable();
//		if (logout != null) {
//			 LocalDateTime myDateObj = LocalDateTime.now();  
//			 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
//			 String formattedDate = myDateObj.format(myFormatObj); 
//			events.setUsername(logout.getUserName());
//			events.setEvent("Logout");
//			events.setStatus("Successful");
//			events.setDescription(logout.getUserName()+"  logged Out");
//			events.setUpdatedDate(formattedDate);
//			events.setSiteName(" ");
//			loginRepo.save(events);
//			// String customerEmailId = loginUser.getEmailId();
//
//			// loginUser.getId();
//			// System.out.println(loginUser.getId());
//
//			// customerName=customerName+ customerEmailId;
//			return logout;
//		}
//
//		throw new Exception("Check the Credentails or varify the account");
//
//	}
//	@RequestMapping(value = "/customerlogout", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
//	public Customer customerLogout(@RequestBody Customer logout) throws Exception {
//		System.out.println("calling");
//		System.out.println("the object is " + logout);
//		String emailid = logout.getEmailId();
//		String pass = logout.getPassword();
//		// String userName =login.getCreateuser().getUserName();
//
//		System.out.println(emailid + " " + pass + "  ");
//		System.out.println("calling");
//		//Customer respose = service.customerLogin(emailid, pass);
//		LoginEvenLogsTable events = new LoginEvenLogsTable();
//		if (logout != null) {
//			LocalDateTime myDateObj = LocalDateTime.now();  
//			 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");  
//			 String formattedDate = myDateObj.format(myFormatObj); 
//			events.setUsername(logout.getFirstname()+" "+logout.getLastname());
//			events.setEvent("Logout");
//			events.setStatus("Successful");
//			events.setDescription(logout.getFirstname()+" "+logout.getLastname()+"  logged out");
//			events.setUpdatedDate(formattedDate);
//			events.setSiteName(" ");
//			loginRepo.save(events);
//			// String customerEmailId = loginUser.getEmailId();
//
//			// loginUser.getId();
//			// System.out.println(loginUser.getId());
//
//			// customerName=customerName+ customerEmailId;
//			return logout;
//		}
//
//		throw new Exception("Check the Credentails or varify the account");
//
//	}
//	@RequestMapping(value = "/loginmqtt", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
//	public String loginMQTT()
//	{
//		
//		//String message = "jyotiullagaddi123@gmail.com"+"_"+"testing";
//		String message="Jyoti"+"_"+"g";
//		publisher.publishMessage("LOGIN", message);
//		subscriber.subscribeMessage("LOGIN");
//		
//		return null;
//		
//	}
//	
	
}
