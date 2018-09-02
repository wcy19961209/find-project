package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by 畅均江 on 2018/8/28.
 */
@Controller
@RequestMapping("/text")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/findAll")
    public String findAll(String username, String password, HttpSession session,String enCode){

       String code = (String) session.getAttribute("code");
       if(enCode.equalsIgnoreCase(code)){
           Admin admin = adminService.find(username, password);
           if(admin==null){
               return "login";
           }else {
               /*登录标志*/
               session.setAttribute("Login","login");
               /*对象存入session*/
               session.setAttribute("admin",admin);
                return "main/main";
           }
       }else {
           return "login";
       }

    }
/*添加*/
    @RequestMapping("/admin")
    public String add(Admin admin){
        adminService.add(admin);
        return "main/main";
    }
    /*修改密码*/
    @RequestMapping("/amend")
    public String  amend(HttpSession session,String password){
        Admin admin = (Admin) session.getAttribute("admin");
        adminService.amend(password);
        return "login";
}

/*退出系统*/
    @RequestMapping("Rmover")
    public String Rmover(HttpSession serssion){
        serssion.removeAttribute("login");
        serssion.removeAttribute("admin");
        return "login";
    }
}
