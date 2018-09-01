package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * Created by 畅均江 on 2018/8/29.
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/findAll")
    public List<Banner> findAll(){
        List<Banner> banners = bannerService.quertyAll();
        return banners;
    }


    @RequestMapping("/Add")
    public void add(Banner banner, MultipartFile img, HttpServletRequest request) throws ParseException {
        /*找到文件的路径*/
        String realPath = request.getServletContext().getRealPath("/");
        /*文件中的文件*/
        String uplodFilePath=realPath+"upload";
        /*文件对象*/
        File file =new File(uplodFilePath);
        if(!file.exists()){
            file.mkdir();
        }
        String originalFilename = img.getOriginalFilename();
        /*获取文件的名字*/
        String uuid = UUID.randomUUID().toString();
        /*jpg格式*/
        String extension = FilenameUtils.getExtension(originalFilename);
        /*拼接新创建的文件格式名字*/
        String newName=uuid+"."+extension;

        /*图片上传到指定的文件夹*/
        try {
            img.transferTo(new File(uplodFilePath,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        banner.setImgPath(newName);
        bannerService.add(banner);
    }

    @RequestMapping("remove")
    public void remove(Integer id){
        bannerService.remove(id);
    }

    @RequestMapping("remand")
    public void remand(String status,Integer id){
        bannerService.remand(status,id);
    }
}
