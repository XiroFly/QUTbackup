package com.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.dao.UserDao;
import com.po.MyUser;
@Controller("userController")
public class UserController {
	@Autowired
	private UserDao userDao;
	public void test() {
		/**
		//查询一个用户
		MyUser auser = userDao.selectUserById(1);
		System.out.println(auser);
		System.out.println("================");
		//添加一个用户
		MyUser addmu = new MyUser();
		addmu.setUname("陈恒");
		addmu.setUsex("男");
		int add = userDao.addUser(addmu);
		System.out.println("添加了" + add + "条记录");
		System.out.println("================");
		//修改一个用户
		MyUser updatemu = new MyUser();
		updatemu.setUid(1);
		updatemu.setUname("张三");
		updatemu.setUsex("女");
		int up = userDao.updateUser(updatemu);
		System.out.println("修改了" + up + "条记录");
		System.out.println( "================");
		//删除一个用户
		int dl = userDao.deleteUser(9);
		System.out.println("删除了" + dl + "条记录");
		System.out.println("================");
		//查询所有用户
		List<MyUser> list = userDao.selectAllUser();
		for (MyUser myUser : list) {
			System.out.println(myUser);
		}**/
		//使用if元素查询用户信息
		MyUser ifmu = new MyUser();
		ifmu.setUname("张");
		ifmu.setUsex("女");
		List<MyUser> listByif = userDao.selectUserByIf(ifmu);
		System.out.println("if元素================");
		for (MyUser myUser : listByif) {
			System.out.println(myUser);
		}
		//使用choose元素查询用户信息
		MyUser choosemu = new MyUser();
		choosemu.setUname("");
		choosemu.setUsex("");
		List<MyUser> listByChoose = userDao.selectUserByChoose(choosemu);
		System.out.println("choose元素================");
		for (MyUser myUser : listByChoose) {
			System.out.println(myUser);
		}
		//使用trim元素查询用户信息
		MyUser trimmu = new MyUser();
		trimmu.setUname("张");
		trimmu.setUsex("男");
		List<MyUser> listByTrim = userDao.selectUserByTrim(trimmu);
		System.out.println("trim元素================");
		for (MyUser myUser : listByTrim) {
			System.out.println(myUser);
		}
		//使用where元素查询用户信息
		MyUser wheremu = new MyUser();
		wheremu.setUname("张");
		wheremu.setUsex("男");
		List<MyUser> listByWhere = userDao.selectUserByWhere(wheremu);
		System.out.println("where元素================");
		for (MyUser myUser : listByWhere) {
			System.out.println(myUser);
		}
		//使用set元素修改一个用户
		MyUser setmu = new MyUser();
		setmu.setUid(1);
		setmu.setUname("张九");
		int setup = userDao.updateUserBySet(setmu);
		System.out.println("set元素修改了" + setup + "条记录");
		System.out.println( "================");
		//使用foreach元素，查询用户信息
		List<Integer> listId = new ArrayList<Integer>();
		listId.add(34);
		listId.add(37);
		List<MyUser> listByForeach = userDao.selectUserByForeach(listId);
		System.out.println("foreach元素================");
		for (MyUser myUser : listByForeach) {
			System.out.println(myUser);
		}
		//使用bind元素查询用户信息
		MyUser bindmu = new MyUser();
		bindmu.setUname("张");
		List<MyUser> listByBind = userDao.selectUserByBind(bindmu);
		System.out.println("bind元素================");
		for (MyUser myUser : listByBind) {
			System.out.println(myUser);
		}
	}
}
