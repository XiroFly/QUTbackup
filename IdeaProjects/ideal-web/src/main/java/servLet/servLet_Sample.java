package servLet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//用注解添加url
@WebServlet("/flys")
public class servLet_Sample implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    //访问时自动执行
        System.out.println("Fly-servLet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
