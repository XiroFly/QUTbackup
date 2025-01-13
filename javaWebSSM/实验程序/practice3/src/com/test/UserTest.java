package com.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.controller.UserController;
public class UserTest{
	public static void main(String[] args) {
		ApplicationContext appCon = 
new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController uc= (UserController)appCon.getBean("userController");
		uc.test();
	}
}
