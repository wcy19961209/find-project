package com.baizhi.dao;


import com.baizhi.entity.Album;
import org.springframework.stereotype.Component;
import com.baizhi.entity.Chapter;
import java.util.List;

/**
 * Created by 畅均江 on 2018/8/30.
 */

@Component
public interface AlbumDao {
    /*全查*/
    List<Album> findAll();
    /*添加专辑*/
    void insert(Album album);
    /*添加章节*/
    void chapterinsert(Chapter chapter);
    /*id专辑查询*/
    Album select(Integer id);
}
