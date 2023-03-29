package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entities.User;
import com.task.entities.UserRoles;
import com.task.exception.BadCredentials;
import com.task.service.UserRoleService;
import com.task.serviceimpl.UserImpl;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*")
@Slf4j
@Log4j
public class AuthController {

	@Autowired
	private UserImpl userImpl;
	
	@Autowired
	private UserRoleService userRoleImpl;

	
	@PostMapping(value = "/login")
	public UserRoles loginByUserRoles(@RequestBody User user) throws Exception {
		
			log.info("AuthController :: LoginByUserRoles Function is started::");
			try 
			{
				String username = user.getUsername();
				String userPassword = user.getPassword();
				
				User userObj = null;
				
				if (username != null && userPassword != null) {
					userObj = this.userImpl.fetchUserByUserNameAndPassword(username, userPassword);
					
				}
				if (userObj == null) {
					throw new BadCredentials(username, userPassword);
					
				}	
				
				
				UserRoles userRolesByUser = this.userRoleImpl.getUserRolesByUser(userObj);
				return userRolesByUser;				
			}
			catch(Exception e)
			{
				log.error("AuthController :: Error in LoginByUserRoles Function ");
				return null;

			}
	}
}

