package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 畅均江 on 2018/8/28.
 */
@Controller
@RequestMapping("/text")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/find")
    private String findAll(String username,String password){

        Admin admin = adminService.find(username, password);

        return "";
    }

}
