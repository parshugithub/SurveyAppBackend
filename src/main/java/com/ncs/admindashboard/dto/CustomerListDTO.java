package com.ncs.admindashboard.dto;

public class CustomerListDTO 
{
	private long customerid;
	private String customerName;
	private String parentUser;
	private long parentid;
	private long noOfsites;
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getParentUser() {
		return parentUser;
	}
	public void setParentUser(String parentUser) {
		this.parentUser = parentUser;
	}
	public long getParentid() {
		return parentid;
	}
	public void setParentid(long parentid) {
		this.parentid = parentid;
	}
	public long getNoOfsites() {
		return noOfsites;
	}
	public void setNoOfsites(long noOfsites) {
		this.noOfsites = noOfsites;
	}
	public CustomerListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerListDTO(long customerid, String customerName, String parentUser, long parentid, long noOfsites) {
		super();
		this.customerid = customerid;
		this.customerName = customerName;
		this.parentUser = parentUser;
		this.parentid = parentid;
		this.noOfsites = noOfsites;
	}
	@Override
	public String toString() {
		return "CustomerListDTO [customerid=" + customerid + ", customerName=" + customerName + ", parentUser="
				+ parentUser + ", parentid=" + parentid + ", noOfsites=" + noOfsites + "]";
	}
	
	
	

}
