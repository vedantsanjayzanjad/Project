package com.task.service;

import java.util.*;

import com.task.entities.Holiday;


public interface HolidayService {

	public Holiday createHoliday(Holiday holiday) throws Exception;
	
	public List<Holiday> getAllHoliday();
	
	public void deleteHolidayById(int holidayId);
	
	public Holiday getOneHoliday(int holidayId);
	
	public Holiday updateHoliday(int holidayId,Holiday holiday);
}
