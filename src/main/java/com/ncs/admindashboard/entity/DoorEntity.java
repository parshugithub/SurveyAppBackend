package com.ncs.admindashboard.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "door_entity_table")
public class DoorEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doorId;
	private String doorReference;
	private String doorLocation;
	private String doorType;
	private String operatedBy;
	private String doorPanelYesOrNo;
	private String doorPanelCondition;
	private String fobReaderYesOrNo;
	private String fobReaderCondition;
	private String mechanicalLockMake;
	private String mechanicalLockModel;
	private String mechanicalLockSupplier;
	private String mechanicalLockCondition;
	private String mechanicalLockKeyNumber;
	private String electroReleaseMake;
	private String electroReleaseModel;
	private String electroReleaseSupplier;
	private String electroReleaseCondition;
	private String doorCloseFittedMake;
	private String doorCloseFittedModel;
	private String doorCloseFittedSupplier;
	private String doorCloseFittedCondition;
	private String doorCloseFittedHinges;
	private String doorCloseFittedCleanPanel;
	private String doorCloseFittedLubricateSwitchButtonswitches;
	private String doorCloseFittedLubricateHinges;
	private String doorCloseFittedLubricateLocks;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdDate;
	
	
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getDoorId() {
		return doorId;
	}
	public void setDoorId(long doorId) {
		this.doorId = doorId;
	}
	public String getDoorReference() {
		return doorReference;
	}
	public void setDoorReference(String doorReference) {
		this.doorReference = doorReference;
	}
	public String getDoorLocation() {
		return doorLocation;
	}
	public void setDoorLocation(String doorLocation) {
		this.doorLocation = doorLocation;
	}
	public String getDoorType() {
		return doorType;
	}
	public void setDoorType(String doorType) {
		this.doorType = doorType;
	}
	public String getOperatedBy() {
		return operatedBy;
	}
	public void setOperatedBy(String operatedBy) {
		this.operatedBy = operatedBy;
	}
	public String getDoorPanelYesOrNo() {
		return doorPanelYesOrNo;
	}
	public void setDoorPanelYesOrNo(String doorPanelYesOrNo) {
		this.doorPanelYesOrNo = doorPanelYesOrNo;
	}
	public String getDoorPanelCondition() {
		return doorPanelCondition;
	}
	public void setDoorPanelCondition(String doorPanelCondition) {
		this.doorPanelCondition = doorPanelCondition;
	}
	public String getFobReaderYesOrNo() {
		return fobReaderYesOrNo;
	}
	public void setFobReaderYesOrNo(String fobReaderYesOrNo) {
		this.fobReaderYesOrNo = fobReaderYesOrNo;
	}
	public String getFobReaderCondition() {
		return fobReaderCondition;
	}
	public void setFobReaderCondition(String fobReaderCondition) {
		this.fobReaderCondition = fobReaderCondition;
	}
	public String getMechanicalLockMake() {
		return mechanicalLockMake;
	}
	public void setMechanicalLockMake(String mechanicalLockMake) {
		this.mechanicalLockMake = mechanicalLockMake;
	}
	public String getMechanicalLockModel() {
		return mechanicalLockModel;
	}
	public void setMechanicalLockModel(String mechanicalLockModel) {
		this.mechanicalLockModel = mechanicalLockModel;
	}
	public String getMechanicalLockSupplier() {
		return mechanicalLockSupplier;
	}
	public void setMechanicalLockSupplier(String mechanicalLockSupplier) {
		this.mechanicalLockSupplier = mechanicalLockSupplier;
	}
	public String getMechanicalLockCondition() {
		return mechanicalLockCondition;
	}
	public void setMechanicalLockCondition(String mechanicalLockCondition) {
		this.mechanicalLockCondition = mechanicalLockCondition;
	}
	public String getMechanicalLockKeyNumber() {
		return mechanicalLockKeyNumber;
	}
	public void setMechanicalLockKeyNumber(String mechanicalLockKeyNumber) {
		this.mechanicalLockKeyNumber = mechanicalLockKeyNumber;
	}
	public String getElectroReleaseMake() {
		return electroReleaseMake;
	}
	public void setElectroReleaseMake(String electroReleaseMake) {
		this.electroReleaseMake = electroReleaseMake;
	}
	public String getElectroReleaseModel() {
		return electroReleaseModel;
	}
	public void setElectroReleaseModel(String electroReleaseModel) {
		this.electroReleaseModel = electroReleaseModel;
	}
	public String getElectroReleaseSupplier() {
		return electroReleaseSupplier;
	}
	public void setElectroReleaseSupplier(String electroReleaseSupplier) {
		this.electroReleaseSupplier = electroReleaseSupplier;
	}
	public String getElectroReleaseCondition() {
		return electroReleaseCondition;
	}
	public void setElectroReleaseCondition(String electroReleaseCondition) {
		this.electroReleaseCondition = electroReleaseCondition;
	}
	public String getDoorCloseFittedMake() {
		return doorCloseFittedMake;
	}
	public void setDoorCloseFittedMake(String doorCloseFittedMake) {
		this.doorCloseFittedMake = doorCloseFittedMake;
	}
	public String getDoorCloseFittedModel() {
		return doorCloseFittedModel;
	}
	public void setDoorCloseFittedModel(String doorCloseFittedModel) {
		this.doorCloseFittedModel = doorCloseFittedModel;
	}
	public String getDoorCloseFittedSupplier() {
		return doorCloseFittedSupplier;
	}
	public void setDoorCloseFittedSupplier(String doorCloseFittedSupplier) {
		this.doorCloseFittedSupplier = doorCloseFittedSupplier;
	}
	public String getDoorCloseFittedCondition() {
		return doorCloseFittedCondition;
	}
	public void setDoorCloseFittedCondition(String doorCloseFittedCondition) {
		this.doorCloseFittedCondition = doorCloseFittedCondition;
	}
	public String getDoorCloseFittedHinges() {
		return doorCloseFittedHinges;
	}
	public void setDoorCloseFittedHinges(String doorCloseFittedHinges) {
		this.doorCloseFittedHinges = doorCloseFittedHinges;
	}
	public String getDoorCloseFittedCleanPanel() {
		return doorCloseFittedCleanPanel;
	}
	public void setDoorCloseFittedCleanPanel(String doorCloseFittedCleanPanel) {
		this.doorCloseFittedCleanPanel = doorCloseFittedCleanPanel;
	}
	public String getDoorCloseFittedLubricateSwitchButtonswitches() {
		return doorCloseFittedLubricateSwitchButtonswitches;
	}
	public void setDoorCloseFittedLubricateSwitchButtonswitches(String doorCloseFittedLubricateSwitchButtonswitches) {
		this.doorCloseFittedLubricateSwitchButtonswitches = doorCloseFittedLubricateSwitchButtonswitches;
	}
	public String getDoorCloseFittedLubricateHinges() {
		return doorCloseFittedLubricateHinges;
	}
	public void setDoorCloseFittedLubricateHinges(String doorCloseFittedLubricateHinges) {
		this.doorCloseFittedLubricateHinges = doorCloseFittedLubricateHinges;
	}
	public String getDoorCloseFittedLubricateLocks() {
		return doorCloseFittedLubricateLocks;
	}
	public void setDoorCloseFittedLubricateLocks(String doorCloseFittedLubricateLocks) {
		this.doorCloseFittedLubricateLocks = doorCloseFittedLubricateLocks;
	}
	public DoorEntity(long doorId, String doorReference, String doorLocation, String doorType, String operatedBy,
			String doorPanelYesOrNo, String doorPanelCondition, String fobReaderYesOrNo, String fobReaderCondition,
			String mechanicalLockMake, String mechanicalLockModel, String mechanicalLockSupplier,
			String mechanicalLockCondition, String mechanicalLockKeyNumber, String electroReleaseMake,
			String electroReleaseModel, String electroReleaseSupplier, String electroReleaseCondition,
			String doorCloseFittedMake, String doorCloseFittedModel, String doorCloseFittedSupplier,
			String doorCloseFittedCondition, String doorCloseFittedHinges, String doorCloseFittedCleanPanel,
			String doorCloseFittedLubricateSwitchButtonswitches, String doorCloseFittedLubricateHinges,
			String doorCloseFittedLubricateLocks) {
		super();
		this.doorId = doorId;
		this.doorReference = doorReference;
		this.doorLocation = doorLocation;
		this.doorType = doorType;
		this.operatedBy = operatedBy;
		this.doorPanelYesOrNo = doorPanelYesOrNo;
		this.doorPanelCondition = doorPanelCondition;
		this.fobReaderYesOrNo = fobReaderYesOrNo;
		this.fobReaderCondition = fobReaderCondition;
		this.mechanicalLockMake = mechanicalLockMake;
		this.mechanicalLockModel = mechanicalLockModel;
		this.mechanicalLockSupplier = mechanicalLockSupplier;
		this.mechanicalLockCondition = mechanicalLockCondition;
		this.mechanicalLockKeyNumber = mechanicalLockKeyNumber;
		this.electroReleaseMake = electroReleaseMake;
		this.electroReleaseModel = electroReleaseModel;
		this.electroReleaseSupplier = electroReleaseSupplier;
		this.electroReleaseCondition = electroReleaseCondition;
		this.doorCloseFittedMake = doorCloseFittedMake;
		this.doorCloseFittedModel = doorCloseFittedModel;
		this.doorCloseFittedSupplier = doorCloseFittedSupplier;
		this.doorCloseFittedCondition = doorCloseFittedCondition;
		this.doorCloseFittedHinges = doorCloseFittedHinges;
		this.doorCloseFittedCleanPanel = doorCloseFittedCleanPanel;
		this.doorCloseFittedLubricateSwitchButtonswitches = doorCloseFittedLubricateSwitchButtonswitches;
		this.doorCloseFittedLubricateHinges = doorCloseFittedLubricateHinges;
		this.doorCloseFittedLubricateLocks = doorCloseFittedLubricateLocks;
	}
	@Override
	public String toString() {
		return "DoorEntity [doorId=" + doorId + ", doorReference=" + doorReference + ", doorLocation=" + doorLocation
				+ ", doorType=" + doorType + ", operatedBy=" + operatedBy + ", doorPanelYesOrNo=" + doorPanelYesOrNo
				+ ", doorPanelCondition=" + doorPanelCondition + ", fobReaderYesOrNo=" + fobReaderYesOrNo
				+ ", fobReaderCondition=" + fobReaderCondition + ", mechanicalLockMake=" + mechanicalLockMake
				+ ", mechanicalLockModel=" + mechanicalLockModel + ", mechanicalLockSupplier=" + mechanicalLockSupplier
				+ ", mechanicalLockCondition=" + mechanicalLockCondition + ", mechanicalLockKeyNumber="
				+ mechanicalLockKeyNumber + ", electroReleaseMake=" + electroReleaseMake + ", electroReleaseModel="
				+ electroReleaseModel + ", electroReleaseSupplier=" + electroReleaseSupplier
				+ ", electroReleaseCondition=" + electroReleaseCondition + ", doorCloseFittedMake="
				+ doorCloseFittedMake + ", doorCloseFittedModel=" + doorCloseFittedModel + ", doorCloseFittedSupplier="
				+ doorCloseFittedSupplier + ", doorCloseFittedCondition=" + doorCloseFittedCondition
				+ ", doorCloseFittedHinges=" + doorCloseFittedHinges + ", doorCloseFittedCleanPanel="
				+ doorCloseFittedCleanPanel + ", doorCloseFittedLubricateSwitchButtonswitches="
				+ doorCloseFittedLubricateSwitchButtonswitches + ", doorCloseFittedLubricateHinges="
				+ doorCloseFittedLubricateHinges + ", doorCloseFittedLubricateLocks=" + doorCloseFittedLubricateLocks
				+ "]";
	}
	public DoorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
