package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by 畅均江 on 2018/8/30.
 */
@RestController
@RequestMapping("/Album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping("/findAll")
    public List<Album> findAll(){
        return albumService.quertyAll();
    }

    /*添加专辑*/
    @RequestMapping("/add")
    public void add(Album album){
        albumService.add(album);
    }
}
