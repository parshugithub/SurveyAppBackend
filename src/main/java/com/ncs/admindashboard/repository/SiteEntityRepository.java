package com.ncs.admindashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.admindashboard.entity.SiteEntity;

@Repository
public interface SiteEntityRepository extends JpaRepository<SiteEntity,Long> {

	SiteEntity findBycustomerName(String customerName);

}
