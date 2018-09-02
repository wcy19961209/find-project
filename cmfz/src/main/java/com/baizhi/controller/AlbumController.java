package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import com.baizhi.util.Mp3Util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
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
          /*找到文件webapp的路径*/
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
        /*文件格式格式*/
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
    @RequestMapping("/chateradd")
    public void chapteradd(Integer alubum_id,String name,MultipartFile audioPath,HttpServletRequest request){
        String realPath = request.getServletContext().getRealPath("/");
        String uplodFilePath=realPath+"music";
        /*获取文件的字段名称*/
        String originalFilename = audioPath.getOriginalFilename();
        /*生成唯一的名字 防止重名*/
        String uuid = UUID.randomUUID().toString();
        /*获取文件对象的后缀*/
        String extension = FilenameUtils.getExtension(originalFilename);
        /*拼接*/
        String newName=uuid+"."+extension;

        try {
            audioPath.transferTo(new File(uplodFilePath,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*获取时长*/
        File file1=new File(uplodFilePath+"/"+newName);
        String duration = Mp3Util.getDuration(file1);

        /*获取大小*/
        long size = audioPath.getSize();
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数
        String format = df.format((float) size/1024/1024);

        Chapter chapter = new Chapter();
        chapter.setSize(format+"MB");
        chapter.setId(uuid);
        chapter.setAlbum_id(alubum_id);
        chapter.setAudioPath(newName);
        chapter.setDuration(duration);
        chapter.setName(name);

        albumService.chapteradd(chapter);
    }

    /*下载音频*/
    @RequestMapping("/chaptercontroller")
    public void chaptercontroller(String name, String audioPath, HttpServletRequest request, HttpServletResponse response){
        String realPath = request.getServletContext().getRealPath("/");
        String filePath=realPath+"music/"+audioPath;
        File file = new File(filePath);
        String extension = FilenameUtils.getExtension(audioPath);
        name=name+"."+extension;
        String a=null;
        try {
            a=new String(name.getBytes("UTF-8"),"ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");
        response.setHeader("Content-Disposition", "attachment;filename=" + a);

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(file));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
