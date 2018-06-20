package com.app.dao;

import com.app.model.User;

public interface IUserDao {
	public int saveUser(User user);
	public User getUserByNameAndPwd(String email,String pwd);
}





