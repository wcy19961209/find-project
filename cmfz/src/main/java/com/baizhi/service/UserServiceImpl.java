package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by 畅均江 on 2018/9/3.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User find(Integer id) {
        User user = userDao.select(id);
        if(user==null){
            return null;
        }else{
            return user;
        }
    }

    @Override
    public void modify(User user) {
        userDao.Update(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> quertyAll() {
        List<User> users = userDao.squertyAll();
        if(users==null){
            return null;
        }else {
            return users;
        }
    }

    /*全部导入*/
    public void iopImportUserservice(MultipartFile execl, HttpServletRequest request) throws Exception {
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
        String originalFilename = execl.getOriginalFilename();
        /*获取文件的名字*/
        String uuid = UUID.randomUUID().toString();
        /*文件格式格式*/
        String extension = FilenameUtils.getExtension(originalFilename);
        /*拼接新创建的文件格式名字*/
        String newName=uuid+"."+extension;
        /*图片上传到指定的文件夹*/
        try {
            execl.transferTo(new File(uplodFilePath,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*读取表文件*/
        Workbook workbook = new HSSFWorkbook(new FileInputStream(file.getPath()+"/"+newName));
        /*根据获取表的对象*/
        Sheet sheet = workbook.getSheet("uuid");

        List<User> users=new ArrayList<>();
        /*根据表列获取表的单元内容*/
        for (int i=1;i<sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            String iid = row.getCell(0).getStringCellValue();
            String photoimg = row.getCell(1).getStringCellValue();
            String name = row.getCell(2).getStringCellValue();
            String dharmaName = row.getCell(3).getStringCellValue();
            String sex = row.getCell(4).getStringCellValue();
            String province = row.getCell(5).getStringCellValue();
            String city = row.getCell(6).getStringCellValue();
            String sign = row.getCell(7).getStringCellValue();
            String phoneNum = row.getCell(8).getStringCellValue();
            String password = row.getCell(9).getStringCellValue();
            String salt = row.getCell(10).getStringCellValue();
            String status = row.getCell(11).getStringCellValue();
            Date regisDate = row.getCell(12).getDateCellValue();
            String guru_id = row.getCell(13).getStringCellValue();
            Integer id = Integer.valueOf(iid);
            Integer guru_ida = Integer.valueOf(guru_id);
            User user = new User(id,photoimg, dharmaName,name,sex,province,city, sign, phoneNum, password, salt, status, regisDate,
                    guru_ida);

            users.add(user);
        }

        /*导入数据库*/


    }


}
