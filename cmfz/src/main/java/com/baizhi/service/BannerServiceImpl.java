package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 畅均江 on 2018/8/29.
 */
@Service
@Transactional
public class BannerServiceImpl implements BannerService{
    @Autowired
    private BannerDao bannerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<com.baizhi.entity.Banner> quertyAll() {
        List<com.baizhi.entity.Banner> list = bannerDao.findAll();
        if(list==null){
            return null;
        }else{
                return list;
                }
    }

    @Override
    public void add(com.baizhi.entity.Banner banner) {
            bannerDao.insert(banner);
    }

    @Override
    public void remove(Integer id) {
            bannerDao.delete(id);
    }

    @Override
    public void remand(String status,Integer id) {
            bannerDao.Update(status,id);
    }
}
