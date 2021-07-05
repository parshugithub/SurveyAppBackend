package com.ncs.admindashboard;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages= {"com.ncs.admindashboard"})
@EnableJpaRepositories(basePackages= {"com.ncs.admindashboard"})

@SpringBootApplication
public class AccessControlAdminDashboardApplication extends SpringBootServletInitializer{

	
	public static void main(String[] args) {
		SpringApplication.run(AccessControlAdminDashboardApplication.class, args);
	}

}
