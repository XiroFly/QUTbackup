package com.service;

import org.springframework.ui.Model;

import com.entity.StudentTable;

public interface StudentService {
	public String toAdd(Model model);
	public String add(Model model, StudentTable student);
	public String allStudent(Model model);
}
