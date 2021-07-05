package com.ncs.admindashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.admindashboard.entity.SiteEntity;
import com.ncs.admindashboard.repository.SiteEntityRepository;

@Service
@Transactional
public class SiteEntityService 
{
	@Autowired
	SiteEntityRepository siteRepo;

	public SiteEntity siteEntityCreate(SiteEntity siteEntity) 
	{
		SiteEntity siteResponse = siteRepo.findBycustomerName(siteEntity.getCustomerName());
		if(siteResponse!=null)
		{
			siteResponse.setCustomerName(siteEntity.getCustomerName());
			siteResponse.setUprn(siteEntity.getUprn());
			siteResponse.setAddressLane1(siteEntity.getAddressLane1());
			siteResponse.setArea(siteEntity.getArea());
			siteResponse.setPostcode(siteEntity.getPostcode());
			siteResponse.setCountry(siteEntity.getCountry());
			siteResponse.setDate(siteEntity.getDate());
			siteResponse.setNcsSiteCode(siteEntity.getNcsSiteCode());
			siteResponse.setAddressLine2(siteEntity.getAddressLine2());
			siteResponse.setTown(siteEntity.getTown());
			siteResponse.setCity(siteEntity.getCity());
			siteResponse.setFlatNumber(siteEntity.getFlatNumber());
			siteResponse.setTypeOfDigitalOrFunctional(siteEntity.getTypeOfDigitalOrFunctional());
			siteResponse.setMountedSurfaceOrFlush(siteEntity.getMountedSurfaceOrFlush());
			siteResponse.setMountedAudioOrVideo(siteEntity.getMountedAudioOrVideo());
			siteResponse.setMake(siteEntity.getMake());
			siteResponse.setModel(siteEntity.getModel());
			siteResponse.setManufacture(siteEntity.getManufacture());
			siteResponse.setSupplier(siteEntity.getSupplier());
			siteResponse.setWhereFitted(siteEntity.getWhereFitted());
			siteResponse.setFobSystemMounted(siteEntity.getFobSystemMounted());
			siteResponse.setFobSystemMake(siteEntity.getFobSystemMake());
			siteResponse.setFobSystemModel(siteEntity.getFobSystemModel());
			siteResponse.setFobSystemManufacture(siteEntity.getFobSystemManufacture());
			siteResponse.setFobSystemSupplier(siteEntity.getFobSystemSupplier());
			siteResponse.setFobSystemWhereFitted(siteEntity.getFobSystemWhereFitted());
			siteResponse.setFiremanSwitchMounted(siteEntity.getFiremanSwitchMounted());
			siteResponse.setFiremanSwitchMake(siteEntity.getFiremanSwitchMake());
			siteResponse.setFiremanSwitchModel(siteEntity.getFiremanSwitchModel());
			siteResponse.setFiremanSwitchManufacture(siteEntity.getFiremanSwitchManufacture());
			siteResponse.setLocationControlEquipment(siteEntity.getLocationControlEquipment());
			siteResponse.setGeneralConditionControlEquipment(siteEntity.getGeneralConditionControlEquipment());
			siteResponse.setCabinetEarthedCorrectly(siteEntity.getCabinetEarthedCorrectly());
			siteResponse.setMainsVoltage(siteEntity.getMainsVoltage());
			siteResponse.setMeansIsolating(siteEntity.getMeansIsolating());
			siteResponse.setBatteryVoltage(siteEntity.getBatteryVoltage());
			siteResponse.setFloatChargeVoltageOpenCircuit(siteEntity.getFloatChargeVoltageOpenCircuit());
			siteResponse.setFloatChargeVoltageBattery(siteEntity.getFloatChargeVoltageBattery());
			siteResponse.setNominalVoltageAndAmpH(siteEntity.getNominalVoltageAndAmpH());
			siteResponse.setReadingValue(siteEntity.getReadingValue());
			siteResponse.setCalculatedValue(siteEntity.getCalculatedValue());
			siteResponse.setOtherIssue(siteEntity.getOtherIssue());
			siteResponse.setEndOfWorkingItem(siteEntity.getEndOfWorkingItem());
			siteResponse.setRemedialActionRequired(siteEntity.getRemedialActionRequired());
			siteResponse.setUploadimage(siteEntity.getUploadimage());
			siteResponse.setImageDescription(siteEntity.getImageDescription());
			
			SiteEntity objResponse = siteRepo.save(siteResponse);
			return objResponse;
			
		}
		
		SiteEntity objResponse = siteRepo.save(siteEntity);
	
		return objResponse;
	}

	public List<SiteEntity> getSiteEntity() {
		// TODO Auto-generated method stub
		return siteRepo.findAll();
	}

	
}
