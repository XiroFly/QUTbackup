package servlets;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import vo.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showOneStudent")
public class ShowOneStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList=new ArrayList<>();
        StudentDAO studentDAO=new StudentDAOImpl();
        Integer id=Integer.parseInt( req.getParameter("id"));
        studentList.add( studentDAO.findStudentById(id));
        req.setAttribute("studentList",studentList);
        req.getRequestDispatcher("studentList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
