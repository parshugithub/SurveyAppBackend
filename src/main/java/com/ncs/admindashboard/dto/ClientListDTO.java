package com.ncs.admindashboard.dto;

public class ClientListDTO 
{
	private long clientid;
	private  String clintName;
	private String email;
	private long numberOFSites;
	public long getClientid() {
		return clientid;
	}
	public void setClientid(long clientid) {
		this.clientid = clientid;
	}
	public String getClintName() {
		return clintName;
	}
	public void setClintName(String clintName) {
		this.clintName = clintName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumberOFSites() {
		return numberOFSites;
	}
	public void setNumberOFSites(long numberOFSites) {
		this.numberOFSites = numberOFSites;
	}
	public ClientListDTO(long clientid, String clintName, String email, long numberOFSites) {
		super();
		this.clientid = clientid;
		this.clintName = clintName;
		this.email = email;
		this.numberOFSites = numberOFSites;
	}
	public ClientListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ClientListDTO [clientid=" + clientid + ", clintName=" + clintName + ", email=" + email
				+ ", numberOFSites=" + numberOFSites + "]";
	}

	
	
}
