package dao;

import vo.Student;

import java.util.List;

public interface StudentDAO {
     public boolean addStudent(Student student);
     public Student findStudentById(Integer id);
     public List<Student> findAllStudentByPage(Integer pageNo);
public boolean modifyStudent(Student student);
public boolean deleteStudentById(Integer id);


     Integer findPageCount();
}
