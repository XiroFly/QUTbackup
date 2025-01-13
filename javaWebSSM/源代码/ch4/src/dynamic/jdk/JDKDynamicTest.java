package dynamic.jdk;
public class JDKDynamicTest {
	public static void main(String[] args) {
		//创建代理对象
		JDKDynamicProxy jdkProxy = new JDKDynamicProxy();
		//创建目标对象
		TestDao testDao = new TestDaoImpl();
		//从代理对象中获取增强后的目标对象，该对象是一个被代理的对象，它会进入代理的逻辑方法invoke里
		TestDao testDaoAdvice = (TestDao)jdkProxy.createProxy(testDao);
		//执行方法
		testDaoAdvice.save();
		System.out.println("==============");
		testDaoAdvice.modify();
		System.out.println("==============");
		testDaoAdvice.delete();
	}
}
