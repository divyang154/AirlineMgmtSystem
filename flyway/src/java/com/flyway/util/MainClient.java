package com.flyway.util;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.flyway.dao.FlightDao;
import com.flyway.dao.PlacesDao;
import com.flyway.pojo.Airlines;
import com.flyway.pojo.Flight;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;
import com.flyway.service.AirlinesService;
import com.flyway.service.FlightService;
import com.flyway.service.PlaceServices;
import com.flyway.service.UserService;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AirlinesService sc=new AirlinesService();
//		sc.getAllAirlines();
//		AirlinesService airlinesService = new AirlinesService();
//		List<Airlines>listAirlines=airlinesService.getAllAirlines();
//		for(Airlines airlines:listAirlines){
//			System.out.println("Airlines" + airlines.getAirlineId());
//			
//		}
//		User user=new User();
////		user.setUserId(1);
//		user.setUsername("flyadmin");
//		user.setPassword("flyadmin@123");
//		user.setUserEmail("flyadmin123@gmail.com");
//		user.setCreatedBy(1);
//		user.setUpdatedBy(1);
//		user.setCreatedOn(new Date());
//		user.setUpdatedOn(new Date());
//		user.setUserRole("Administrator");
		UserService userService=new UserService();
//		userService.userCreateService(user);
//		User user=userService.getUserService("flyadmin");
//		System.out.println(user);	
//		User user =new User();
//		user.setUsername("user");
//		user.setPassword("user@123");
//		user.setUserEmail("user123@gmail.com");
//		user.setCreatedBy(1);
//		user.setUpdatedBy(1);
//		user.setCreatedOn(new Date());
//		user.setUpdatedOn(new Date());
//		user.setUserRole("User");
//		userService.userCreateService(user);
		
//		PlaceServices placeServ=new PlaceServices();
//		
//		Places source=placeServ.getPlace("22");
//		Places destination=placeServ.getPlace("18");
//		
//		AirlinesService airServ=new AirlinesService();
//		Airlines airline=airServ.getAirlines("3");
//		
//		Flight flight=new Flight();
//		flight.setAirlines(airline);
//		flight.setDestinationPlace(destination);
//		flight.setSourcePlace(source);
//		flight.setPrice("23");
//		flight.setArrivalDate(new Date());
		PlacesDao placeDao=new PlacesDao();
		Places sourcePLace=placeDao.searchByName("Ahmedabad");
		Places destination=placeDao.searchByName("Mumbai");
		String date="2020-11-28";
//		String date="";
		FlightService flightDao=new FlightService();
		List<Flight> flight=flightDao.searchFlight(sourcePLace.getPlaceId().toString(), destination.getPlaceId().toString(), date);
		System.out.println(flight);
		
		
		PlaceServices placeServ=new PlaceServices();
		Places s=placeServ.getPlace("22");
		Places d=placeServ.getPlace("18");
		
		AirlinesService airServ=new AirlinesService();
		Airlines airline=airServ.getAirlines("3");
		
//		Flight flight1=new Flight();
//		Flight flight2=new Flight();
//		
//		flight1.setAirlines(airline);
//		flight1.setPrice("23");
//		flight1.setSourcePlace(s);
//		flight1.setDestinationPlace(d);
//		FlightDao flightDao1=new FlightDao();
//		flightDao1.createFlight(flight1);
//		
//		flight2.setAirlines(airline);
//		flight2.setPrice("23");
//		flight2.setSourcePlace(d);
//		flight2.setDestinationPlace(s);
//		flightDao1.createFlight(flight2);
		
		System.out.println("DestinationPlace" + d.getDestinationFlights());
	}

}
