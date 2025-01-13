package test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.TestDIService;
public class TestDI {
	public static void main(String[] args) {
		//初始化Spring容器ApplicationContext，加载配置文件
		ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过容器获取testDIService实例，测试构造方法 注入
		TestDIService ts = (TestDIService)appCon.getBean("testDIService");
		ts.sayHello();
		//通过容器获取testDIService实例，测试setter方法注入 
		TestDIService ts1 = (TestDIService)appCon.getBean("testDIService1");
		ts1.sayHello();
	}
}
