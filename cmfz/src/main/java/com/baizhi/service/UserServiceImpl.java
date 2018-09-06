package com.baizhi.service;

import com.baizhi.asprct.LogAnnotation;
import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    @LogAnnotation(name="用户修改")
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

    @Override
    @LogAnnotation(name="用户修改状态")
    public void modifystatus(String status,Integer id) {
        userDao.UpdateUser(status,id);
    }

    /*全部导入*/
    @LogAnnotation(name="用户全部导入")
    public void iopImportUserservice(File file,String originalFilename,String newName) throws IOException {
        /*读取表文件*/
        Workbook workbook = new HSSFWorkbook(new FileInputStream(file.getPath()+"/"+newName));
        /*根据获取表的对象*/
        Sheet sheet = workbook.getSheet("emp");
        List<User> users=new ArrayList<>();
        /*根据表列获取表的单元内容*/
        for (int i=1;i<sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            cell.setCellType(CellType.STRING);
            String iid = cell.getStringCellValue();
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
            Cell cell1 = row.getCell(13);
            cell1.setCellType(CellType.STRING);
            String guru_id = cell1.getStringCellValue();
            Integer id = Integer.valueOf(iid);
            Integer guru_ida = Integer.valueOf(guru_id);
            User user = new User(id,photoimg, dharmaName,name,sex,province,city, sign, phoneNum, password, salt, status, regisDate,
                    guru_ida);

            users.add(user);

        }
        /*导入数据库*/

        for (User user: users) {
            userDao.insert(user);
        }



    }
/*全部导出*/
    @Override
    @LogAnnotation(name="用户全部导出")
    public void iopExportUserservice(){
        /*创建工作薄对象*/
        Workbook workbook = new HSSFWorkbook();
        /*创建工作表对象*/
        Sheet sheet = workbook.createSheet("emp");
        /* 第一个参数 第几列  第二个参数  列宽*/
        sheet.setColumnWidth(2, 26 * 256);
        /*创建行   参数：行下标*/
        Row row = sheet.createRow(0);
        /*修改日期样式*/
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd天");
        CellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1.setDataFormat(format);
        /*创建单元格样式*/
        CellStyle cellStyle = workbook.createCellStyle();
        /*居中*/
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
         /*修改字体*/
        Font font = workbook.createFont();
        font.setFontName("楷体");
        font.setBold(true);
        font.setColor(Font.COLOR_RED);
        font.setItalic(true);
        cellStyle.setFont(font);
        String[] strs = {"编号", "头像", "姓名","法名","性别","省份","城市","签名","手机号","密码","盐值","状态","注册日期","上师的id"};
        for (int i = 0; i < strs.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(strs[i]);
        }
        /*数据行  查询数据库*/
        List<User> users = userDao.squertyAll();
        for (int i = 0; i < users.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(users.get(i).getId());
            row1.createCell(1).setCellValue(users.get(i).getPhotoimg());
            row1.createCell(2).setCellValue(users.get(i).getName());
            row1.createCell(3).setCellValue(users.get(i).getDharmaName());
            row1.createCell(4).setCellValue(users.get(i).getSex());
            row1.createCell(5).setCellValue(users.get(i).getProvince());
            row1.createCell(6).setCellValue(users.get(i).getCity());
            row1.createCell(7).setCellValue(users.get(i).getSign());
            row1.createCell(8).setCellValue(users.get(i).getPhoneNum());
            row1.createCell(9).setCellValue(users.get(i).getPassword());
            row1.createCell(10).setCellValue(users.get(i).getSalt());
            row1.createCell(11).setCellValue(users.get(i).getStatus());
            /*日期格式*/
            Cell cell = row1.createCell(12);
            cell.setCellStyle(cellStyle1);
            cell.setCellValue(users.get(i).getRegisDate());
            row1.createCell(13).setCellValue(users.get(i).getGuru_id());
        }
        /*写出*/
        try {
            workbook.write(new FileOutputStream(new File("emp.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
/*自定义导入*/
    @Override
    @LogAnnotation(name="用户自定义导入")
    public void customerExportService(String titles, String params, HttpServletResponse response) {
        Workbook workbook = new HSSFWorkbook();
        //字体样式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        /*标题行*/
        Sheet sheet = workbook.createSheet("emp");
        Row row = sheet.createRow(0);
        String[] strs = titles.split(",");
        for (int i = 0; i < strs.length; i++) {
            row.createCell(i).setCellValue(strs[i]);
        }
        /*数据行*/
        String[] fileds = params.split(",");
        List<User> Emp = userDao.squertyAll();
        for (int i = 0; i < Emp.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            User user = Emp.get(i);
            /*获取类对象*/
            Class<? extends User> aClass = user.getClass();
            for (int j = 0; j < fileds.length; j++) {
                Cell cell = row1.createCell(j);
                /*获得方法名*/
                String methodName = "get" + fileds[j].substring(0, 1).toUpperCase() + fileds[j].substring(1);
                /*获取调用的方法对象*/
                try {
                    Method method = aClass.getMethod(methodName, null);
                    Object invoke = method.invoke(user, null);
                    if (invoke instanceof Date) {
                        sheet.setColumnWidth(j,21*256);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((Date) invoke);
                    } else if(invoke instanceof Integer){
                        cell.setCellValue((Integer) invoke);

                    }else {
                        cell.setCellValue((String) invoke);

                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                 /*创建单元格并且填充内容*/
            }
        }
        String a = new Date().getTime() + "empExcel.xls";
        String newName = null;
        try {
            newName = new String(a.getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;filename=" + newName);
        response.setContentType("application/vnd.ms-excel");

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}






