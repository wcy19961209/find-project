package com.baizhi.service;
import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by 畅均江 on 2018/8/30.
 */
public interface AlbumService {
    /*全查*/
    List<Album> quertyAll();
    /*添加专辑*/
    void add(Album album);
}
