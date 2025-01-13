package com.ch5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TransactionTemplateTest {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		TransactionTemplateDao ct = (TransactionTemplateDao)appCon.getBean("transactionTemplateDao");
		String result = ct.test();
		System.out.println(result);
	}
}
