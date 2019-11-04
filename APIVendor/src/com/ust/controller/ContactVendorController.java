package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IContactVendor;
import com.ust.model.ContactVendor;

@RestController
public class ContactVendorController {

	@Autowired
	IContactVendor vdao;

	// insert 
	
	@RequestMapping(value = "/api/insertvendordetails", method = RequestMethod.POST)
	public void insertDetails(@RequestBody ContactVendor vencon) {
		vdao.insertContactVendorDetails(vencon);
	}

	// update 
	
	@RequestMapping(value = "/api/updatevendordetails", method = RequestMethod.PUT)
	public void updateDetails(@RequestBody ContactVendor vencon) {

		vdao.updateVendorDetails(vencon);
	}

	// disable
	
	@RequestMapping(value = "/api/disablevendor/{vid}", method = RequestMethod.PUT)
	void disableVendor(@PathVariable("vid") int vid) {
		vdao.disableVendor(vid);
	}

	// get all
	
	@SuppressWarnings("rawtypes")

	@RequestMapping(value = "/api/vendordetails/{searchString}", method = RequestMethod.GET)
	public List getVendorDetails(@PathVariable("searchString") String searchString) {
		List list;
		if (searchString.equals("null")) {
			list = vdao.getAllDetails();
		} else {
			list = vdao.searchVendorDetails(searchString);
		}
		return list;
	}

	// get by id
	
	@RequestMapping(value = "/api/vendorbyid/{vid}", method = RequestMethod.GET)
	public ContactVendor getStaffById(@PathVariable("vid") int vid) {
		ContactVendor vencon = vdao.getVendorById(vid);
		return vencon;
	}

}
