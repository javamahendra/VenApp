package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private HibernateTemplate ht;
	
	public int saveUser(User user) {
		return (Integer)ht.save(user);
	}
	
	
	
	
	public User getUserByNameAndPwd(String email, String pwd) {
		User user=null;
		String hql="from "+User.class.getName()
				+" where (emailId=? or mobile=?) and password=?";
		List<User> userList=ht.find(hql, email,email,pwd);
		if(userList!=null && userList.size()>0){
			user=userList.get(0);
		}
		return user;
	}
	
	
}







