package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
}
