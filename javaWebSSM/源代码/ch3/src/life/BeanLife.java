package life;
public class BeanLife {
	public void initMyself() {
		System.out.println(this.getClass().getName() + "执行自定义的初始化方法");
	}
	public void destroyMyself() {
		System.out.println(this.getClass().getName() +"执行自定义的销毁方法");
	}
}
