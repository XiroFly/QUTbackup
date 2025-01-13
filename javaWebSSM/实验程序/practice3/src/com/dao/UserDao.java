package com.dao;

public interface UserDao{
	public int save(String sql, Object param[]);
	public int delete(String sql, Object param[]);
}
