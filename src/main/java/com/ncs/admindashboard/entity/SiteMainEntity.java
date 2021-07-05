package com.ncs.admindashboard.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "site_table")
public class SiteMainEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long siteID;
	private String customerName;
	private long custid;
	private long clientid;
	private String uprn;
	private String addressLane1;
	private String area;
	private String postcode;
	private String country;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;
	private String ncsSiteCode ;
	private String addressLine2;
	private String town;
	private String city;
	private String flatNumber;
	private String doorEntrysystem;
	private String doorMounted;
	private String doorMountedAudioOrVideo;
	private String doorMake;
	private String doorModel;
	private String doorManufacture;
	private String doorSupplier;
	private String doorWhereFitted;
	private String fobMounted;
	private String fobMake;
	private String fobModel;
	private String fobManufacture;
	private String fobSupplier;
	private String fobWhereFitted;
	private String firemanMounted;
	private String firemanMake;
	private String firemanModel;
	private String firemanManufacture;
	private String firemanSupplier;
	private String firemanWhereFitted;
	private String firemanApproxmountedheight;
	private String locationControlEquipment;
	private String generalConditionControlEquipment;
	private String cabinetEarthedCorrectly;
	private String mainsVoltage;
	private String meansIsolating;
	private String batteryVoltage;
	private String floatChargeVoltageOpenCircuit;
	private String floatChargeVoltageBattery;
	private String nominalVoltageAndAmpH;
	private String readingValue;
	private String calculatedValue;
	private String otherIssue;
	private String endOfWorkingItem;
	private String remedialActionRequired;
	private long modifiedBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updatedDate;

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public long getClientid() {
		return clientid;
	}

	public void setClientid(long clientid) {
		this.clientid = clientid;
	}

	public long getSiteID() {
		return siteID;
	}

	public void setSiteID(long siteID) {
		this.siteID = siteID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUprn() {
		return uprn;
	}

	public void setUprn(String uprn) {
		this.uprn = uprn;
	}

	public String getAddressLane1() {
		return addressLane1;
	}

	public void setAddressLane1(String addressLane1) {
		this.addressLane1 = addressLane1;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNcsSiteCode() {
		return ncsSiteCode;
	}

	public void setNcsSiteCode(String ncsSiteCode) {
		this.ncsSiteCode = ncsSiteCode;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getDoorEntrysystem() {
		return doorEntrysystem;
	}

	public void setDoorEntrysystem(String doorEntrysystem) {
		this.doorEntrysystem = doorEntrysystem;
	}

	public String getDoorMounted() {
		return doorMounted;
	}

	public void setDoorMounted(String doorMounted) {
		this.doorMounted = doorMounted;
	}

	public String getDoorMountedAudioOrVideo() {
		return doorMountedAudioOrVideo;
	}

	public void setDoorMountedAudioOrVideo(String doorMountedAudioOrVideo) {
		this.doorMountedAudioOrVideo = doorMountedAudioOrVideo;
	}

	public String getDoorMake() {
		return doorMake;
	}

	public void setDoorMake(String doorMake) {
		this.doorMake = doorMake;
	}

	public String getDoorModel() {
		return doorModel;
	}

	public void setDoorModel(String doorModel) {
		this.doorModel = doorModel;
	}

	public String getDoorManufacture() {
		return doorManufacture;
	}

	public void setDoorManufacture(String doorManufacture) {
		this.doorManufacture = doorManufacture;
	}

	public String getDoorSupplier() {
		return doorSupplier;
	}

	public void setDoorSupplier(String doorSupplier) {
		this.doorSupplier = doorSupplier;
	}

	public String getDoorWhereFitted() {
		return doorWhereFitted;
	}

	public void setDoorWhereFitted(String doorWhereFitted) {
		this.doorWhereFitted = doorWhereFitted;
	}

	public String getFobMounted() {
		return fobMounted;
	}

	public void setFobMounted(String fobMounted) {
		this.fobMounted = fobMounted;
	}

	public String getFobMake() {
		return fobMake;
	}

	public void setFobMake(String fobMake) {
		this.fobMake = fobMake;
	}

	public String getFobModel() {
		return fobModel;
	}

	public void setFobModel(String fobModel) {
		this.fobModel = fobModel;
	}

	public String getFobManufacture() {
		return fobManufacture;
	}

	public void setFobManufacture(String fobManufacture) {
		this.fobManufacture = fobManufacture;
	}

	public String getFobSupplier() {
		return fobSupplier;
	}

	public void setFobSupplier(String fobSupplier) {
		this.fobSupplier = fobSupplier;
	}

	public String getFobWhereFitted() {
		return fobWhereFitted;
	}

	public void setFobWhereFitted(String fobWhereFitted) {
		this.fobWhereFitted = fobWhereFitted;
	}

	public String getFiremanMounted() {
		return firemanMounted;
	}

	public void setFiremanMounted(String firemanMounted) {
		this.firemanMounted = firemanMounted;
	}

	public String getFiremanMake() {
		return firemanMake;
	}

	public void setFiremanMake(String firemanMake) {
		this.firemanMake = firemanMake;
	}

	public String getFiremanModel() {
		return firemanModel;
	}

	public void setFiremanModel(String firemanModel) {
		this.firemanModel = firemanModel;
	}

	public String getFiremanManufacture() {
		return firemanManufacture;
	}

	public void setFiremanManufacture(String firemanManufacture) {
		this.firemanManufacture = firemanManufacture;
	}

	public String getFiremanSupplier() {
		return firemanSupplier;
	}

	public void setFiremanSupplier(String firemanSupplier) {
		this.firemanSupplier = firemanSupplier;
	}

	public String getFiremanWhereFitted() {
		return firemanWhereFitted;
	}

	public void setFiremanWhereFitted(String firemanWhereFitted) {
		this.firemanWhereFitted = firemanWhereFitted;
	}

	public String getFiremanApproxmountedheight() {
		return firemanApproxmountedheight;
	}

	public void setFiremanApproxmountedheight(String firemanApproxmountedheight) {
		this.firemanApproxmountedheight = firemanApproxmountedheight;
	}

	public String getLocationControlEquipment() {
		return locationControlEquipment;
	}

	public void setLocationControlEquipment(String locationControlEquipment) {
		this.locationControlEquipment = locationControlEquipment;
	}

	public String getGeneralConditionControlEquipment() {
		return generalConditionControlEquipment;
	}

	public void setGeneralConditionControlEquipment(String generalConditionControlEquipment) {
		this.generalConditionControlEquipment = generalConditionControlEquipment;
	}

	public String getCabinetEarthedCorrectly() {
		return cabinetEarthedCorrectly;
	}

	public void setCabinetEarthedCorrectly(String cabinetEarthedCorrectly) {
		this.cabinetEarthedCorrectly = cabinetEarthedCorrectly;
	}

	public String getMainsVoltage() {
		return mainsVoltage;
	}

	public void setMainsVoltage(String mainsVoltage) {
		this.mainsVoltage = mainsVoltage;
	}

	public String getMeansIsolating() {
		return meansIsolating;
	}

	public void setMeansIsolating(String meansIsolating) {
		this.meansIsolating = meansIsolating;
	}

	public String getBatteryVoltage() {
		return batteryVoltage;
	}

	public void setBatteryVoltage(String batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}

	public String getFloatChargeVoltageOpenCircuit() {
		return floatChargeVoltageOpenCircuit;
	}

	public void setFloatChargeVoltageOpenCircuit(String floatChargeVoltageOpenCircuit) {
		this.floatChargeVoltageOpenCircuit = floatChargeVoltageOpenCircuit;
	}

	public String getFloatChargeVoltageBattery() {
		return floatChargeVoltageBattery;
	}

	public void setFloatChargeVoltageBattery(String floatChargeVoltageBattery) {
		this.floatChargeVoltageBattery = floatChargeVoltageBattery;
	}

	public String getNominalVoltageAndAmpH() {
		return nominalVoltageAndAmpH;
	}

	public void setNominalVoltageAndAmpH(String nominalVoltageAndAmpH) {
		this.nominalVoltageAndAmpH = nominalVoltageAndAmpH;
	}

	public String getReadingValue() {
		return readingValue;
	}

	public void setReadingValue(String readingValue) {
		this.readingValue = readingValue;
	}

	public String getCalculatedValue() {
		return calculatedValue;
	}

	public void setCalculatedValue(String calculatedValue) {
		this.calculatedValue = calculatedValue;
	}

	public String getOtherIssue() {
		return otherIssue;
	}

	public void setOtherIssue(String otherIssue) {
		this.otherIssue = otherIssue;
	}

	public String getEndOfWorkingItem() {
		return endOfWorkingItem;
	}

	public void setEndOfWorkingItem(String endOfWorkingItem) {
		this.endOfWorkingItem = endOfWorkingItem;
	}

	public String getRemedialActionRequired() {
		return remedialActionRequired;
	}

	public void setRemedialActionRequired(String remedialActionRequired) {
		this.remedialActionRequired = remedialActionRequired;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "SiteMainEntity [siteID=" + siteID + ", customerName=" + customerName + ", uprn=" + uprn
				+ ", addressLane1=" + addressLane1 + ", area=" + area + ", postcode=" + postcode + ", country="
				+ country + ", date=" + date + ", ncsSiteCode=" + ncsSiteCode + ", addressLine2=" + addressLine2
				+ ", town=" + town + ", city=" + city + ", flatNumber=" + flatNumber + ", doorEntrysystem="
				+ doorEntrysystem + ", DoorMounted=" + doorMounted + ", doorMountedAudioOrVideo="
				+ doorMountedAudioOrVideo + ", doorMake=" + doorMake + ", doorModel=" + doorModel + ", doorManufacture="
				+ doorManufacture + ", doorSupplier=" + doorSupplier + ", doorWhereFitted=" + doorWhereFitted
				+ ", fobMounted=" + fobMounted + ", fobMake=" + fobMake + ", fobModel=" + fobModel + ", fobManufacture="
				+ fobManufacture + ", fobSupplier=" + fobSupplier + ", fobWhereFitted=" + fobWhereFitted
				+ ", firemanMounted=" + firemanMounted + ", firemanMake=" + firemanMake + ", firemanModel="
				+ firemanModel + ", firemanManufacture=" + firemanManufacture + ", firemanSupplier=" + firemanSupplier
				+ ", firemanWhereFitted=" + firemanWhereFitted + ", firemanApproxmountedheight="
				+ firemanApproxmountedheight + ", locationControlEquipment=" + locationControlEquipment
				+ ", generalConditionControlEquipment=" + generalConditionControlEquipment
				+ ", cabinetEarthedCorrectly=" + cabinetEarthedCorrectly + ", mainsVoltage=" + mainsVoltage
				+ ", meansIsolating=" + meansIsolating + ", batteryVoltage=" + batteryVoltage
				+ ", floatChargeVoltageOpenCircuit=" + floatChargeVoltageOpenCircuit + ", floatChargeVoltageBattery="
				+ floatChargeVoltageBattery + ", nominalVoltageAndAmpH=" + nominalVoltageAndAmpH + ", readingValue="
				+ readingValue + ", calculatedValue=" + calculatedValue + ", otherIssue=" + otherIssue
				+ ", endOfWorkingItem=" + endOfWorkingItem + ", remedialActionRequired=" + remedialActionRequired
				+ ", modifiedBy=" + modifiedBy + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	public SiteMainEntity(long siteID, String customerName, String uprn, String addressLane1, String area,
			String postcode, String country, Date date, String ncsSiteCode, String addressLine2, String town,
			String city, String flatNumber, String doorEntrysystem, String doorMounted, String doorMountedAudioOrVideo,
			String doorMake, String doorModel, String doorManufacture, String doorSupplier, String doorWhereFitted,
			String fobMounted, String fobMake, String fobModel, String fobManufacture, String fobSupplier,
			String fobWhereFitted, String firemanMounted, String firemanMake, String firemanModel,
			String firemanManufacture, String firemanSupplier, String firemanWhereFitted,
			String firemanApproxmountedheight, String locationControlEquipment, String generalConditionControlEquipment,
			String cabinetEarthedCorrectly, String mainsVoltage, String meansIsolating, String batteryVoltage,
			String floatChargeVoltageOpenCircuit, String floatChargeVoltageBattery, String nominalVoltageAndAmpH,
			String readingValue, String calculatedValue, String otherIssue, String endOfWorkingItem,
			String remedialActionRequired, long modifiedBy, Date createdDate, Date updatedDate) {
		super();
		this.siteID = siteID;
		this.customerName = customerName;
		this.uprn = uprn;
		this.addressLane1 = addressLane1;
		this.area = area;
		this.postcode = postcode;
		this.country = country;
		this.date = date;
		this.ncsSiteCode = ncsSiteCode;
		this.addressLine2 = addressLine2;
		this.town = town;
		this.city = city;
		this.flatNumber = flatNumber;
		this.doorEntrysystem = doorEntrysystem;
		this.doorMounted = doorMounted;
		this.doorMountedAudioOrVideo = doorMountedAudioOrVideo;
		this.doorMake = doorMake;
		this.doorModel = doorModel;
		this.doorManufacture = doorManufacture;
		this.doorSupplier = doorSupplier;
		this.doorWhereFitted = doorWhereFitted;
		this.fobMounted = fobMounted;
		this.fobMake = fobMake;
		this.fobModel = fobModel;
		this.fobManufacture = fobManufacture;
		this.fobSupplier = fobSupplier;
		this.fobWhereFitted = fobWhereFitted;
		this.firemanMounted = firemanMounted;
		this.firemanMake = firemanMake;
		this.firemanModel = firemanModel;
		this.firemanManufacture = firemanManufacture;
		this.firemanSupplier = firemanSupplier;
		this.firemanWhereFitted = firemanWhereFitted;
		this.firemanApproxmountedheight = firemanApproxmountedheight;
		this.locationControlEquipment = locationControlEquipment;
		this.generalConditionControlEquipment = generalConditionControlEquipment;
		this.cabinetEarthedCorrectly = cabinetEarthedCorrectly;
		this.mainsVoltage = mainsVoltage;
		this.meansIsolating = meansIsolating;
		this.batteryVoltage = batteryVoltage;
		this.floatChargeVoltageOpenCircuit = floatChargeVoltageOpenCircuit;
		this.floatChargeVoltageBattery = floatChargeVoltageBattery;
		this.nominalVoltageAndAmpH = nominalVoltageAndAmpH;
		this.readingValue = readingValue;
		this.calculatedValue = calculatedValue;
		this.otherIssue = otherIssue;
		this.endOfWorkingItem = endOfWorkingItem;
		this.remedialActionRequired = remedialActionRequired;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public SiteMainEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
