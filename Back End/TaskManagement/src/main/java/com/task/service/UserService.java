package com.task.service;

import java.util.List;
import java.util.Set;

import com.task.entities.User;
import com.task.entities.UserRoles;

public interface UserService {
	public User createUser(User user,Set<UserRoles> set) throws Exception;
	
	public User getUserByUsername(String username);
	
	public void deleteUserById(int userId);
	
	public User fetchUserByUserNameAndPassword(String username, String tempPassword);
	
	public List<User> getAllUser();
	
}
