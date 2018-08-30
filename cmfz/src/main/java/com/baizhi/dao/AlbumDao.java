package com.baizhi.dao;


import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by 畅均江 on 2018/8/30.
 */
public interface AlbumDao {
    /*全查*/
    List<Album> findAll();
    /*添加专辑*/
    void insert(Album album);
}
