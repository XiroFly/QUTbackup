package dao;

import vo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    DataSourceBean dataSourceBean =new DataSourceBean();
    int pageSize=2;
    @Override
    public boolean addStudent(Student student) {
        String sql="INSERT INTO  student  values (?,?,?,?,?);";
        try {
            Connection conn = dataSourceBean.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,student.getId());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3, student.getSex());
            preparedStatement.setString(4, student.getMajor());
            preparedStatement.setString(5, student.getHometown());
            preparedStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public Student findStudentById(Integer id) {
        Student student=new Student();
        String sql="SELECT * FROM student  where id=?";
        try {
            Connection conn = dataSourceBean.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSex(resultSet.getString("sex"));
                student.setMajor(resultSet.getString("major"));
                student.setHometown(resultSet.getString("hometown"));
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    @Override
    public List<Student> findAllStudentByPage(Integer pageNo)
    {
        int beginIndex =(pageNo-1)*pageSize;
        String sql="SELECT * FROM student limit ? OFFSET ?;";
        List<Student> studentList=new ArrayList<>();
        try {
            Connection conn =dataSourceBean.getConnection();
            PreparedStatement preparedStatement =conn.prepareStatement(sql);
            preparedStatement.setInt(1,2);
            preparedStatement.setInt(2,beginIndex);
            ResultSet resultSet = preparedStatement.executeQuery();
           while(resultSet.next()){
               Student student=new Student();
               student.setId(resultSet.getInt("id"));
               student.setName(resultSet.getString("name"));
               student.setSex(resultSet.getString("sex"));
               student.setMajor(resultSet.getString("major"));
               student.setHometown(resultSet.getString("hometown"));
               studentList.add(student);
           }
        conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public boolean modifyStudent(Student student) {
        String sql="update  student set name=?,sex=?,major=?,hometown=? where id=? ;";
        try {
            Connection conn = dataSourceBean.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(5,student.getId());
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setString(4, student.getHometown());
            preparedStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    @Override
    public boolean deleteStudentById(Integer id) {
        String sql="delete  from student  where id=? ;";
        try {
            Connection conn = dataSourceBean.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }



    @Override
    public Integer findPageCount() {
        int totalStudentCount=0;
        String sql="SELECT count(*) FROM student;";
        try {
            Connection conn =dataSourceBean.getConnection();
            PreparedStatement preparedStatement =conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
               totalStudentCount=resultSet.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (totalStudentCount+1)/pageSize;
    }
}
