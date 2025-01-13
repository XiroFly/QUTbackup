package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.dao.StudentTableDao;
import com.entity.StudentTable;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentTableDao studentTableDao;
	@Override
	public String toAdd(Model model) {
		String dept[] = { "日语学院", "计算机学院", "英语学院", "马克思主义学院", "其它" };
		model.addAttribute("dept", dept);
		StudentTable student = new StudentTable();
		student.setSex("男");//默认选中
		model.addAttribute("student", student);
		return "addInput";
	}
	@Override
	public String add(Model model, StudentTable student) {
		if(student.getAge() < 18) {//添加失败
			String dept[] = { "日语学院", "计算机学院", "英语学院", "马克思主义学院", "其它" };
			model.addAttribute("dept", dept);
			return "addInput";
		}else {
			studentTableDao.addStudent(student);
			return "forward:/student/allStudent";//回到查询的控制器方法
		}
	}
	@Override
	public String allStudent(Model model) {
		model.addAttribute("allStus", studentTableDao.allStudent());
		return "result";
	}

}
