package com.ncs.admindashboard.dto;

public class ClientInforDTO 
{
	
	
	private long clientid;
	private String clientName;
	private long noOfCustomer;
	private long noOfsites;
	private long noOfDoors;
	
	
	public long getClientid() {
		return clientid;
	}
	public void setClientid(long clientid) {
		this.clientid = clientid;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public long getNoOfCustomer() {
		return noOfCustomer;
	}
	public void setNoOfCustomer(long noOfCustomer) {
		this.noOfCustomer = noOfCustomer;
	}
	public long getNoOfsites() {
		return noOfsites;
	}
	public void setNoOfsites(long noOfsites) {
		this.noOfsites = noOfsites;
	}
	public long getNoOfDoors() {
		return noOfDoors;
	}
	public void setNoOfDoors(long noOfDoors) {
		this.noOfDoors = noOfDoors;
	}
	public ClientInforDTO(long clientid, String clientName, long noOfCustomer, long noOfsites, long noOfDoors) {
		super();
		this.clientid = clientid;
		this.clientName = clientName;
		this.noOfCustomer = noOfCustomer;
		this.noOfsites = noOfsites;
		this.noOfDoors = noOfDoors;
	}
	public ClientInforDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
