package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.UserTable;

@Repository
public interface UserTableDao {
	int register(UserTable user);
	List<UserTable> login(UserTable user);
}
