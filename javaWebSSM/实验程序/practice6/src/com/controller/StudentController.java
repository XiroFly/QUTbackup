package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.StudentTable;
import com.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		return studentService.toAdd(model);
	}
	@RequestMapping("/add")
	public String add( @ModelAttribute("student") StudentTable student, Model model) {
		return studentService.add(model, student);
	}
	@RequestMapping("/allStudent")
	public String allStudent(Model model) {
		return studentService.allStudent(model);
	}
}
