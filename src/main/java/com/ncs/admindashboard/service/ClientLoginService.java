package com.ncs.admindashboard.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.ncs.admindashboard.dto.ClientInforDTO;
import com.ncs.admindashboard.dto.ClientListDTO;
import com.ncs.admindashboard.dto.CustomerListDTO;
import com.ncs.admindashboard.entity.ClientLogionEntity;
import com.ncs.admindashboard.entity.ConfirmationToken;
import com.ncs.admindashboard.entity.SiteMainEntity;
import com.ncs.admindashboard.repository.ClientLoginRepository;
import com.ncs.admindashboard.repository.ConfirmationTokenRepository;
import com.ncs.admindashboard.repository.DoorMainEntityRepository;
import com.ncs.admindashboard.repository.SiteMainEntityRepository;

@Service
@Transactional
public class ClientLoginService {

	@Autowired
	ClientLoginRepository repo;
	
	@Autowired
	DoorMainEntityRepository door;

	@Autowired
	ConfirmationTokenRepository confirmationTokenRepository;
	@Autowired
	SiteMainEntityRepository site;
	@Autowired
	private Environment env;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	SiteMainEntityRepository siterepo;

	@Autowired
	DoorMainEntityRepository doorRepo;

	Random rand = new Random();
	int newCode = rand.nextInt(10000);

	public ClientLogionEntity registerCustomer(ClientLogionEntity customer) throws Exception {

		System.out.println("Enterd");
		System.out.println(customer.toString());

		ClientLogionEntity existingUser = repo.findByemail(customer.getEmail());
		if (existingUser != null) {
			throw new Exception("The User with  " + existingUser.getEmail() + " already present");
		} else {
			// customer.setPassword(passwordEncoder.encode(customer.getPassword()));
			// bCryptPasswordEncoder.encode(customer.getPassword());
			// String encryptedPassword = passwordEncoder.encode(customer.getPassword());
			// customer.setPassword(encryptedPassword);

			customer.setUserType(2);
			customer.setParentId(1);

			repo.save(customer);

			ConfirmationToken confirmationToken = new ConfirmationToken(customer);

			confirmationTokenRepository.save(confirmationToken);
//		            
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "mail.smtp2go.com");
			props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(env.getProperty("spring.mail.username"),
							env.getProperty("spring.mail.password"));
				}
			});
			try {
				Message message = new MimeMessage(session);
				Multipart mp = new MimeMultipart("alternative");
				BodyPart textmessage = new MimeBodyPart();
				textmessage.setText("To confirm your account, please click here : "
						+ "http://localhost:8082/client/confirm-account?token=" + confirmationToken.getToken());
				BodyPart htmlmessage = new MimeBodyPart();
				htmlmessage.setContent("It is a html message.", "text/html");
				mp.addBodyPart(textmessage);
				// mp.addBodyPart(htmlmessage);
				message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customer.getEmail()));
				message.setSubject("Complete Registration!");
				message.setContent(mp);
				Transport.send(message);
				System.out.println("Done");
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			// SimpleMailMessage mailMessage = new SimpleMailMessage();
//			mailMessage.setTo(user.getEmailId());
//			mailMessage.setSubject("Complete Registration!");
//			mailMessage.setFrom("jyotiullagaddi123@gmail.com");
//			mailMessage.setText("To confirm your account, please click here : "
//			+"http://localhost:8083/confirm-account?token="+ confirmationToken.getToken());
//			
//			emailSenderService.sendEmail(mailMessage);

			return customer;

		}
	}

	public String confirmCustomerAccount(String confirmationToken, Model modal) {
		System.out.println("called this method");
		ConfirmationToken token = confirmationTokenRepository.findByToken(confirmationToken);

		if (token != null) {
			ClientLogionEntity customer = token.getCustomer();
			Calendar cal = Calendar.getInstance();
			if ((token.getExpirdDate().getTime() - cal.getTime().getTime()) <= 0) {
				String messageValue = "invalid link or link broken!!! please check the link or resend  the link";
				modal.addAttribute(messageValue);
				return " Link expired";

			}

			ClientLogionEntity customerCheckToken = repo.findByemail(token.getCustomer().getEmail());
			customerCheckToken.setEnable(true);
			repo.save(customerCheckToken);
			///// modal.addAttribute("account varified");
			// return model.addAttribute("message", "Account varified");
			return "Account varified";
		} else {
			return "invalid link or link broken!!! please check the link or resend  the link ";
		}

		// return m
	}

	public ClientLogionEntity ClientLogin(String emailid, String pass) {
		ClientLogionEntity existingCustomer = repo.findUserByEmailAndPassword(emailid, pass);
		if (existingCustomer != null && existingCustomer.isEnable()) {
			return existingCustomer;
		}

		return null;
	}

	public ClientLogionEntity updateClient(ClientLogionEntity requestEntity) {
		ClientLogionEntity responseClient = repo.findByemail(requestEntity.getEmail());

		if (responseClient != null) {
			System.out.println("the request entity is " + requestEntity.toString());
			responseClient.setConfirmPassword(responseClient.getConfirmPassword());
			responseClient.setPassword(responseClient.getPassword());
			responseClient.setCreatedDate(responseClient.getCreatedDate());
			responseClient.setEmail(responseClient.getEmail());
			responseClient.setEnable(requestEntity.isEnable());
			responseClient.setFirstName(requestEntity.getFirstName());
			responseClient.setLastName(requestEntity.getLastName());

			ClientLogionEntity response = repo.save(responseClient);

			return response;

		}

		return requestEntity;
	}

	public ClientLogionEntity registerCust(ClientLogionEntity customer, long parentId) {
		customer.setParentId(parentId);
		customer.setUserType(3);
		repo.save(customer);

		return customer;
	}

	public long getNumberOfClients(long id) {
		ClientLogionEntity result = repo.findBycustId(id);
		if (result.getUserType() == 1) {
			long allCustomers = repo.findAllclients(2);
			return allCustomers;
		}

		if (result.getUserType() == 2) {
			long allCustomers = repo.findAllclients(3);
			return allCustomers;

		}

		return 0;
	}

	public long getNumberOfSites(long id) {
		ClientLogionEntity result = repo.findBycustId(id);
		if (result.getUserType() == 1) {
			long allsites = siterepo.findAllsites();
			return allsites;
		} else {
			long allsites = siterepo.findAllsitesOfClient(id);
			return allsites;

		}

	}

	public long getNumberOfCustomer(long id) {
		ClientLogionEntity result = repo.findBycustId(id);

		if (result.getUserType() == 1) {
			long allCustomers = repo.findAllCustomer(3);
			return allCustomers;
		}

		if (result.getUserType() == 2) {
			long allCustomers = repo.findAllCustomerForClient(id);
			return allCustomers;

		}
		return id;
	}

	public long getNumberOfdoor(long id) {
		ClientLogionEntity result = repo.findBycustId(id);

		if (result.getUserType() == 1) {
			long alldoors = doorRepo.findAllDoors();
			return alldoors;
		}

		if (result.getUserType() == 2) {
			long alldoors = doorRepo.findAlldoorsForClient(id);
			return alldoors;

		}
		return 0;
	}

	public List<ClientInforDTO> getAll(long id) {
		List<ClientInforDTO> response = new ArrayList<ClientInforDTO>();

		List<ClientLogionEntity> result = repo.findall(2);
		for (int i = 0; i < result.size(); i++) {
			ClientInforDTO res = new ClientInforDTO();
			res.setClientName(result.get(i).getFirstName() + " " + result.get(i).getLastName());
			long allCustomers = repo.findAllCustomerForClient(result.get(i).getCustId());
			res.setNoOfCustomer(allCustomers);
			long allsites = siterepo.findAllsitesOfClient(result.get(i).getCustId());
			res.setNoOfsites(allsites);

			long alldoors = doorRepo.findAlldoorsForClient(result.get(i).getCustId());
			res.setNoOfDoors(alldoors);
			response.add(res);

		}

		// res.add(result);

		// TODO Auto-generated method stub
		return response;
	}

	public List<ClientListDTO> getAllClients(long id) {

		List<ClientListDTO> response = new ArrayList<ClientListDTO>();

		List<ClientLogionEntity> result = repo.findall(2);
		System.out.println("the result is " + result.toString());
		for (int i = 0; i < result.size(); i++) {
			ClientListDTO res = new ClientListDTO();
			System.out.println("the result is " + result.get(i).getCustId());
			res.setClientid(result.get(i).getCustId());
			res.setClintName(result.get(i).getFirstName() + " " + result.get(i).getLastName());
//			long allCustomers = repo.findAllCustomerForClient(result.get(i).getCustId());
//			res.setNoOfCustomer(allCustomers);
			long allsites = siterepo.findAllsitesOfClient(result.get(i).getCustId());
			res.setNumberOFSites(allsites);

			res.setEmail(result.get(i).getEmail());

			response.add(res);

		}
		System.out.println("the response is " + response.toString());

		// res.add(result);

		// TODO Auto-generated method stub
		return response;
	}

	public List<CustomerListDTO> getAllCustomer(long id) {
		List<CustomerListDTO> response = new ArrayList<CustomerListDTO>();
		ClientLogionEntity checkUser= repo.findBycustId(id);
		
		if(checkUser.getUserType()==1)
		{
			List<ClientLogionEntity> result = repo.findallcustomer(3);
			System.out.println("the result is " + result.toString());
			for (int i = 0; i < result.size(); i++) {
				
				CustomerListDTO res = new CustomerListDTO();
				System.out.println("the result is " + result.get(i).getCustId());
		    	res.setParentid(result.get(i).getParentId());
		    	System.out.println("the parent id is "+result.get(i).getParentId());
				res.setCustomerid(result.get(i).getCustId());
				res.setCustomerName(result.get(i).getFirstName());
				ClientLogionEntity checkParent = repo.findparent(result.get(i).getParentId());
				System.out.println("the parent response is "+checkParent.toString());
				res.setParentUser(checkParent.getFirstName()+" "+checkParent.getLastName());
				
				
//				long allCustomers = repo.findAllCustomerForClient(result.get(i).getCustId());
//				res.setNoOfCustomer(allCustomers);
				long allsites = siterepo.findAllsitesOfcustomert(result.get(i).getCustId());
				res.setNoOfsites(allsites);

				//res.setEmail(result.get(i).getEmail());

				response.add(res);

			}
			return response;
			
		}
		
		if(checkUser.getUserType()==2)
		{
			System.out.println("cmg here");
			List<CustomerListDTO> customerList = new ArrayList<CustomerListDTO>();
			List<ClientLogionEntity> check= repo.findallCustomersOFClient(id);
			System.out.println("client result "+check.toString());
			for (int i = 0; i < check.size(); i++) 
			{
				System.out.println("the customers are "+check.get(i).getCustId());
				CustomerListDTO customerDTO = new CustomerListDTO();
				customerDTO.setCustomerid(check.get(i).getCustId());
				customerDTO.setCustomerName(check.get(i).getFirstName()+" "+check.get(i).getLastName());
				
				long allsites = siterepo.findAllsitesOfcustomert(check.get(i).getCustId());
				customerDTO.setNoOfsites(allsites);
				customerList.add(customerDTO);
				
			}
			return customerList;
			
		}
		
		System.out.println("the response is " + response.toString());
		return null;

		// res.add(result);

		// TODO Auto-generated method stub
		//return null;
	}

	public ClientLogionEntity getSingleClient(long id) {
		ClientLogionEntity result = repo.findBycustId(id);
		if(result!=null)
		{
			return result;
		}
		return null;
	}

	public List<ClientLogionEntity> getallClitesforCustomerCreate(long id) 
	{
		ClientLogionEntity checkUser= repo.findBycustId(id);
		if(checkUser.getUserType()==1)
		{
			List<ClientLogionEntity> res=repo.findall(2);
			return res;
			
		}
	
		
		return null;
	}

	public ClientLogionEntity getSingleCustomer(long id) {
		// TODO Auto-generated method stub
		return repo.findBycustId(id);
	}

	public ClientLogionEntity updateCustomer(long id, ClientLogionEntity update) {
		ClientLogionEntity res = repo.findBycustId(id);
		if(res!=null)
		{
			res.setConfirmPassword(update.getConfirmPassword());
			res.setPassword(update.getPassword());
			res.setCreatedDate(update.getCreatedDate());
			res.setEmail(update.getEmail());
			res.setEnable(update.isEnable());
			res.setFirstName(update.getFirstName());
			res.setLastName(update.getLastName());
			return res;
		}
		return null;
	}

	public String emailCustomerinfromation(long id, String email) {
		
		ClientLogionEntity result = repo.findBycustId(id);
		if(result!=null)
		{
			
			long noOfSites=site.findAllsitesOsites(id);
			
			//long noOfDoors =door.findAllDoor(result.getParentId());
			System.out.println("the result is "+result);Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "mail.smtp2go.com");
			props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(env.getProperty("spring.mail.username"),
							env.getProperty("spring.mail.password"));
				}
			});
			try {
				Message message = new MimeMessage(session);
				Multipart mp = new MimeMultipart("alternative");
				BodyPart textmessage = new MimeBodyPart();
				textmessage.setText("The customer name is "+result.getFirstName()+"\n"+""
						+ " No of sites are  "+noOfSites);
				BodyPart htmlmessage = new MimeBodyPart();
				htmlmessage.setContent("It is a html message.", "text/html");
				mp.addBodyPart(textmessage);
				// mp.addBodyPart(htmlmessage);
				message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject("Customer Info!");
				message.setContent(mp);
				Transport.send(message);
				System.out.println("Done");
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		return "Main sent successfully";
	}

}
