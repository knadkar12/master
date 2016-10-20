package com.demo.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.demo.UserBean;
import com.demo.rowmapper.UserInfoMapper;

public class UserDao 
{
	private JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public UserBean check(String id)
	{
		String sql="select id,password from user10 where id= ? ";
		Object[] param = new Object[]{id};
		UserInfoMapper mapper = new UserInfoMapper();
		try
		{
		UserBean bean = jt.queryForObject(sql,param, mapper);
		return bean;
		}
		catch(EmptyResultDataAccessException e)
		{
			return null;
		}
	}
}
