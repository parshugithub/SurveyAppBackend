package com.ncs.admindashboard.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javax.transaction.Transactional;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.ncs.admindashboard.config.MQTTConfig;
import com.ncs.admindashboard.repository.MQTTSubscriberBase;



/**
 * MQTT Subscriber Class
 * 
 * @author Moniruzzaman Md
 *
 */

@Transactional
@Component
public class MQTTSubscriber extends MQTTConfig implements MqttCallback, MQTTSubscriberBase {
//	@Autowired
//	CreateSiteRepository siterepo;
//
//	TotalDoorService doorservice;
//	@Autowired
//	SiteControllerEventsLongsRepository repo;
//	@Autowired
//	ErrorLogsRepository errorRepo;
//	@Autowired
//	BackTasksRepository backtaskRepo;
//	@Autowired
//	CustomerRepository custRepo;
//
//	@Autowired
//	UserManagementRepository userRepo;

	@Autowired
	MQTTPublisher publisher;
	
	@Autowired
	private Environment env;
	
	Random rand = new Random();
	int newCode = rand.nextInt(10000);


	private String brokerUrl = null;
	final private String colon = ":";
	final private String clientId = "demo2";

	private MqttClient mqttClient = null;
	private MqttConnectOptions connectionOptions = null;
	private MemoryPersistence persistence = null;

	private static final Logger logger = LoggerFactory.getLogger(MQTTSubscriber.class);

	public MQTTSubscriber() {
		this.config();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.paho.client.mqttv3.MqttCallback#connectionLost(java.lang.
	 * Throwable)
	 */
	@Override
	public void connectionLost(Throwable cause) {
		logger.info("Connection Lost");

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println("the token is" + token);
		logger.info("delivery completed");
		try {
			System.out.println("Pub complete" + new String(token.getMessage().getPayload()));
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Leave it blank for subscriber

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.paho.client.mqttv3.MqttCallback#messageArrived(java.lang.String,
	 * org.eclipse.paho.client.mqttv3.MqttMessage)
	 */
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {

		// Called when a message arrives from the server that matches any
		// subscription made by the client
		String time = new Timestamp(System.currentTimeMillis()).toString();
		System.out.println();
		System.out.println("***********************************************************************");
		System.out.println("Message Arrived at Time: " + time + "  Topic: " + topic + "  Message: "
				+ new String(message.getPayload()));
		System.out.println("***********************************************************************");
		System.out.println();
		String mqttACK = new String(message.getPayload());
//		if (mqttACK != null) {
//			if (topic.contains("staffid")) {
//				String taskStatus = "pending";
////				String mqttACK = new String(message.getPayload());
//				System.out.println("the staff subscribe " + mqttACK.toString());
//				System.out.println("cmg subscriber for site");
//				String siteval = "Staff ID";
//				List<BackTasksModal> result = backtaskRepo.getBackTaskWithstaffID(siteval);
//				if (result.size() == 0) {
//					System.out.println("No value");
//				} else {
//
//					// List<BackTasksModal> pendingTask =
//					// backtaskRepo.findbyPendingstatus(taskStatus);
//					for (int i = 0; i < result.size(); i++) {
//
//						// String taskInfo = pendingTask.get(i).getTaskNo();
//						System.out.println("the staff information res " + result);
//						ErrorLogsModal errorLogs = new ErrorLogsModal();
//						errorLogs.setDateAndTime(result.get(i).getDateAndTime());
//						errorLogs.setErrorType(result.get(i).getTaskNo());
//						errorLogs.setErrorDescription("Staff information");
//						errorLogs.setDeviceId(result.get(i).getDeviceid());
//						;
//						errorLogs.setStatus("Failed");
//						errorRepo.save(errorLogs);
//
//						backtaskRepo.deleteById(result.get(i).getTaskId());
//
//					}
//				}
//
//			}
//			if (topic.contains("siteid")) {
//				String taskStatus = "pending";
////				String mqttACK = new String(message.getPayload());
////				if (mqttACK != null) {
////					System.out.println("the site subscribe " + mqttACK.toString());
//				System.out.println("cmg subscriber for site");
//				String siteval = "Site ID";
//				List<BackTasksModal> result = backtaskRepo.getBackTaskWithSiteID(siteval);
//				if (result.size() == 0) {
//					System.out.println("No value");
//				} else {
//
//					for (int i = 0; i < result.size(); i++) {
//						// String taskInfo = pendingTask.get(i).getTaskNo();
//
//						// BackTasksModal result = backtaskRepo.getBackTaskWithSiteID(siteval);
//						System.out.println("the site result is  res " + result);
//						ErrorLogsModal errorLogs = new ErrorLogsModal();
//						errorLogs.setDateAndTime(result.get(i).getDateAndTime());
//						errorLogs.setErrorType(result.get(i).getTaskNo());
//						errorLogs.setErrorDescription("Site information");
//						errorLogs.setDeviceId(result.get(i).getDeviceid());
//						errorLogs.setStatus("Failed");
//						errorRepo.save(errorLogs);
//
//						backtaskRepo.deleteById(result.get(i).getTaskId());
//
//					}
//				}
//			}
//			if (topic.contains("doorid")) {
//				if (doorservice.sitemodal == 0) {
//					String siteval = "Door ID";
//					List<BackTasksModal> result = backtaskRepo.getBackTaskWithDoorID(siteval);
//					if (result.size() == 0) {
//						System.out.println("No value");
//					} else {
//
//						for (int i = 0; i < result.size(); i++) {
//							// String taskInfo = pendingTask.get(i).getTaskNo();
//
//							// BackTasksModal result = backtaskRepo.getBackTaskWithSiteID(siteval);
//							System.out.println("the door result is  res " + result);
//							ErrorLogsModal errorLogs = new ErrorLogsModal();
//							errorLogs.setDateAndTime(result.get(i).getDateAndTime());
//							errorLogs.setErrorType(result.get(i).getTaskNo());
//							errorLogs.setErrorDescription("Door information");
//							errorLogs.setDeviceId(result.get(i).getDeviceid());
//							;
//							errorLogs.setStatus("Failed");
//							errorRepo.save(errorLogs);
//
//							backtaskRepo.deleteById(result.get(i).getTaskId());
//
//						}
//					}
//				}
//
//				else {
//					System.out.println("the message is " + mqttACK);
//					if (mqttACK != null) {
//						Calendar cal = Calendar.getInstance();
//						System.out.println("The time is    " + cal.getTime());
//						Date date = new Date();
//						SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
//						String stringDate = DateFor.format(date);
//						System.out.println("the site id is " + doorservice.sitemodal);
//						CreateSiteModal smodal = siterepo.findBysiteid(doorservice.sitemodal);
//						Customer customerName = custRepo.findById(smodal.getCustId());
//						SiteControllerEventsLongsModal sitecontroller = new SiteControllerEventsLongsModal();
//						sitecontroller.setDateAndTime(stringDate);
//						sitecontroller.setDeviceData(" ");
//						sitecontroller.setEventType("Door Open");
//						sitecontroller.setMessageSuccess("yes");
//						sitecontroller.setPersonName("");
//						sitecontroller.setPhysicalAccessAuthorised("No");
//						sitecontroller.setTwoDoorcontrollerId(new String(message.getPayload()));
//						sitecontroller.setWeigendDeviceClassification("Entry");
//						sitecontroller.setWeigendDeviceType("");
//						sitecontroller.setWeigendOrLockChannelNum("W1");
//						sitecontroller.setSite(smodal.getDeviceId());
//						sitecontroller.setPersonName(customerName.getFirstname() + " " + customerName.getLastname());
//						SiteControllerEventsLongsModal saved = repo.save(sitecontroller);
//						System.out.println("The saved entity " + saved);
//						// sitecontroller.set
//						// CreateSiteModal siteval=doorservice.sitemodal;
//						System.out.println("the site modal is " + smodal.toString());
//
//					}
//				}
//			}
//
//			if (topic.contains("doorgroupid")) {
//				String taskStatus = "pending";
////				String mqttACK = new String(message.getPayload());
////				if (mqttACK != null) {
////					System.out.println("the site subscribe " + mqttACK.toString());
//				System.out.println("cmg subscriber for site");
//				String siteval = "Doorgroup ID";
//				List<BackTasksModal> result = backtaskRepo.getBackTaskWithDoorgroupID(siteval);
//				if (result.size() == 0) {
//					System.out.println("No value");
//				} else {
//
//					for (int i = 0; i < result.size(); i++) {
//						// String taskInfo = pendingTask.get(i).getTaskNo();
//
//						// BackTasksModal result = backtaskRepo.getBackTaskWithSiteID(siteval);
//						System.out.println("the doorgroup result is  res " + result);
//						ErrorLogsModal errorLogs = new ErrorLogsModal();
//						errorLogs.setDateAndTime(result.get(i).getDateAndTime());
//						errorLogs.setErrorType(result.get(i).getTaskNo());
//						errorLogs.setErrorDescription("Doorgroup information");
//						errorLogs.setDeviceId(result.get(i).getDeviceid());
//						;
//						errorLogs.setStatus("Failed");
//						errorRepo.save(errorLogs);
//
//						backtaskRepo.deleteById(result.get(i).getTaskId());
//
//					}
//				}
//			}
//
//			if (topic.contains("personid")) {
//				String taskStatus = "pending";
////				String mqttACK = new String(message.getPayload());
////				if (mqttACK != null) {
////					System.out.println("the site subscribe " + mqttACK.toString());
//				System.out.println("cmg subscriber for site");
//				String siteval = "person ID";
//				List<BackTasksModal> result = backtaskRepo.getBackTaskWithpersonID(siteval);
//				if (result.size() == 0) {
//					System.out.println("No value");
//				} else {
//
//					for (int i = 0; i < result.size(); i++) {
//						// String taskInfo = pendingTask.get(i).getTaskNo();
//
//						// BackTasksModal result = backtaskRepo.getBackTaskWithSiteID(siteval);
//						System.out.println("the doorgroup result is  res " + result);
//						ErrorLogsModal errorLogs = new ErrorLogsModal();
//						errorLogs.setDateAndTime(result.get(i).getDateAndTime());
//						errorLogs.setErrorType(result.get(i).getTaskNo());
//						errorLogs.setErrorDescription("person information");
//						errorLogs.setDeviceId(result.get(i).getDeviceid());
//						;
//						errorLogs.setStatus("Failed");
//						errorRepo.save(errorLogs);
//
//						backtaskRepo.deleteById(result.get(i).getTaskId());
//
//					}
//				}
//			}
//			if (topic.contains("door")) {
//				String taskStatus = "pending";
////				String mqttACK = new String(message.getPayload());
////				if (mqttACK != null) {
////					System.out.println("the site subscribe " + mqttACK.toString());
//				System.out.println("cmg subscriber for site");
//				String siteval = "TradeCode ID";
//				List<BackTasksModal> result = backtaskRepo.getBackTaskWithTradeCodeID(siteval);
//				if (result.size() == 0) {
//					System.out.println("No value");
//				} else {
//
//					for (int i = 0; i < result.size(); i++) {
//						// String taskInfo = pendingTask.get(i).getTaskNo();
//
//						// BackTasksModal result = backtaskRepo.getBackTaskWithSiteID(siteval);
//						System.out.println("the doorgroup result is  res " + result);
//						ErrorLogsModal errorLogs = new ErrorLogsModal();
//						errorLogs.setDateAndTime(result.get(i).getDateAndTime());
//						errorLogs.setErrorType(result.get(i).getTaskNo());
//						errorLogs.setErrorDescription("Door With Tradecode information");
//						errorLogs.setDeviceId(result.get(i).getDeviceid());
//						;
//						errorLogs.setStatus("Failed");
//						errorRepo.save(errorLogs);
//
//						backtaskRepo.deleteById(result.get(i).getTaskId());
//
//					}
//				}
//			}
//
//			if (topic.contains("LOGIN")) {
//				//String taskStatus = "pending";
//				String[] words;
//				String username="";
//				String password="";
//				String mqttACKForLogin = new String(message.getPayload());
//				if(mqttACKForLogin.contains("_"))
//				{
//					words = mqttACKForLogin.split("_");
//					 username = words[0];
//					 password = words[1];
//				}
//				
//				
//				System.out.println("the user name is" + username);
//				System.out.println("the password is" + password);
////				for (int i = 0; i < words.length; i++) 
////				{
//				if (username.contains("@")) {
//					Customer customerResponse = custRepo.findByEmailId(username);
//					System.out.println("the respose password is " + customerResponse.getPassword());
//					if (customerResponse != null) {
//						if (customerResponse.getPassword().equalsIgnoreCase(password)) {
//							System.out.println(" if cmg customer");
//							publisher.publishMessage("LOGIN_ACK", "YES");
//							//subscribeMessage("LOGIN_ACK");
//						} else
//
//						{
//							System.out.println("else cmg customer");
//							publisher.publishMessage("LOGIN_ACK", "NO");
//							
//							//subscribeMessage("LOGIN_ACK");
//						}
//					}
//
//				} else {
//					CreateUserModal userRepose = userRepo.findByuserName(new String(message.getPayload()));
//					if (userRepose != null) {
//						System.out.println(" if cmg user");
//						
//						
//						Properties props = new Properties();
//				        props.put("mail.smtp.auth", "true");
//				        props.put("mail.smtp.starttls.enable", "true");
//				        props.put("mail.smtp.host", "mail.smtp2go.com");
//				        props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
//				        Session session = Session.getInstance(props,
//				        new javax.mail.Authenticator() {
//				        protected PasswordAuthentication getPasswordAuthentication() {
//				        return new PasswordAuthentication(env.getProperty("spring.mail.username"),env.getProperty("spring.mail.password"));
//				        }
//				        });
//				        try {
//				        Message messageMail = new MimeMessage(session);
//				        Multipart mp = new MimeMultipart("alternative");
//				        BodyPart textmessage = new MimeBodyPart();
//				        textmessage.setText("Your code is "+newCode);
//				        BodyPart htmlmessage = new MimeBodyPart();
//				        htmlmessage.setContent("It is a html message.", "text/html");
//				        mp.addBodyPart(textmessage);
//				      //  mp.addBodyPart(htmlmessage);
//				        messageMail.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
//				        messageMail.setRecipients(Message.RecipientType.TO,
//				        InternetAddress.parse(userRepose.getEmail()));
//				        messageMail.setSubject("Reseted Your account!");
//				        messageMail.setContent(mp);
//				        Transport.send(messageMail);
//				       //  Thread.sleep(2000);
//				         
//						publisher.publishMessage("LOGIN_ACK","YES"+"_"+String.valueOf(newCode));
//						subscribeMessage("LOGIN_ACK");
//						
//				        }catch (MessagingException mex) {
//					          mex.printStackTrace();
//					       }
//						
//					} else {
//						System.out.println("else cmg user");
//						publisher.publishMessage("LOGIN_ACK", "NO");
//						//subscribeMessage("LOGIN_ACK");
//
//					}
//
//				}
//
//			}
//		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.paho.client.mqttv3.MqttCallback#deliveryComplete(org.eclipse.paho
	 * .client.mqttv3.IMqttDeliveryToken)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.monirthought.mqtt.subscriber.MQTTSubscriberBase#subscribeMessage(java.
	 * lang.String)
	 */
	@Override
	public void subscribeMessage(String topic) {
		try {
			this.mqttClient.subscribe(topic, this.qos);
		} catch (MqttException me) {
			me.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monirthought.mqtt.subscriber.MQTTSubscriberBase#disconnect()
	 */
	public void disconnect() {
		try {
			this.mqttClient.disconnect();
		} catch (MqttException me) {
			logger.error("ERROR", me);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monirthought.config.MQTTConfig#config(java.lang.String,
	 * java.lang.Integer, java.lang.Boolean, java.lang.Boolean)
	 */
	@Override
	protected void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass) {

		String protocal = this.TCP;
		if (true == ssl) {
			protocal = this.SSL;
		}

		this.brokerUrl = protocal + this.broker + colon + port;
		this.persistence = new MemoryPersistence();
		this.connectionOptions = new MqttConnectOptions();

		try {
			this.mqttClient = new MqttClient(brokerUrl, clientId, persistence);
			this.connectionOptions.setCleanSession(true);
			this.connectionOptions.setKeepAliveInterval(1800);
			if (true == withUserNamePass) {
				if (password != null) {
					this.connectionOptions.setPassword(this.password.toCharArray());
				}
				if (userName != null) {
					this.connectionOptions.setUserName(this.userName);
				}
			}
			// this.mqttClient.setTimeToWait(50);
			this.mqttClient.connect(this.connectionOptions);
			 this.mqttClient.setCallback(this);
		} catch (MqttException me) {
			me.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.monirthought.config.MQTTConfig#config()
	 */
	@Override
	protected void config() {

		this.brokerUrl = this.TCP + this.broker + colon + this.port;
		this.persistence = new MemoryPersistence();
		this.connectionOptions = new MqttConnectOptions();
		try {
			this.mqttClient = new MqttClient(brokerUrl, clientId, persistence);
			this.connectionOptions.setCleanSession(true);
			this.connectionOptions.setKeepAliveInterval(1800);
			// this.mqttClient.setTimeToWait(50);
			this.mqttClient.connect(this.connectionOptions);

			this.mqttClient.setCallback(this);

		} catch (MqttException me) {
			me.printStackTrace();
		}

	}

}
