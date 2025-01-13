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
@WebServlet("/findModifyStudent")
public class FindModifyStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDAO studentDAO=new StudentDAOImpl();
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentDAO.findStudentById(id);
        req.setAttribute("student",student);
        req.getRequestDispatcher("modifyStudent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
