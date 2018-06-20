package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommonUtil;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CodecUtil codecUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	
	
	//show page
	@RequestMapping("/regCust")
	public String showPage(){
		return "CustomerReg";
	}
	//save data on click
	@RequestMapping(value="/insertCust",method=RequestMethod.POST)
	public String saveCust(@ModelAttribute("customer")Customer cust,ModelMap map){
		//generating pwd,token using codeUtil
		String token=codeUtil.genToken();
		String pwd=codeUtil.getPwd();
		//encoding using codec util
		String encToken=codecUtil.doEncode(token);
		String encPwd=codecUtil.doEncode(pwd);
		//set encoded values to customer (model attribute)
		cust.setPassword(encPwd);
		cust.setAccTock(encToken);
		//save object using SL.
		int custId=service.saveCustomer(cust);

		//send email
		String text="welcome to Customer :"+cust.getCustName()+
				"("+cust.getCustType()+"),Your user name is:"+cust.getCustEmail()
				+",password is:"+pwd+",token is:"+token;
		commonUtil.sendEmail(cust.getCustEmail(), "welcome to Customer", text);
		//send success msg
		map.addAttribute("msg","Customer added with Id:"+custId);
		return "CustomerReg";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
