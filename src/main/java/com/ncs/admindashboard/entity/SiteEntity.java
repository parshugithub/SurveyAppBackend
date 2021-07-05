package com.ncs.admindashboard.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "site_entity_table")
public class SiteEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long siteID;
	private String customerName;
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
	private String typeOfDigitalOrFunctional;
	private String mountedSurfaceOrFlush;
	private String mountedAudioOrVideo;
	private String make;
	private String model;
	private String manufacture;
	private String supplier;
	private String whereFitted;
	private String fobSystemMounted;
	private String fobSystemMake;
	private String fobSystemModel;
	private String fobSystemManufacture;
	private String fobSystemSupplier;
	private String fobSystemWhereFitted;
	private String firemanSwitchMounted;
	private String firemanSwitchMake;
	private String firemanSwitchModel;
	private String firemanSwitchManufacture;
	private String firemanSwitchSupplier;
	private String firemanSwitchWhereFitted;
	private String firemanSwitchApproxmountedheight;
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
	private String uploadimage;
	private String imageDescription;
	
	
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
	public String getTypeOfDigitalOrFunctional() {
		return typeOfDigitalOrFunctional;
	}
	public void setTypeOfDigitalOrFunctional(String typeOfDigitalOrFunctional) {
		this.typeOfDigitalOrFunctional = typeOfDigitalOrFunctional;
	}
	public String getMountedSurfaceOrFlush() {
		return mountedSurfaceOrFlush;
	}
	public void setMountedSurfaceOrFlush(String mountedSurfaceOrFlush) {
		this.mountedSurfaceOrFlush = mountedSurfaceOrFlush;
	}
	public String getMountedAudioOrVideo() {
		return mountedAudioOrVideo;
	}
	public void setMountedAudioOrVideo(String mountedAudioOrVideo) {
		this.mountedAudioOrVideo = mountedAudioOrVideo;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getWhereFitted() {
		return whereFitted;
	}
	public void setWhereFitted(String whereFitted) {
		this.whereFitted = whereFitted;
	}
	public String getFobSystemMounted() {
		return fobSystemMounted;
	}
	public void setFobSystemMounted(String fobSystemMounted) {
		this.fobSystemMounted = fobSystemMounted;
	}
	public String getFobSystemMake() {
		return fobSystemMake;
	}
	public void setFobSystemMake(String fobSystemMake) {
		this.fobSystemMake = fobSystemMake;
	}
	public String getFobSystemModel() {
		return fobSystemModel;
	}
	public void setFobSystemModel(String fobSystemModel) {
		this.fobSystemModel = fobSystemModel;
	}
	public String getFobSystemManufacture() {
		return fobSystemManufacture;
	}
	public void setFobSystemManufacture(String fobSystemManufacture) {
		this.fobSystemManufacture = fobSystemManufacture;
	}
	public String getFobSystemSupplier() {
		return fobSystemSupplier;
	}
	public void setFobSystemSupplier(String fobSystemSupplier) {
		this.fobSystemSupplier = fobSystemSupplier;
	}
	public String getFobSystemWhereFitted() {
		return fobSystemWhereFitted;
	}
	public void setFobSystemWhereFitted(String fobSystemWhereFitted) {
		this.fobSystemWhereFitted = fobSystemWhereFitted;
	}
	public String getFiremanSwitchMounted() {
		return firemanSwitchMounted;
	}
	public void setFiremanSwitchMounted(String firemanSwitchMounted) {
		this.firemanSwitchMounted = firemanSwitchMounted;
	}
	public String getFiremanSwitchMake() {
		return firemanSwitchMake;
	}
	public void setFiremanSwitchMake(String firemanSwitchMake) {
		this.firemanSwitchMake = firemanSwitchMake;
	}
	public String getFiremanSwitchModel() {
		return firemanSwitchModel;
	}
	public void setFiremanSwitchModel(String firemanSwitchModel) {
		this.firemanSwitchModel = firemanSwitchModel;
	}
	public String getFiremanSwitchManufacture() {
		return firemanSwitchManufacture;
	}
	public void setFiremanSwitchManufacture(String firemanSwitchManufacture) {
		this.firemanSwitchManufacture = firemanSwitchManufacture;
	}
	public String getFiremanSwitchSupplier() {
		return firemanSwitchSupplier;
	}
	public void setFiremanSwitchSupplier(String firemanSwitchSupplier) {
		this.firemanSwitchSupplier = firemanSwitchSupplier;
	}
	public String getFiremanSwitchWhereFitted() {
		return firemanSwitchWhereFitted;
	}
	public void setFiremanSwitchWhereFitted(String firemanSwitchWhereFitted) {
		this.firemanSwitchWhereFitted = firemanSwitchWhereFitted;
	}
	public String getFiremanSwitchApproxmountedheight() {
		return firemanSwitchApproxmountedheight;
	}
	public void setFiremanSwitchApproxmountedheight(String firemanSwitchApproxmountedheight) {
		this.firemanSwitchApproxmountedheight = firemanSwitchApproxmountedheight;
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
	public String getUploadimage() {
		return uploadimage;
	}
	public void setUploadimage(String uploadimage) {
		this.uploadimage = uploadimage;
	}
	public String getImageDescription() {
		return imageDescription;
	}
	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
	
	
	public String getUprn() {
		return uprn;
	}
	public void setUprn(String uprn) {
		this.uprn = uprn;
	}
	public String getNcsSiteCode() {
		return ncsSiteCode;
	}
	public void setNcsSiteCode(String ncsSiteCode) {
		this.ncsSiteCode = ncsSiteCode;
	}
	public SiteEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SiteEntity(long siteID, String customerName, String uPRN, String addressLane1, String area, String postcode,
			String country, Date date, String nCSSiteCode, String addressLine2, String town, String city,
			String flatNumber, String typeOfDigitalOrFunctional, String mountedSurfaceOrFlush,
			String mountedAudioOrVideo, String make, String model, String manufacture, String supplier,
			String whereFitted, String fobSystemMounted, String fobSystemMake, String fobSystemModel,
			String fobSystemManufacture, String fobSystemSupplier, String fobSystemWhereFitted,
			String firemanSwitchMounted, String firemanSwitchMake, String firemanSwitchModel,
			String firemanSwitchManufacture, String firemanSwitchSupplier, String firemanSwitchWhereFitted,
			String firemanSwitchApproxmountedheight, String locationControlEquipment,
			String generalConditionControlEquipment, String cabinetEarthedCorrectly, String mainsVoltage,
			String meansIsolating, String batteryVoltage, String floatChargeVoltageOpenCircuit,
			String floatChargeVoltageBattery, String nominalVoltageAndAmpH, String readingValue, String calculatedValue,
			String otherIssue, String endOfWorkingItem, String remedialActionRequired, String uploadimage,
			String imageDescription) {
		super();
		this.siteID = siteID;
		this.customerName = customerName;
		uprn = uPRN;
		this.addressLane1 = addressLane1;
		this.area = area;
		this.postcode = postcode;
		this.country = country;
		this.date = date;
		ncsSiteCode = nCSSiteCode;
		this.addressLine2 = addressLine2;
		this.town = town;
		this.city = city;
		this.flatNumber = flatNumber;
		this.typeOfDigitalOrFunctional = typeOfDigitalOrFunctional;
		this.mountedSurfaceOrFlush = mountedSurfaceOrFlush;
		this.mountedAudioOrVideo = mountedAudioOrVideo;
		this.make = make;
		this.model = model;
		this.manufacture = manufacture;
		this.supplier = supplier;
		this.whereFitted = whereFitted;
		this.fobSystemMounted = fobSystemMounted;
		this.fobSystemMake = fobSystemMake;
		this.fobSystemModel = fobSystemModel;
		this.fobSystemManufacture = fobSystemManufacture;
		this.fobSystemSupplier = fobSystemSupplier;
		this.fobSystemWhereFitted = fobSystemWhereFitted;
		this.firemanSwitchMounted = firemanSwitchMounted;
		this.firemanSwitchMake = firemanSwitchMake;
		this.firemanSwitchModel = firemanSwitchModel;
		this.firemanSwitchManufacture = firemanSwitchManufacture;
		this.firemanSwitchSupplier = firemanSwitchSupplier;
		this.firemanSwitchWhereFitted = firemanSwitchWhereFitted;
		this.firemanSwitchApproxmountedheight = firemanSwitchApproxmountedheight;
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
		this.uploadimage = uploadimage;
		this.imageDescription = imageDescription;
	}
	@Override
	public String toString() {
		return "SiteEntity [siteID=" + siteID + ", customerName=" + customerName + ", UPRN=" + uprn + ", addressLane1="
				+ addressLane1 + ", area=" + area + ", postcode=" + postcode + ", country=" + country + ", date=" + date
				+ ", NCSSiteCode=" + ncsSiteCode + ", addressLine2=" + addressLine2 + ", town=" + town + ", city="
				+ city + ", flatNumber=" + flatNumber + ", typeOfDigitalOrFunctional=" + typeOfDigitalOrFunctional
				+ ", mountedSurfaceOrFlush=" + mountedSurfaceOrFlush + ", mountedAudioOrVideo=" + mountedAudioOrVideo
				+ ", make=" + make + ", model=" + model + ", manufacture=" + manufacture + ", supplier=" + supplier
				+ ", whereFitted=" + whereFitted + ", fobSystemMounted=" + fobSystemMounted + ", fobSystemMake="
				+ fobSystemMake + ", fobSystemModel=" + fobSystemModel + ", fobSystemManufacture="
				+ fobSystemManufacture + ", fobSystemSupplier=" + fobSystemSupplier + ", fobSystemWhereFitted="
				+ fobSystemWhereFitted + ", firemanSwitchMounted=" + firemanSwitchMounted + ", firemanSwitchMake="
				+ firemanSwitchMake + ", firemanSwitchModel=" + firemanSwitchModel + ", firemanSwitchManufacture="
				+ firemanSwitchManufacture + ", firemanSwitchSupplier=" + firemanSwitchSupplier
				+ ", firemanSwitchWhereFitted=" + firemanSwitchWhereFitted + ", firemanSwitchApproxmountedheight="
				+ firemanSwitchApproxmountedheight + ", locationControlEquipment=" + locationControlEquipment
				+ ", generalConditionControlEquipment=" + generalConditionControlEquipment
				+ ", cabinetEarthedCorrectly=" + cabinetEarthedCorrectly + ", mainsVoltage=" + mainsVoltage
				+ ", meansIsolating=" + meansIsolating + ", batteryVoltage=" + batteryVoltage
				+ ", floatChargeVoltageOpenCircuit=" + floatChargeVoltageOpenCircuit + ", floatChargeVoltageBattery="
				+ floatChargeVoltageBattery + ", nominalVoltageAndAmpH=" + nominalVoltageAndAmpH + ", readingValue="
				+ readingValue + ", calculatedValue=" + calculatedValue + ", otherIssue=" + otherIssue
				+ ", endOfWorkingItem=" + endOfWorkingItem + ", remedialActionRequired=" + remedialActionRequired
				+ ", uploadimage=" + uploadimage + ", imageDescription=" + imageDescription + "]";
	}
	
	
	
	
	
	

}
