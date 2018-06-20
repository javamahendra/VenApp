package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;
@Repository
public class LocationDaoImpl implements ILocationDao{
	@Autowired
	private HibernateTemplate ht;
	
	public int saveLoc(Location loc){
		int id=(Integer)ht.save(loc);
		return id;
	}
	public List<Location> getAllLocations(){
		List<Location> locList=ht.loadAll(Location.class);
		return locList;
	}
	
	public void deleteLocById(int locId){
		/**Location loc=new Location();
		loc.setLocId(locId);
		ht.delete(loc);*/
		ht.delete(new Location(locId));
	}
	public Location getLocationById(int locId){
		Location loc=ht.get(Location.class,locId);
		return loc;
	}
	public void updateLocation(Location loc){
		ht.update(loc);
	}
	public List<Object[]> getLocWiseCount() {
		String hql="select locType,count(locType) from "+Location.class.getName()
				+" group by locType";
		List<Object[]> list=ht.find(hql);
		return list;
	}
	
	public boolean isLocationNameExist(String locName) {
		String hql="from "+Location.class.getName()
				+" where locName=?";
		List list=ht.find(hql,locName);
		if(list!=null && list.size()>0)
			return true;
		return false;
	}
}






