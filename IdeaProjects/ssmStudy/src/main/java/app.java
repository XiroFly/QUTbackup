import com.itheima.dao.impl.myDaoimpl;
import com.itheima.dao.myDao;
import com.itheima.service.impl.myServiceImpl;
import com.itheima.service.myService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class app {
    public static void  main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        myService service= (myService) ctx.getBean("myService");
        Object myDao = ctx.getBean("myDao");
        myDao dynamicFactory = (myDao) ctx.getBean("dynamicFactory");
        System.out.println(dynamicFactory);
        System.out.println(myDao);
//        service.test1();
    }




}
