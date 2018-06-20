package com.app.service;

import com.app.model.Customer;

public interface ICustomerService {
	public int saveCustomer(Customer c);
	public Customer getCustByUn(String un);
}





