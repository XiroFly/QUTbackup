package com.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.StudentTable;
@Repository
public interface StudentTableDao {
	int addStudent(StudentTable student);
	List<StudentTable> allStudent();
}
