package com.baizhi.service;


import com.baizhi.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by 畅均江 on 2018/9/3.
 */

public interface UserService {
    User find(Integer id);
    void modify(User user);
    List<User> quertyAll();
    /*全部导入*/
    void iopImportUserservice(MultipartFile execl, HttpServletRequest request) throws Exception;
}
