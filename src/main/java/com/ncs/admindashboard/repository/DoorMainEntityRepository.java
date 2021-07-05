package com.ncs.admindashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ncs.admindashboard.entity.DoorMainEntiry;

public interface DoorMainEntityRepository extends JpaRepository<DoorMainEntiry, Long> {

	@Query(value = "select * from accesscontroladmindashbord.door_table  where siteid =:siteid and clientid=:clientid",nativeQuery=true)
	List<DoorMainEntiry> findbySiteidAndClienti(long siteid, long clientid);

	
	@Query(value = "select count(*) from accesscontroladmindashbord.door_table",nativeQuery=true)
	long findAllDoors();

	@Query(value = "select count(*) from accesscontroladmindashbord.door_table where clientid=:id",nativeQuery=true)
	long findAlldoorsForClient(long id);


	DoorMainEntiry findBydoorId(long doorid);


	//long findAllDoor(long parentId);

}
