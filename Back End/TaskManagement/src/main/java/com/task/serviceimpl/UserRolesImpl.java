package com.task.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.User;
import com.task.entities.UserRoles;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.UserRolesRepo;
import com.task.service.UserRoleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRolesImpl implements UserRoleService{

	
	@Autowired
	private UserRolesRepo userRoleRepo;
	
	@Override
	public UserRoles getOne(int id) {
	
		log.info("UserRolesImpl :: getone function is started ");
		try 
		{
			UserRoles details = this.userRoleRepo.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("UserRole","UserRoleId", id));
			return details;			
		}
		catch(Exception e)
		{
			log.error("UserRolesImpl :: Error in  getone function " + e.getMessage());
			return null;
		}
	}

	@Override
	public UserRoles getUserRolesByUser(User user) {
		log.info("UserRolesImpl :: getUserRolesByUser function is started ");

		try 
		{
			UserRoles userAndRoles = this.userRoleRepo.findByuser(user);
			return userAndRoles;			
		}
		catch(Exception e)
		{
			log.error("UserRolesImpl :: Error in  getUserRolesByUser function " + e.getMessage());
			return null;
		}
	}

	
}
