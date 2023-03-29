package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.task.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
	
	public User findByUsernameAndPassword(String username,String password);
	
}
