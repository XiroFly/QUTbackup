import Javabean.DatabaseJavabean;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddOrDelServlet")
public class AddOrDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String mode=request.getParameter("mode");String index=request.getParameter("index");
    response.setContentType("text/html;charset=UTF-8");
        HttpSession session= request.getSession();
        DatabaseJavabean database= (DatabaseJavabean)session.getAttribute("database");
        PrintWriter writer = response.getWriter();
    if(mode.equals("1")){//添加
        if(!database.isExistence(index)){
            database.setDispalyingDatas(index);
        }
        else{
            writer.write(
                    "<h3>你已经选择了"+database.showDispalyingData(index)+"</h3><br/>");

        }
    }

    else{//删除
        database.deleteDispalyingDatas(index);
    }
    writer.write("<div>yours choice</div>");
        for(String i: database.getDispalyingDatas()){//description
            writer.write("<div>"+database.showDispalyingData(i)+"</div><br/>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);
    }
}
