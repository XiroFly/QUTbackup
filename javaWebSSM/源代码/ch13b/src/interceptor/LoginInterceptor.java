package interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的URL
		String url = request.getRequestURI();
		//login.jsp或登录请求放行，不拦截
		if(url.indexOf("/toLogin") >= 0 || url.indexOf("/login") >= 0) {
			return true;
		}
		//获取Session
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		if(obj != null)
			return true;
		//没有登录且不是登录页面，转发到登录页面，并给出提示错误信息
		request.setAttribute("msg", "还没登录，请先登录！");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}
}
