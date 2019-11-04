
package com.ust.dao;

import java.util.List;

import com.ust.model.LoginUser;

public interface IUserDao {
	public abstract List<LoginUser> getAllDetails();

	public abstract LoginUser searchUserDetails(String searchString);

	public abstract LoginUser getUserById(int uId);

	public abstract int disableUser(int uId);

	public abstract int insertUserDetails(LoginUser user);

	public abstract int updateUserDetails(LoginUser user);

}
