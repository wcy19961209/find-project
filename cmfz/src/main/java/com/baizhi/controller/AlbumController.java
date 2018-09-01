package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by 畅均江 on 2018/8/30.
 */
@RestController
@RequestMapping("/Album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/find")
    public List<Album> findAll(){
        List<Album> list = albumService.quertyAll();


        return list;
    }

    /*添加专辑*/
    @RequestMapping("/dd")
    public void add(Album album, MultipartFile img,HttpServletRequest request){
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
        album.setCorverlmg(newName);
        albumService.add(album);
    }

    /*添加章节*/


}
