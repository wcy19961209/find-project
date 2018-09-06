package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    /*修改状态*/
    @RequestMapping("/status")
    public void modifyStatus(String status,Integer id){
        userService.modifystatus(status,id);
    }

    /*全部导入*/
    @RequestMapping("/iopImportUser")
    public void iopImportUser(MultipartFile execll, HttpServletRequest request) throws Exception {
            /*找到文件webapp的路径*/
        String realPath = request.getServletContext().getRealPath("/");
        /*文件的路径*/
        String uplodFilePath=realPath+"exexl";
        /*文件对象*/
        File file =new File(uplodFilePath);
        /*是否有这个文件*/
        if(!file.exists()){
            file.mkdir();
        }
        String originalFilename = execll.getOriginalFilename();
        /*获取文件的名字*/
        String uuid = UUID.randomUUID().toString();
        /*文件格式格式*/
        String extension = FilenameUtils.getExtension(originalFilename);
        /*拼接新创建的文件格式名字*/
        String newName=uuid+"."+extension;
        /*图片上传到指定的文件夹*/
        try {
            execll.transferTo(new File(uplodFilePath,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        userService.iopImportUserservice(file,originalFilename,newName);
    }

    /*全部导出*/
    @RequestMapping("/iopExport")
    public void iopExport(){
            userService.iopExportUserservice();
    }


    /*自定义导出*/
    @RequestMapping("/customerExport")
    public void customerExport(String titles, String params,HttpServletResponse response) {
        userService.customerExportService(titles,params,response);
    }
}
