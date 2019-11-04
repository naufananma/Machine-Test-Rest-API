package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IUserDao;
import com.ust.model.LoginUser;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginUserController {
	@Autowired
	private IUserDao dao;

	// Get all Users
	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public List getUserDetails() {
		List list;
		System.out.println("Get all User Details");
		list = dao.getAllDetails();
		return list;
}

	// GET by Name
	@RequestMapping(value = "/userdetails/{searchString}", method = RequestMethod.GET)
	public LoginUser getUserDetails(@PathVariable("searchString") String searchString) {
		// List list;
		System.out.println("Get a single User details");
		LoginUser user = dao.searchUserDetails(searchString);
		return user;
	}

	// Get by id
	@RequestMapping(value = "/userbyid/{uId}", method = RequestMethod.GET)
	public LoginUser getUserById(@PathVariable("uId") int uId) {
		LoginUser user = dao.getUserById(uId);
		return user;

	}
	//insert User-Contact Details
	@RequestMapping(value="/insertuser",method=RequestMethod.POST)
	public void insertDetails(@RequestBody LoginUser user)
	{
		dao.insertUserDetails(user);
	}
	
	//update User-Contact Details
	@RequestMapping(value="/updateuser",method=RequestMethod.PUT)
	public void updateDetails(@RequestBody LoginUser user)
	{
		dao.updateUserDetails(user);
	}
	//disable User-Contact Details
		@RequestMapping(value="/disableuser/{uId}",method=RequestMethod.PUT)
		void disableUser(@PathVariable("uId")int uId)
		{
			dao.disableUser(uId);
		}
}
