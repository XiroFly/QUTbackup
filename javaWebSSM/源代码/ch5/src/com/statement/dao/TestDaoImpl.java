package com.statement.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("TestDao")
public class TestDaoImpl implements TestDao{
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
