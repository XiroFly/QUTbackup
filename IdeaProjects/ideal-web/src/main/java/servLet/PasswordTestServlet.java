package servLet;


import javas.PasswordCheckUserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet({"/fly"})
@WebServlet("/fly")
public class PasswordTestServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException{


        String pwhead = request.getParameter("pwhead");
        String pwtail = request.getParameter("pwtail");
         String pw =request.getParameter("pw");
        // 创建模型对象
        PasswordCheckUserBean user = new PasswordCheckUserBean();

        // 调用业务方法进行验证
        boolean b = user.validate(pwhead,pwtail,pw);

        // 要转向的文件
        String forward;
        request.setAttribute("pwhead", pwhead);
        request.setAttribute("pwtail", pwtail);
        request.setAttribute("pw", pw);
        System.out.println("ascc");
//      PrintWriter out  = response.getWriter();
//      out.println("hahaha");
        // 如果登陆成功，把用户名写入session中，并且转向success.jsp，
// 否则转向failure.jsp
        if(b){

//         HttpSession session = request.getSession(true);
//         session.setAttribute("pwhead",pwhead);

            // 目标转向文件是success.jsp
            forward = "success.jsp";

        }else{

            // 目标转向文件是failure.jsp
            forward = "failure.jsp";

        }

        // 获取Dispatcher对象
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);

        // 完成跳转
        dispatcher.forward(request,response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException{
        doGet(request,response);
    }
}
