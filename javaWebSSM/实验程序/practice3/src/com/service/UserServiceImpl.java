package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.UserDao;
@Service("userService")
@Transactional
//加上注解@Transactional,就可以指定这个类需要受Spring的事务管理
//注意@Transactional只能针对public属性范围内的方法添加
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public void test() {
		String deleteSql ="delete from user";
		String saveSql = "insert into user values(?,?,?)";
		Object param[] = {1,"chenheng","男"};
		userDao.delete(deleteSql, null);
		userDao.save(saveSql, param);
		//插入两条主键重复的数据
		userDao.save(saveSql, param);
	}
}
