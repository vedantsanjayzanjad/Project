package com.task.serviceimpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entities.Holiday;
import com.task.exception.ResourceNotFoundException;
import com.task.repository.HolidayRepo;
import com.task.service.HolidayService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HolidayImpl implements HolidayService {

	@Autowired
	private HolidayRepo holidayRepo;

	@Override
	public Holiday createHoliday(Holiday holiday) throws Exception {

		log.info("HolidayImpl :: createHoliday function is started ");

		try 
		{
			LocalDate plusDays = holiday.getHolidayDate().plusDays(1);
			holiday.setHolidayDate(plusDays);
			System.out.println(holiday.getHolidayDate());
			Holiday save = this.holidayRepo.save(holiday);
			return holiday;			
		}
		catch (Exception e) {
			log.error("HolidayImpl :: Error in createHoliday " + e.getMessage());
			return null;

		}
	}

	@Override
	public List<Holiday> getAllHoliday() {
		log.info("HolidayImpl :: getAllHoliday function is started ");

		try 
		{
			List<Holiday> findAll = this.holidayRepo.findAll();
			return findAll;			
		}
		catch (Exception e) {
			log.error("HolidayImpl :: Error in getAllHoliday " + e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteHolidayById(int holidayId) {
		log.info("HolidayImpl :: deleteHolidayById function is started ");
		try 
		{
			Holiday delete = this.holidayRepo.findById(holidayId)
					.orElseThrow(() -> new ResourceNotFoundException("Holiday", "HolidayID", holidayId));
			this.holidayRepo.delete(delete);			
		}
		catch (Exception e) {
			log.error("HolidayImpl :: Error in deleteHolidayById " + e.getMessage());
		}
	}

	@Override
	public Holiday getOneHoliday(int holidayId) {
		log.info("HolidayImpl :: getOneHoliday function is started ");

		try {
			Holiday holiday = this.holidayRepo.findById(holidayId)
					.orElseThrow(() -> new ResourceNotFoundException("Holiday", "HolidayID", holidayId));
			return holiday;			
		}
		catch (Exception e) {
			log.error("HolidayImpl :: Error in getOneHoliday " + e.getMessage());
			return null;
		}
		
	}

	@Override
	public Holiday updateHoliday(int holidayId, Holiday holiday) {
		log.info("HolidayImpl :: updateHoliday function is started ");
		try 
		{
			Holiday update = this.holidayRepo.findById(holidayId)
					.orElseThrow(() -> new ResourceNotFoundException("Holiday", "holidayId", holidayId));
			System.out.println(holiday.getHolidayDate());
			
			LocalDate plusDays = holiday.getHolidayDate().plusDays(1);
			
			update.setHolidayDate(plusDays);
			
			update.setHolidayName(holiday.getHolidayName());
			Holiday save = this.holidayRepo.save(update);
			return save;			
		}
		catch(Exception e)
		{
			log.error("HolidayImpl :: Error in updateHoliday " + e.getMessage());
			return null;
		}
	}
}
