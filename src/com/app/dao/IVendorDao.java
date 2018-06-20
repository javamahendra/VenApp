package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorDao {
	public int saveVendor(Vendor ven);
	public List<Vendor> getAllVendors();
	public void deleteVendorById(int venId);
	public Vendor getVendorById(int venId);
	public void updateVendor(Vendor ven);
}





