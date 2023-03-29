package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entities.Holiday;

@Repository
public interface HolidayRepo extends JpaRepository<Holiday, Integer> {

	
}
