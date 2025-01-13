package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMoreToMore {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		MoreToMoreController otm = (MoreToMoreController)appCon.getBean("moreToMoreController");
		otm.test();
	}
}
