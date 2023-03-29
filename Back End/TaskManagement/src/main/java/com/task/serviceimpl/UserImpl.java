package com.task.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.entities.User;
import com.task.entities.UserRoles;
import com.task.repository.RoleRepo;
import com.task.repository.UserRepo;
import com.task.repository.UserRolesRepo;
import com.task.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private UserRolesRepo userRole;

	@Override
	public User createUser(User user,Set<UserRoles> userRoles) throws Exception {
		log.info("UserImpl :: createUser function is started ");
		
		try 
		{
			
			User localUser = this.userRepo.findByUsername(user.getUsername());
			
			if (localUser != null) {
				System.out.println("User is Already Present!!");
				throw new Exception("User is already Present!!!");
			} 
			else {
				for (UserRoles ur : userRoles) {
					roleRepo.save(ur.getRole());
				}
				user.getUserRole().addAll(userRoles);
				localUser = this.userRepo.save(user);
			}
			return localUser;
		}
		
		catch(Exception e)
		{
			log.error("UserImpl :: Error in createUser " + e.getMessage());
			return null;
		}
		

	}
	
	@Override
	public User getUserByUsername(String username) {
		log.info("UserImpl :: getUserByUsername function is started ");

		try 
		{
			return this.userRepo.findByUsername(username);			
		}
		catch(Exception e)
		{
			log.error("UserImpl :: Error in getUserByUsername " + e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteUserById(int userId) {
		log.info("UserImpl :: deleteUserById function is started ");
		try{
			User user = this.userRepo.findById(userId)
					.orElseThrow(() -> new com.task.exception.ResourceNotFoundException("User", "UserId", userId));
			this.userRepo.delete(user);			
		}
		catch(Exception e)
		{
			log.error("UserImpl :: Error in deleteUserById " + e.getMessage());
		}

	}

	@Override
	public User fetchUserByUserNameAndPassword(String username, String tempPassword) {
		log.info("UserImpl :: fetchUserByUserNameAndPassword function is started ");
		try 
		{
			return this.userRepo.findByUsernameAndPassword(username, tempPassword);			
		}
		catch(Exception e)
		{
			log.error("UserImpl :: Error in fetchUserByUserNameAndPassword " + e.getMessage());
			return null;

		}
	}

	@Override
	public List<User> getAllUser() {
		log.info("UserImpl :: getAllUser function is started ");
		try 
		{
			List<User> findAll = this.userRepo.findAll();
			return findAll;			
		}
		catch(Exception e)
		{
			log.error("UserImpl :: Error in getAllUser " + e.getMessage());
			return null;

		}
	
	}

}
