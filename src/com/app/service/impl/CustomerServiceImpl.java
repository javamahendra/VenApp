package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerDao dao;
	
	@Override
	public int saveCustomer(Customer c) {
		return dao.saveCustomer(c);
	}

	public Customer getCustByUn(String un) {
		return dao.getCustByUn(un);
	}
	
	
	
	
	

}
