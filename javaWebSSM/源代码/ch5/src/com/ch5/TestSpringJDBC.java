package com.ch5;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestSpringJDBC {
	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器中，获取增强后的目标对象
		TestDao td = (TestDao)appCon.getBean("testDao");
		String insertSql = "insert into user values(null,?,?)";
		//数组param的值与insertSql语句中?一一对应
		Object param1[] = {"chenheng1", "男"};
		Object param2[] = {"chenheng2", "女"};
		Object param3[] = {"chenheng3", "男"};
		Object param4[] = {"chenheng4", "女"};
		//添加用户
		td.update(insertSql, param1);
		td.update(insertSql, param2);
		td.update(insertSql, param3);
		td.update(insertSql, param4);
		//查询用户
		String selectSql ="select * from user";
		List<MyUser> list = td.query(selectSql, null);
		for(MyUser mu : list) {
			System.out.println(mu);
		}
	}
}
