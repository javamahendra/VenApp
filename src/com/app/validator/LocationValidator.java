package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.service.ILocationService;

@Component
public class LocationValidator {
	@Autowired
	private ILocationService service;
	
	public String getNameErr(String locName){
		String msg=null;
		boolean flag=service.isLocationNameExist(locName);
		if(flag)
			msg="Location name '"+locName+"' alreay exist";
		return msg;
	}
	
	
	
	
	
}
