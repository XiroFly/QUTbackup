package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.UserTableDao;
import com.entity.UserTable;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserTableDao userTableDao;
	@RequestMapping("/register")
	public String register(Model model, UserTable user) {
		if(userTableDao.register(user) > 0)
			return "login";
		return "register";
	}
	@RequestMapping("/login")
	public String login(Model model, UserTable user, HttpSession session) {
		if(userTableDao.login(user).size() > 0) {
			session.setAttribute("u", user);
			return "main";
		}
		model.addAttribute("messageError", "用户名或密码错误");
		return "login";
	}
}
