<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    String cookieName = "username";
    String cookieValue = null;
    Cookie[] cookies = request.getCookies();
    if (cookies!=null){
        for(Cookie i:cookies){
            if(i.getName().equals(cookieName)){
                cookieValue=i.getValue();
                response.setContentType("text/html;charset=utf-8");
                PrintWriter outer=response.getWriter();
                outer.println("<html><title>欢迎</title>");
                outer.println("<body>");
                outer.println("欢迎"+cookieValue+"访问我们的简易访问系统<br>");

                outer.println("<a href='"+basePath+"/index.jsp'>开始选课</a>");
                outer.println("</body></html>");
            }

        }
    }
    else{
      response.sendRedirect(basePath+"/loginPage/login.jsp");
    }

    //从请求端读取cookies数组

    //如果cookies数组不为空，循环遍历数组
    //找到其中键为username的数组，获取其对应的值存储在字符串变量username中



    //如果username为空，重定向到login.jsp
    //否则显示“欢迎+username+访问我们的网站”
%>
