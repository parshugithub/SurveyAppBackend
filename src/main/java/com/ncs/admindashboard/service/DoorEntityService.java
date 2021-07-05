package com.ncs.admindashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.admindashboard.entity.DoorEntity;
import com.ncs.admindashboard.repository.DoorEntityRepository;

@Service
@Transactional
public class DoorEntityService {

	@Autowired
	DoorEntityRepository doorRepo;

	public DoorEntity doorEntityCreate(DoorEntity doorEntity) {
		DoorEntity entityResponse = doorRepo.findBydoorReference(doorEntity.getDoorReference());
		if (entityResponse != null) {
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
			entityResponse.setDoorPanelYesOrNo(doorEntity.getDoorPanelYesOrNo());
			entityResponse.setDoorReference(doorEntity.getDoorReference());
			entityResponse.setDoorType(doorEntity.getDoorType());
			entityResponse.setElectroReleaseCondition(doorEntity.getElectroReleaseCondition());
			entityResponse.setElectroReleaseMake(doorEntity.getElectroReleaseMake());
			entityResponse.setElectroReleaseModel(doorEntity.getElectroReleaseModel());
			entityResponse.setElectroReleaseSupplier(doorEntity.getElectroReleaseSupplier());
			entityResponse.setOperatedBy(doorEntity.getOperatedBy());
			entityResponse.setFobReaderCondition(doorEntity.getFobReaderCondition());
			entityResponse.setFobReaderYesOrNo(doorEntity.getFobReaderYesOrNo());
			entityResponse.setMechanicalLockCondition(doorEntity.getMechanicalLockCondition());
			entityResponse.setMechanicalLockKeyNumber(doorEntity.getMechanicalLockKeyNumber());
			entityResponse.setMechanicalLockMake(doorEntity.getMechanicalLockMake());
			entityResponse.setMechanicalLockModel(doorEntity.getMechanicalLockModel());
			entityResponse.setMechanicalLockSupplier(doorEntity.getMechanicalLockSupplier());

			DoorEntity ObjResponse = doorRepo.save(entityResponse);
			return ObjResponse;

		}
		
		DoorEntity ObjResponse = doorRepo.save(doorEntity);

		return ObjResponse;
	}

	public List<DoorEntity> getDoorEntity() {
		// TODO Auto-generated method stub
		return doorRepo.findAll();
	}
}
