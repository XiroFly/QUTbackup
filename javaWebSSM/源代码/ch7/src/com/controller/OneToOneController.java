package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.dao.PersonDao;
import com.po.Person;
import com.pojo.SelectPersonById;
@Controller("oneToOneController")
public class OneToOneController {
	@Autowired
	private PersonDao personDao;
	public void test() {
		Person p1 = personDao.selectPersonById1(1);
		System.out.println(p1);
		System.out.println("=======================");
		Person p2 = personDao.selectPersonById2(1);
		System.out.println(p2);
		System.out.println("=======================");
		SelectPersonById p3 = personDao.selectPersonById3(1);
		System.out.println(p3);
	}
}
