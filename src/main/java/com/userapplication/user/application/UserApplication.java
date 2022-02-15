package com.userapplication.user.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}

//user application
//user application user table user id, user name , user age, user account id , user department id,----------------------------------
//	account table--------------------------------------------------------------------------------------------------------
//	department table----------------------------------------------------------------------------------------------
//	create user user name, age, department-----------------------------------------------------------------------------------------------

//	public user getAge()----------------------------------------------------------------------------------------
//		cread operations-------------------------------------------------------------------------------------
//	update------------------------------------------------------------------------------------------
//	repository calsses------------------------------------------------------------------------------------------


//	integration casses for DB
//	test cases


//	MVC structure
//	jot token/jo token

//atomicity