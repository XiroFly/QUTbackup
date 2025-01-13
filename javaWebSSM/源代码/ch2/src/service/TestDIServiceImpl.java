package service;
import dao.TestDIDao;
public class TestDIServiceImpl implements TestDIService{
	private TestDIDao testDIDao;
	//构造方法，用于实现依赖注入
	public TestDIServiceImpl(TestDIDao testDIDao) {
		super();
		this.testDIDao = testDIDao;
	}
	@Override
	public void sayHello() {
		//调用testDIDao中的sayHello方法
		testDIDao.sayHello();
		System.out.println("TestDIService 构造方法 注入  say: Hello, Study hard!");
	}
}
