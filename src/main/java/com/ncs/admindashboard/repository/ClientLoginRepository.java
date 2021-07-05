package com.ncs.admindashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.admindashboard.entity.ClientLogionEntity;

@Repository
public interface ClientLoginRepository extends JpaRepository<ClientLogionEntity, Long>{

	ClientLogionEntity findByemail(String email);

	ClientLogionEntity findUserByEmailAndPassword(String emailid, String pass);

	ClientLogionEntity findByparentId(long custid);

	@Query(value = "select * from accesscontroladmindashbord.client_login_table where cust_id =:custid",nativeQuery=true)
	ClientLogionEntity findparentId(long custid);

	ClientLogionEntity findBycustId(long id);

	@Query(value = "select count(*) from accesscontroladmindashbord.client_login_table where user_type =:i",nativeQuery=true)
	long findAllclients(long i);

	@Query(value = "select count(*) from accesscontroladmindashbord.client_login_table where user_type =:i",nativeQuery=true)
	long findAllCustomer(long i);

	@Query(value = "select count(*) from accesscontroladmindashbord.client_login_table where parent_id =:id",nativeQuery=true)
	long findAllCustomerForClient(long id);
	
	@Query(value = "select * from accesscontroladmindashbord.client_login_table where user_type =2",nativeQuery=true)
	List<ClientLogionEntity> findall(long i);

	@Query(value = "select  * from accesscontroladmindashbord.client_login_table where user_type =:id",nativeQuery=true)
	ClientLogionEntity findUser(long id);

	@Query(value = "select * from accesscontroladmindashbord.client_login_table where user_type =:i",nativeQuery=true)
	List<ClientLogionEntity> findallcustomer(long i);

	@Query(value = "select * from accesscontroladmindashbord.client_login_table where parent_id =:id",nativeQuery=true)
	List<ClientLogionEntity> findallCustomersOFClient(long id);
	
	@Query(value = "select * from accesscontroladmindashbord.client_login_table where cust_id=:custId",nativeQuery=true)
	ClientLogionEntity findparent(long custId);

}
