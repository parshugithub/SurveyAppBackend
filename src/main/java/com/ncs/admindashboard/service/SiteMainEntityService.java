package com.ncs.admindashboard.service;

import java.util.List;
import java.util.Properties;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ncs.admindashboard.entity.ClientLogionEntity;
import com.ncs.admindashboard.entity.SiteEntity;
import com.ncs.admindashboard.entity.SiteMainEntity;
import com.ncs.admindashboard.repository.ClientLoginRepository;
import com.ncs.admindashboard.repository.SiteMainEntityRepository;

@Service
public class SiteMainEntityService 
{
	@Autowired
	SiteMainEntityRepository repo;
	@Autowired
	private Environment env;
	
	@Autowired
	ClientLoginRepository loginRepo;

	public SiteMainEntity siteMainEntityCreate(SiteMainEntity siteEntity, long custid, long clientid)
	{
		ClientLogionEntity res = loginRepo.findparentId(clientid);
		if(res!=null)
		{
			siteEntity.setClientid(clientid);
			siteEntity.setCustid(custid);
			siteEntity.setModifiedBy(clientid);
			SiteMainEntity response=	repo.save(siteEntity);
			return response;
			
		}		
		return null;
	}

	public List<SiteMainEntity> getSiteEntity(long custid, long clientid) {
		List<SiteMainEntity> result = repo.findCustomerAndClient(custid,clientid);
		return result;
	}

	public SiteMainEntity siteMainEntityUpdate(SiteMainEntity siteEntity, long siteid) {
		SiteMainEntity siteResponse = repo.findBysiteID(siteid);
		if(siteResponse!=null)
		{
			siteResponse.setCustomerName(siteEntity.getCustomerName());
			siteResponse.setUprn(siteEntity.getUprn());
			siteResponse.setAddressLane1(siteEntity.getAddressLane1());
			siteResponse.setArea(siteEntity.getArea());
			siteResponse.setPostcode(siteEntity.getPostcode());
			siteResponse.setCountry(siteEntity.getCountry());
			siteResponse.setDate(siteEntity.getDate());
			siteResponse.setNcsSiteCode(siteEntity.getNcsSiteCode());
			siteResponse.setAddressLine2(siteEntity.getAddressLine2());
			siteResponse.setTown(siteEntity.getTown());
			siteResponse.setCity(siteEntity.getCity());
			siteResponse.setFlatNumber(siteEntity.getFlatNumber());
			siteResponse.setDoorEntrysystem(siteEntity.getDoorEntrysystem());
			siteResponse.setDoorMake(siteEntity.getDoorMake());
			siteResponse.setDoorManufacture(siteEntity.getDoorManufacture());
			siteResponse.setDoorModel(siteEntity.getDoorModel());
			siteResponse.setDoorMounted(siteEntity.getDoorMounted());
			siteResponse.setDoorMountedAudioOrVideo(siteEntity.getDoorMountedAudioOrVideo());
			siteResponse.setDoorSupplier(siteEntity.getDoorSupplier());
			siteResponse.setDoorWhereFitted(siteEntity.getDoorWhereFitted());
			siteResponse.setFobMake(siteEntity.getFobMake());
			siteResponse.setFobManufacture(siteEntity.getFobManufacture());
			siteResponse.setFobModel(siteEntity.getFobModel());
			siteResponse.setFobMounted(siteEntity.getFobMounted());
			siteResponse.setFobSupplier(siteEntity.getFobSupplier());
			siteResponse.setFobWhereFitted(siteEntity.getFobWhereFitted());
			siteResponse.setFiremanApproxmountedheight(siteEntity.getFiremanApproxmountedheight());
			siteResponse.setFiremanMake(siteEntity.getFiremanMake());
			siteResponse.setFiremanManufacture(siteEntity.getFiremanManufacture());
			siteResponse.setFiremanModel(siteEntity.getFiremanModel());
			siteResponse.setFiremanMounted(siteEntity.getFiremanMounted());
			siteResponse.setFiremanSupplier(siteEntity.getFiremanSupplier());
			siteResponse.setFiremanWhereFitted(siteEntity.getFiremanWhereFitted());
			
			siteResponse.setLocationControlEquipment(siteEntity.getLocationControlEquipment());
			siteResponse.setGeneralConditionControlEquipment(siteEntity.getGeneralConditionControlEquipment());
			siteResponse.setCabinetEarthedCorrectly(siteEntity.getCabinetEarthedCorrectly());
			siteResponse.setMainsVoltage(siteEntity.getMainsVoltage());
			siteResponse.setMeansIsolating(siteEntity.getMeansIsolating());
			siteResponse.setBatteryVoltage(siteEntity.getBatteryVoltage());
			siteResponse.setFloatChargeVoltageOpenCircuit(siteEntity.getFloatChargeVoltageOpenCircuit());
			siteResponse.setFloatChargeVoltageBattery(siteEntity.getFloatChargeVoltageBattery());
			siteResponse.setNominalVoltageAndAmpH(siteEntity.getNominalVoltageAndAmpH());
			siteResponse.setReadingValue(siteEntity.getReadingValue());
			siteResponse.setCalculatedValue(siteEntity.getCalculatedValue());
			siteResponse.setOtherIssue(siteEntity.getOtherIssue());
			siteResponse.setEndOfWorkingItem(siteEntity.getEndOfWorkingItem());
			siteResponse.setRemedialActionRequired(siteEntity.getRemedialActionRequired());
			siteResponse.setCustid(siteResponse.getCustid());
			siteResponse.setClientid(siteResponse.getClientid());
			siteResponse.setModifiedBy(siteResponse.getModifiedBy());
			siteResponse.setCreatedDate(siteResponse.getCreatedDate());
			siteResponse.setUpdatedDate(siteEntity.getUpdatedDate());
			
			
			SiteMainEntity objResponse = repo.save(siteResponse);
			return objResponse;
		}
		return siteResponse;
		}

	public SiteMainEntity getSingleSiteEntity(long siteid) {
		// TODO Auto-generated method stub
		return repo.findBysiteID(siteid);
	}

	public String emailSiteinfromation(long id, String email) {
		SiteMainEntity result = repo.findBysiteID(id);
		if(result!=null)
		{
			
			//long noOfSites=site.findAllsitesOsites(id);
			
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
				textmessage.setText("The Site information is As below"+"\n"+" Site Id is : "+result.getSiteID()+"\n"+""
						+ " Customer Name is : "+result.getCustomerName()+"\n"+
						"NCS Site Code is : "+result.getNcsSiteCode()+"\n"+"Flat Number is "+result.getFlatNumber()
						+"\n"+"uprn is "+result.getUprn()
						+"\n"+"AddressLane1 is : "+result.getAddressLane1()
						+"\n"+"Area : "+result.getArea()
						+"\n"+"Date : "+result.getDate()
						+"\n"+"postcode : "+result.getPostcode()
						+"\n"+"country : "+result.getFlatNumber()
						+"\n"+"AddressLine2 :  "+result.getFlatNumber()
						
						+"\n"+"city:  "+result.getCity()
						+"\n"+"DoorEntrysystem is :   "+result.getDoorEntrysystem()
						+"\n"+"DoorMounted is :   "+result.getDoorMounted()
						+"\n"+"DoorMountedAudioOrVideo is :  "+result.getDoorMountedAudioOrVideo()
						+"\n"+"DoorModel is :   "+result.getDoorMake()
						+"\n"+"DoorModel is:  "+result.getDoorModel()
						+"\n"+"Door Manufacture is :   "+result.getDoorManufacture()
						+"\n"+"Door Supplier is :   "+result.getDoorSupplier()
						+"\n"+"Door WhereFitted is :   "+result.getDoorWhereFitted()
						+"\n"+"Fob Mounted is :   "+result.getFobMounted()
						+"\n"+"Fob Make is :   "+result.getFobMake()
						+"\n"+"Fob Model is :  "+result.getFobModel()
						+"\n"+"Fob Manufacture is :   "+result.getFobManufacture()
						+"\n"+"Fob Supplier is :   "+result.getFobSupplier()
						+"\n"+"Fob WhereFitted is :  "+result.getFobWhereFitted()
						+"\n"+"Fireman Mounted is :   "+result.getFiremanMounted()
						+"\n"+"Fireman Make is :  "+result.getFiremanMake()
						+"\n"+"Fireman Manufacture is :  "+result.getFiremanManufacture()
						
						+"\n"+"Fireman WhereFitted is :   "+result.getFiremanWhereFitted()
						+"\n"+"Fireman Supplier is :   "+result.getFiremanSupplier()
						+"\n"+"Fireman Approxmountedheight is :   "+result.getFiremanApproxmountedheight()
						+"\n"+"Location ControlEquipment is :  "+result.getLocationControlEquipment()
						+"\n"+"General Condition ControlEquipment is :  "+result.getGeneralConditionControlEquipment()
						+"\n"+"Cabinet EarthedCorrectly is : "+result.getCabinetEarthedCorrectly()
						+"\n"+"Flat Number is "+result.getMainsVoltage()
						+"\n"+"Means Isolating is :  "+result.getMeansIsolating()
						+"\n"+"Battery Voltage is :   "+result.getBatteryVoltage()
						+"\n"+"Float Charge Voltage OpenCircuit is :  "+result.getFloatChargeVoltageOpenCircuit()
						+"\n"+"Float Charge Voltage Battery  is :  "+result.getFloatChargeVoltageBattery()
						+"\n"+"Nominal Voltage And AmpH is :   "+result.getNominalVoltageAndAmpH()
						+"\n"+"Reading Value  is :  "+result.getReadingValue()
						+"\n"+"Calculated Value is :   "+result.getCalculatedValue()
						+"\n"+"Other issues is :   "+result.getOtherIssue()
						+"\n"+"Flat Number is "+result.getEndOfWorkingItem()
						+"\n"+"Remedial Action Required is :  "+result.getRemedialActionRequired()
						
						+"\n"+"Modified By is :   "+result.getModifiedBy()
						+"\n"+"Created Date is :   "+result.getCreatedDate()
						+"\n"+"Updated Date  is :  "+result.getUpdatedDate());
				BodyPart htmlmessage = new MimeBodyPart();
				htmlmessage.setContent("It is a html message.", "text/html");
				mp.addBodyPart(textmessage);
				// mp.addBodyPart(htmlmessage);
				message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject("Site Info!");
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
