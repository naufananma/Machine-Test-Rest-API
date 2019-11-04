package com.ust.dao;

import java.util.List;

import com.ust.model.ContactVendor;

public interface IContactVendor {

	public abstract int insertContactVendorDetails(ContactVendor vencon);

	public abstract List<ContactVendor> getAllDetails();

	public abstract int disableVendor(int vid);

	public abstract int updateVendorDetails(ContactVendor vencon);

	public abstract List<ContactVendor> searchVendorDetails(String searchString);

	public abstract ContactVendor getVendorById(int vid);

}