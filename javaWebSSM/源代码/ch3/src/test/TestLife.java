package test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import life.BeanLife;
public class TestLife {
	public static void main(String[] args) {
		//初始化Spring容器，加载配置文件
		//为了方便演示销毁方法的执行，这里使用ClassPathXmlApplicationContext实现类声明容器
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("获得对象前");
		BeanLife blife = (BeanLife)ctx.getBean("beanLife");
		System.out.println("获得对象后" + blife);
		ctx.close();//关闭容器，销毁Bean对象
	}
}
