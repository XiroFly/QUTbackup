package spring.proxyfactorybean;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
 * 切面类
 */
public class MyAspect implements MethodInterceptor{
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		//增强方法
		check();
		except();
		//执行目标方法
		Object obj = arg0.proceed();
		//增强方法
		log();
		monitor();
		return obj;
	}
	public void check() {
		System.out.println("模拟权限控制");
	}
	public void except() {
		System.out.println("模拟异常处理");
	}
	public void log() {
		System.out.println("模拟日志记录");
	}
	public void monitor() {
		System.out.println("性能监测");
	}
}
