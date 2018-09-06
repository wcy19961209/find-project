package com.baizhi.service;

import com.baizhi.asprct.LogAnnotation;
import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 畅均江 on 2018/8/30.
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Album> quertyAll() {
        List<Album> albums = albumDao.findAll();
        if(albums==null){
            return null;
        }else {
            return albums;
        }
    }

    @Override
    @LogAnnotation(name="专辑添加")
    public void add(Album album) {
        albumDao.insert(album);
    }

    @Override
    @LogAnnotation(name="章节添加")
    public void chapteradd(Chapter chapter) {
        albumDao.chapterinsert(chapter);
    }
}
