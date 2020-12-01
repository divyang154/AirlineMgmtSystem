package com.flyway.service;

import java.util.Date;
import java.util.List;

import com.flyway.dao.PlacesDao;
import com.flyway.pojo.Places;
import com.flyway.pojo.User;

public class PlaceServices {

	PlacesDao placesDao = new PlacesDao();

	public PlaceServices() {
		// TODO Auto-generated constructor stub
	}

	public void createPlacesServices(Places places) {
		places.setCreatedOn(new Date());
		places.setUpdatedOn(new Date());
		placesDao.createPlaces(places);
	}

	public List<Places> getAllPlaces() {
		List<Places> placesList = placesDao.getAllPlaces();
		System.out.println(placesList);
		return placesList;
	}

	public Places getPlace(String id) {
		Places place = placesDao.getPlace(id);
		return place;
	}
	
	public void updatePlaces(Places place,User user) {
		if(user!=null) {
		place.setUpdatedBy(user.getUserId());
		}
		place.setUpdatedOn(new Date());
		placesDao.updatePlace(place);
	}
	
	public void deletePlaces(String placeId) {
		placesDao.deletePlace(placeId);
          
	}

}
