package com.ncs.admindashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.admindashboard.entity.SiteMainEntity;

@Repository
public interface SiteMainEntityRepository extends JpaRepository<SiteMainEntity, Long> {

	
	@Query(value = "select * from accesscontroladmindashbord.site_table  where custid =:custid and clientid=:clientid",nativeQuery=true)
	List<SiteMainEntity> findCustomerAndClient(long custid, long clientid);

	@Query(value = "select count(*) from accesscontroladmindashbord.site_table",nativeQuery=true)
	long findAllsites();

	
	@Query(value = "select count(*) from accesscontroladmindashbord.site_table where  clientid=:id",nativeQuery=true)
	long findAllsitesOfClient(long id);
	
	@Query(value = "select count(*) from accesscontroladmindashbord.site_table where  custid=:id",nativeQuery=true)
	long findAllsitesOsites(long id);

	
	@Query(value = "select count(*) from accesscontroladmindashbord.site_table where  custid=:id",nativeQuery=true)
	long findAllsitesOfcustomert(long id);

	//SiteMainEntity findBysiteid(long siteid);

	SiteMainEntity findBysiteID(long siteid);

}
