package com.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestOneToMore {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		OneToMoreController otm = (OneToMoreController)appCon.getBean("oneToMoreController");
		otm.test();
	}
}
