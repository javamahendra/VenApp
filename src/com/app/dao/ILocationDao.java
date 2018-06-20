package com.app.dao;

import java.util.List;

import com.app.model.Location;

public interface ILocationDao {

	public int saveLoc(Location loc);
	public List<Location> getAllLocations();
	public void deleteLocById(int locId);
	public Location getLocationById(int locId);
	public void updateLocation(Location loc);
	public List<Object[]> getLocWiseCount();
	public boolean isLocationNameExist(String locName);
	
}





