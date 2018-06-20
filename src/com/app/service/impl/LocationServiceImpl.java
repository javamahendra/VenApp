package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;
@Service
public class LocationServiceImpl implements ILocationService{
	@Autowired
	private ILocationDao dao;
	
	public int saveLoc(Location loc){
		//before saving data, converting locName
		//to upper case letters
		String locName=loc.getLocName();
		loc.setLocName(locName.toUpperCase());
		return dao.saveLoc(loc);
	}
	public List<Location> getAllLocations(){
		return dao.getAllLocations();
	}
	public void deleteLocById(int locId){
		dao.deleteLocById(locId);
	}
	public Location getLocationById(int locId){
		return dao.getLocationById(locId);
	}
	public void updateLocation(Location loc){
		dao.updateLocation(loc);
	}
	public List<Object[]> getLocWiseCount() {
		return dao.getLocWiseCount();
	}
	public boolean isLocationNameExist(String locName) {
		return dao.isLocationNameExist(locName);
	}
	
	
	
	
	
	
	
	
}





