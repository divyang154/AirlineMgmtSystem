package com.flyway.service;

import java.util.Date;
import java.util.List;

import com.flyway.dao.AirlinesDao;
import com.flyway.pojo.Airlines;

public class AirlinesService {
	AirlinesDao airlinesDao = new AirlinesDao();
	
	public void createAirlinesService(String nameOfAirlines){
		Airlines airlines=new Airlines();
		airlines.setName(nameOfAirlines);
		airlines.setCreatedBy(1);
		airlines.setUpdatedBy(1);
		airlines.setCreatedOn(new Date());
		airlines.setUpdatedOn(new Date());
		airlinesDao.create(airlines);
	}
	
	public List<Airlines> getAllAirlines(){
		List<Airlines>airlinesList=airlinesDao.getAllAirlines();
		return airlinesList;
	}
	
	public void deleteAirlineService(String id) {
		airlinesDao.deleteAirline(id);
	}
	
	public Airlines getAirlines(String id) {
		Integer airlineId=Integer.parseInt(id);
		Airlines airline=airlinesDao.getAirline(airlineId);
		return airline;
	}
	
	public void updateAirlines(Airlines airline) {
		airline.setUpdatedOn(new Date());
		airlinesDao.updateAirline(airline);
	}
}
