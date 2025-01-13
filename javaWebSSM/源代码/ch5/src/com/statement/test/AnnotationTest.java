package com.statement.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.statement.controller.StatementController;
public class AnnotationTest {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("/com/statement/xml/annotationstatementapplicationContext.xml");
		StatementController ct = (StatementController)appCon.getBean("statementController");
		String result = ct.test();
		System.out.println(result);
	}
}
