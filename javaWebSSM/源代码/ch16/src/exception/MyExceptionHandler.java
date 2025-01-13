package exception;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
public class MyExceptionHandler implements HandlerExceptionResolver {
	@Override
public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		   	Map<String, Object> model = new HashMap<String, Object>();  
	        model.put("ex", arg3);    
	        // 根据不同错误转向不同页面（统一处理），即异常与view的对应关系  
	        if(arg3 instanceof MyException) {  
	            return new ModelAndView("my-error", model);  
	        }else if(arg3 instanceof SQLException) {  
	            return new ModelAndView("sql-error", model);  
	        } else {  
	            return new ModelAndView("error", model);  
	        }  
	}
}
