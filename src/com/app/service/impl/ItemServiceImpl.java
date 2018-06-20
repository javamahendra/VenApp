package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private IItemDao dao;
	
	public int saveItem(Item item) {
		return dao.saveItem(item);
	}
	
	
	
	
	
	
}






