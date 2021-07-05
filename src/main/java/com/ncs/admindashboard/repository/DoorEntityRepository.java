package com.ncs.admindashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.admindashboard.entity.DoorEntity;

@Repository
public interface DoorEntityRepository extends JpaRepository<DoorEntity, Long> {

	DoorEntity findBydoorReference(String doorReference);

}
