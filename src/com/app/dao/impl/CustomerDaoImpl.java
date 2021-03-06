package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	private HibernateTemplate ht;
	
	public int saveCustomer(Customer c) {
		return (Integer)ht.save(c);
	}
	public Customer getCustByUn(String un){
		Customer cust=null;
		String hql="from com.app.model.Customer where custEmail=?";
		List<Customer> list=ht.find(hql, un);
		if(list!=null && list.size()>0){
			cust=list.get(0);
		}
		return cust;
	}
	
	
	
	
	
	
	
}




