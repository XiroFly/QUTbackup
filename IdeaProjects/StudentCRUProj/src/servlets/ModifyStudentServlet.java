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
import java.sql.Connection;

@WebServlet("/modifyStudent")
public class ModifyStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setId(Integer.parseInt(req.getParameter("id")));
        student.setName(req.getParameter("name"));
        student.setSex(req.getParameter("sex"));
        student.setMajor(req.getParameter("major"));
        student.setHometown(req.getParameter("hometown"));
        StudentDAO studentDAO=new StudentDAOImpl();
        req.setAttribute("MOF",studentDAO.modifyStudent(student));
        req.getRequestDispatcher("showAllStudents").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
