package com.baizhi.service;


import com.baizhi.entity.User;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by 畅均江 on 2018/9/3.
 */

public interface UserService {
    User find(Integer id);
    void modify(User user);
    List<User> quertyAll();
    void modifystatus(String status,Integer id);
    /*全部导入*/
    void iopImportUserservice(File file, String newName, String originalFilename) throws IOException;
    /*全部导出*/
    void iopExportUserservice();
    /*自定义导出*/
    void customerExportService(String titles, String params,HttpServletResponse response);
}
