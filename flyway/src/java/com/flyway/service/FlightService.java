package com.flyway.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.flyway.dao.AirlinesDao;
import com.flyway.dao.FlightDao;
import com.flyway.dao.PlacesDao;
import com.flyway.pojo.Airlines;
import com.flyway.pojo.Flight;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;

public class FlightService {

	FlightDao flightDao = new FlightDao();
	PlacesDao placeDao = new PlacesDao();
	AirlinesDao airlineDao = new AirlinesDao();

	public FlightService() {
		// TODO Auto-generated constructor stub
	}

	public void createFlightFlight(User user, String airlineId, String sourcePlace, String destinationPlace,
			String price, Date arrivalDate) {
		Flight flight = new Flight();
		Airlines airlines = airlineDao.getAirline(Integer.parseInt(airlineId));
		Places source = placeDao.getPlace(sourcePlace);
		Places destination = placeDao.getPlace(destinationPlace);
		flight.setDestinationPlace(destination);
		flight.setSourcePlace(source);
		flight.setPrice(price);
		flight.setArrivalDate(arrivalDate);
		flight.setAirlines(airlines);
		if(user!=null) {
		flight.setCreatedBy(user.getUserId());
		flight.setUpdatedBy(user.getUserId());
		}
		flight.setUpdatedOn(new Date());
		flight.setCreatedOn(new Date());
		flightDao.createFlight(flight);
	}

	public List<Flight> getAllFlight() throws ParseException {
		List<Flight> flightList = flightDao.getAllFlights();
		return flightDao.getAllFlights();
	}

	public void deleteFlight(String flightId) {
		flightDao.deleteFlight(flightId);
	}

	public void updateFlight(String airlineId, String sourcePlace, String destinationPlace, String price,
			Date arrivalDate, User user, String flightId) {

		Flight flight = flightDao.getFlight(flightId);
		System.out.println("Id:-" + flight.getFlightId());
		Airlines airlies = airlineDao.getAirline(Integer.parseInt(airlineId));
		Places source = placeDao.getPlace(sourcePlace);
		Places destination = placeDao.getPlace(destinationPlace);
		flight.setDestinationPlace(destination);
		flight.setSourcePlace(source);
		flight.setPrice(price);
		if(user!=null) {
		flight.setUpdatedBy(user.getUserId());
		}
		flight.setUpdatedOn(new Date());
		flight.setArrivalDate(arrivalDate);
		flight.setAirlines(airlies);
		flightDao.updateFlight(flight);

	}

	public Flight getFlight(String flightId) {
		Flight flight = flightDao.getFlight(flightId);
		return flight;
	}

	public List<Flight> searchFlight(String source, String destination, String dateOfTravel) {

		Places placeSource = placeDao.getPlace(source);
		Places destinationPlace = placeDao.getPlace(destination);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = "";
		Date newDate=null;
		if(dateOfTravel.length()>0 && dateOfTravel!=null) {
		try {
//			dateStr = formatter.format(dateOfTravel);
			newDate=formatter.parse(dateOfTravel);
			System.out.println("newDate" + newDate);
		} catch (Exception e) {

		}
		}
		return flightDao.searchFlight(placeSource, destinationPlace, newDate);

	}

}
