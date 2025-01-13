package service;

import dao.TestDIDao;

public class TestDIServiceImpl1 implements TestDIService{
	private TestDIDao testDIDao;
	//添加testDIDao属性的setter方法，用于实现依赖注入
	public void setTestDIDao(TestDIDao testDIDao) {
		this.testDIDao = testDIDao;
	}
	@Override
	public void sayHello() {
		//调用testDIDao中的sayHello方法
		testDIDao.sayHello();
		System.out.println("TestDIService setter方法注入  say: Hello, Study hard!");
	}

}
