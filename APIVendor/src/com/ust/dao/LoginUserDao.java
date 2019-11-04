package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.ust.model.LoginUser;

public class LoginUserDao implements IUserDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<LoginUser> getAllDetails() {
		// TODO Auto-generated method stub
		return template.query("select id, username,password,roleid from loginuser order by id desc",
				new RowMapper<LoginUser>() {
					public LoginUser mapRow(ResultSet rs, int row) throws SQLException {
						LoginUser user = new LoginUser();
						user.setId(rs.getInt(1));
						user.setUsername(rs.getString(2));
						user.setPassword(rs.getString(3));
						user.setRoleid(rs.getInt(4));
					
						return user;
					}
				});
	}

	@Override
	public LoginUser searchUserDetails(String searchString) {
		// TODO Auto-generated method stub
		String sql = "select id,username,password,roleid from loginuser where username=?";
		return template.queryForObject(sql, new Object[] { searchString }, new BeanPropertyRowMapper<LoginUser>(LoginUser.class));
	}

	@Override
	public LoginUser getUserById(int uId) {
		// TODO Auto-generated method stub
		String sql = "select id,username,password,roleid from loginuser where id=?";
		return template.queryForObject(sql, new Object[] { uId }, new BeanPropertyRowMapper<LoginUser>(LoginUser.class));

	}

	/*--------------------------DELETE---------------------------------*/

	@Override
	public int disableUser(int uId) {
		String sql = "update loginuser set isActive='no' where uId=?";
		return template.update(sql, new Object[] { uId });

	}

	/*--------------------------INSERT---------------------------------*/

	@Override
	public int insertUserDetails(LoginUser user) {

		String sqlOne = "insert into loginuser(username,password,roleid) values('" + user.getUsername() + "','"
				+ user.getPassword() + "','" + user.getRoleid() +"')";

		return template.update(sqlOne);

	}

	/*--------------------------UPDATE---------------------------------*/
	@Override
	public int updateUserDetails(LoginUser user) {
		// to update user table
		String sqlOne = "update loginuser set username='" + user.getUsername() + "',password='" + user.getPassword() + "',roleid='"
				+ user.getRoleid() +   " where id=?";
		return template.update(sqlOne, new Object[] { user.getId() });

	}
}