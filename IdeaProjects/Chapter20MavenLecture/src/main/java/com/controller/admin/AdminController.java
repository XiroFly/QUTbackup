package com.controller.admin;

import com.po.AUser;
import com.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/admin")
    public String toLogin(@ModelAttribute("auser") AUser aUser){
        return "admin/login";
    }

    @RequestMapping("/admin/login")
    public String login(AUser aUser, Model model){
        boolean loginSucc = adminService.isLogined(aUser);
        if(loginSucc){
            return "admin/main";
        }else{
            return "admin/login";
        }

    }
}
