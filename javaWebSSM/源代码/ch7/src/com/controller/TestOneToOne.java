package com.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestOneToOne {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		OneToOneController oto = (OneToOneController)appCon.getBean("oneToOneController");
		oto.test();
	}
}
