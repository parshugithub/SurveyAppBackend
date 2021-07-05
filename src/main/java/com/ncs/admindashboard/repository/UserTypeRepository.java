package com.ncs.admindashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ncs.admindashboard.entity.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
