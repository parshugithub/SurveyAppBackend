package com.ncs.admindashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.admindashboard.entity.DoorEntity;
import com.ncs.admindashboard.entity.DoorMainEntiry;
import com.ncs.admindashboard.repository.DoorMainEntityRepository;

@Service
public class DoorMainEntityService 
{
	@Autowired
	DoorMainEntityRepository repo;

	public DoorMainEntiry doorMainEntityCreate(DoorMainEntiry doorEntity, long siteid, long clientid) 
	{
		doorEntity.setSiteid(siteid);
		doorEntity.setModifiedBy(clientid);
		doorEntity.setClientid(clientid);
		DoorMainEntiry result =repo.save(doorEntity);
		return result;
	}

	public List<DoorMainEntiry> getdoorEntity(long siteid, long clientid) 
	
	{
		List<DoorMainEntiry>  result = repo.findbySiteidAndClienti(siteid,clientid);
		return result;
	}

	public DoorMainEntiry doorMainEntityUpadate(DoorMainEntiry doorEntity, long doorid) {
		DoorMainEntiry entityResponse = repo.findBydoorId(doorid);
		if (entityResponse != null) {
			entityResponse.setType(doorEntity.getType());
			entityResponse.setCreatedDate(doorEntity.getCreatedDate());
			entityResponse.setDoorCloseFittedCleanPanel(doorEntity.getDoorCloseFittedCleanPanel());
			entityResponse.setDoorCloseFittedCondition(doorEntity.getDoorCloseFittedCondition());
			entityResponse.setDoorCloseFittedHinges(doorEntity.getDoorCloseFittedHinges());
			entityResponse.setDoorCloseFittedLubricateHinges(doorEntity.getDoorCloseFittedLubricateHinges());
			entityResponse.setDoorCloseFittedLubricateLocks(doorEntity.getDoorCloseFittedLubricateLocks());
			entityResponse.setDoorCloseFittedLubricateSwitchButtonswitches(
					doorEntity.getDoorCloseFittedLubricateSwitchButtonswitches());
			entityResponse.setDoorCloseFittedMake(doorEntity.getDoorCloseFittedMake());
			entityResponse.setDoorCloseFittedModel(doorEntity.getDoorCloseFittedModel());
			entityResponse.setDoorCloseFittedSupplier(doorEntity.getDoorCloseFittedSupplier());
			entityResponse.setDoorLocation(doorEntity.getDoorLocation());
			entityResponse.setDoorPanelCondition(doorEntity.getDoorPanelCondition());
			entityResponse.setDoorPanel(doorEntity.getDoorPanel());
			entityResponse.setDoorReference(doorEntity.getDoorReference());
			entityResponse.setDoorType(doorEntity.getDoorType());
			entityResponse.setElectroReleaseCondition(doorEntity.getElectroReleaseCondition());
			entityResponse.setElectroReleaseMake(doorEntity.getElectroReleaseMake());
			entityResponse.setElectroReleaseModel(doorEntity.getElectroReleaseModel());
			entityResponse.setElectroReleaseSupplier(doorEntity.getElectroReleaseSupplier());
			entityResponse.setOperatedBy(doorEntity.getOperatedBy());
			entityResponse.setFobReaderCondition(doorEntity.getFobReaderCondition());
			entityResponse.setFobReader(doorEntity.getFobReader());
			entityResponse.setMechanicalLockCondition(doorEntity.getMechanicalLockCondition());
			entityResponse.setMechanicalLockKeyNumber(doorEntity.getMechanicalLockKeyNumber());
			entityResponse.setMechanicalLockMake(doorEntity.getMechanicalLockMake());
			entityResponse.setMechanicalLockModel(doorEntity.getMechanicalLockModel());
			entityResponse.setMechanicalLockSupplier(doorEntity.getMechanicalLockSupplier());

			entityResponse.setClientid(entityResponse.getClientid());
			entityResponse.setSiteid(entityResponse.getSiteid());
			entityResponse.setModifiedBy(entityResponse.getModifiedBy());
			entityResponse.setCreatedDate(entityResponse.getCreatedDate());
			entityResponse.setUpdatedDate(doorEntity.getUpdatedDate());
			DoorMainEntiry ObjResponse = repo.save(entityResponse);
			return ObjResponse;

		}
		return entityResponse;
	}

	public DoorMainEntiry getsingelDoorEntity(long doorid) {
		// TODO Auto-generated method stub
		return repo.findBydoorId(doorid);
	}
	

}
