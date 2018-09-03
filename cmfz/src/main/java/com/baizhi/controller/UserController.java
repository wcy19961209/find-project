package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 畅均江 on 2018/9/3.
 */
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    /*查询*/
    @RequestMapping("/findUser")
    public Object findUser(Integer id){
        User user = userService.find(id);
        return user;
    }
    /*修改*/
    @RequestMapping("/modifyUser")
    public void modifyUser(User user){
        userService.modify(user);
    }

    /*全查*/
    @RequestMapping("/quertyAllUser")
    public List<User> quertyAllUser(){
        List<User> list = userService.quertyAll();
        return list;
    }

    /*全部导入*/
    @RequestMapping("/iopImportUser")
    public void iopImportUser(MultipartFile execl, HttpServletRequest request) throws Exception {
        userService.iopImportUserservice(execl,request);
    }
}
