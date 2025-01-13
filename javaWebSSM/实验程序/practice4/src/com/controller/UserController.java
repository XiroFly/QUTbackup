package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.dao.UserDao;
import com.po.MyUser;
@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	public void test() {
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
		}
		System.out.println("================");
		//查询id在（1,3,5,7,9,11）中的用户信息
		List<Integer> listId = new ArrayList<Integer>();
		listId.add(1);
		listId.add(3);
		listId.add(5);
		listId.add(7);
		listId.add(9);
		listId.add(11);
		List<MyUser> listById = userDao.selectUserByForeach(listId);
		for (MyUser myUser : listById) {
			System.out.println(myUser);
		}
	}
}
