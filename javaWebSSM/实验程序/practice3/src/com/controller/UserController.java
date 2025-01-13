package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.service.UserService;
@Controller
public class UserController{
	@Autowired
	private UserService userService;
	public void test() {
		userService.test();
	}
}
