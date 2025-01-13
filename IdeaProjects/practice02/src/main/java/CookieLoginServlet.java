
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/CookieLoginServlet")

public class CookieLoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
        response.setContentType("text/html;charset=UTF-8");
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        String isSaved= request.getParameter("isSaved");
        if(username==null||password==null)throw new ServletException();
        Cookie loginCookie=new Cookie("username",username);
        if(isSaved.equals("1")){
            loginCookie.setMaxAge(60*60*24*7);
        }
        response.addCookie(loginCookie);
        HttpSession session= request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",password);
        response.sendRedirect(basePath+"/loginPage/welcome.jsp");
        //设置输出编码为utf-8

        //获得请求参数username及isSaved的值


        //如果isSaved值为1，创建cookie，设置7天有效期并返回客户端

        //将username放到session中

        //重定向到welcome.jsp页面

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
        //同doGet
    }



}
