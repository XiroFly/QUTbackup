package com.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("userDao ")
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int save(String sql, Object[] param) {
		return jdbcTemplate.update(sql,param);
	}
	@Override
	public int delete(String sql, Object[] param) {
		return jdbcTemplate.update(sql,param);
	}
}
