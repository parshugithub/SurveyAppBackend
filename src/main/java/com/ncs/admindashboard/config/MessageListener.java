package com.ncs.admindashboard.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ncs.admindashboard.repository.MQTTSubscriberBase;



@Component
public class MessageListener  implements Runnable {
	// MQTTConfig config;
	@Autowired
	MQTTSubscriberBase subscriber;

	InetAddress address;

	@Override
	public void run() {
//		try {
//			address  = InetAddress.getByName(this.clientIp);
//			boolean reachable = address.isReachable(1000);
//			System.out.println("the ip address is reachable "+reachable);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		subscriber.subscribeMessage("staffid");
//		subscriber.subscribeMessage("doorgroupid");
		subscriber.subscribeMessage("doorid");
//		subscriber.subscribeMessage("personid");
//		subscriber.subscribeMessage("siteid");
		//subscriber.subscribeMessage("door");
//			subscriber.subscribeMessage("personid");
		//subscriber.subscribeMessage("LOGIN");

	}

	
}
