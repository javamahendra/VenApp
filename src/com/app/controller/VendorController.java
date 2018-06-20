package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Location;
import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;
@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private LocationUtil locUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	
	
	
	
	
	//1.show Reg page
	@RequestMapping("/regVen")
	public String viewVenRegPage(ModelMap map){
		List<Location> locList=locUtil.getAllLocs();
		map.addAttribute("locListObj", locList);
		return "VendorReg";
	}
	
	//2.save data on submit
	@RequestMapping(value="/insertVen",method=RequestMethod.POST)
	public String saveVend(@ModelAttribute("vendor")Vendor ven,ModelMap map,
			@RequestParam("sdocs")CommonsMultipartFile file){
		int venId=service.saveVendor(ven);
		
		//send email
		commonUtil.sendEmail(ven.getVenMail(), "welcome to VDM..", "Hello vendor..."+ven.getVenId(), file);
		
		/**display locations at UI page*/
		List<Location> locList=locUtil.getAllLocs();
		map.addAttribute("locListObj", locList);
		/**end*/
		map.addAttribute("msg", "Saved with Id:"+venId);
		return "VendorReg";
	}
	
	
	
	
	
	//3.get data
	@RequestMapping("/viewAllven")
	public String getAllVens(ModelMap map){
		List<Vendor> vendorList=service.getAllVendors();
		map.addAttribute("venListObj", vendorList);
		return "VendorData";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}




