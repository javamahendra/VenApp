package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;
import com.app.validator.LocationValidator;
@Controller
public class LocationController {
	@Autowired
	private ILocationService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private LocationUtil locUtil;
	@Autowired
	private LocationValidator validator;


	/**
	 * 1.show LocationReg page
	 * on /logReg request(GET)
	 */
	@RequestMapping("/regLoc")
	public String showLocReg(){
		return "LocationReg";
	}
	/**
	 * 2.On submit  button
	 * from RegPage, data is sent
	 * in obj format to this method
	 * read that using ModelAttribute
	 * concept and send to SL saveLoc method
	 * At last return to UI page with ModelMap data
	 */
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)
	public String insertLoc(@ModelAttribute("location")Location loc,ModelMap map){
		//check name err
		String msg=validator.getNameErr(loc.getLocName().toUpperCase());
		if(msg!=null){
			//error is there
			map.addAttribute("msg",msg);
		}
		else{
			//error is not there
			int locId=service.saveLoc(loc);
			map.addAttribute("msg", "Location saved with:"+locId);
		}
		return "LocationReg";
	}
	/**
	 * 3.This method will be
	 * called on click of hyper
	 * link view All Locations
	 * It will fetch data from
	 * DB using SL and sends to
	 * UI using ModelMap
	 */
	@RequestMapping("/viewAllLocs")
	public String getAllLocs(ModelMap map){
		List<Location> locList=service.getAllLocations();
		map.addAttribute("locListObj", locList);
		return "LocationData";
	}
	/**4.delete data
	 * On click hyper link,
	 * request comes to controller
	 * method with locId param
	 * read using RequestParam
	 * and send to service deleteLoc
	 *  method. At last re-direct to
	 *  viewAll locations
	 */
	@RequestMapping("/deleteLoc")
	public String deleteLoc(@RequestParam("locId")int locId){
		service.deleteLocById(locId);
		return "redirect:viewAllLocs";
	}

	/***
	 * 5.This methods is used to
	 * Display Edit page on click
	 * Update Link from Data Page
	 * It reads id and gets object 
	 * based on Id from Servic Layer
	 * sends data to UI Using ModelMap
	 */
	@RequestMapping("/showEdit")
	public String viewEditPage(@RequestParam("locId")int locId,ModelMap map){
		Location loc=service.getLocationById(locId);
		map.addAttribute("locObj",loc);
		return "LocationDataEdit";
	}
	/**
	 * 6. It reads ModelAttribute
	 * on click from EditPage.
	 * And sends to SL at last
	 * return to viewAllLocations(redirect)
	 */
	@RequestMapping(value="/updateLoc",method=RequestMethod.POST)
	public String updateLoc(@ModelAttribute("location")Location loc){
		service.updateLocation(loc);
		return "redirect:viewAllLocs";
	}
	/**
	 * Get Data From DB to send to View class
	 * for Excel Export
	 * 
	 */
	@RequestMapping("/locExcelExport")
	public String exportDataToExcel(ModelMap map){
		map.addAttribute("locListObj",service.getAllLocations());
		return "locExcelView";
	}

	/**
	 * Get Data From DB to send to View class
	 * for Pdf Export
	 * 
	 */
	@RequestMapping("/locPdfExport")
	public String exportDataToPdf(ModelMap map){
		map.addAttribute("locListObj",service.getAllLocations());
		return "locPdfView";
	}
	/**
	 * This method is used to fetch Data from DB
	 * on click UI link (Report Menu)
	 * and also location from ServletContext realPath 
	 */
	@RequestMapping("/generateReport")
	public String generateReportforLoc(){
		List<Object[]> data=service.getLocWiseCount();
		String path=context.getRealPath("/");
		locUtil.generatePieChart(path, data);
		locUtil.generateBarChart(path, data);
		return "LocReport";
	}







}




