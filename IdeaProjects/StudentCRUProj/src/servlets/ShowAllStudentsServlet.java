package servlets;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import vo.Student;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.PageContext;

@WebServlet(value = "/showAllStudents", initParams =@WebInitParam(name = "bpf", value = "hero") )
public class ShowAllStudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Integer pageNo =1;
       String page= req.getParameter("page");
       if(page!=null){
           pageNo=Integer.parseInt(page);
       }
        StudentDAO studentDAO=new StudentDAOImpl();
       List<Student> studentList=studentDAO.findAllStudentByPage(pageNo);
       Integer pageCount =studentDAO.findPageCount();
          req.setAttribute("studentList",studentList);
          req.setAttribute("pageCount",pageCount);
           System.out.println(getInitParameter("bpf"));
           System.out.print(getServletContext().getInitParameterNames());
          req.getRequestDispatcher("studentList.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
