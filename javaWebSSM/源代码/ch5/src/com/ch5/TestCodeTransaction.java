package com.ch5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestCodeTransaction {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		CodeTransaction ct = (CodeTransaction)appCon.getBean("codeTransaction");
		String result = ct.test();
		System.out.println(result);
	}
}
