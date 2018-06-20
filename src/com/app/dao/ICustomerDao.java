package com.app.dao;

import com.app.model.Customer;

public interface ICustomerDao {
	public int saveCustomer(Customer c);
	public Customer getCustByUn(String un);
}






