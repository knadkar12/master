package com.demo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.UserBean;

public class UserInfoMapper implements RowMapper<UserBean>
{
	public UserBean mapRow(ResultSet rs, int row) throws SQLException 
	{
		String id=rs.getString("id");
		String password=rs.getString("password");
		return new UserBean(id,password);
	}
	
}
