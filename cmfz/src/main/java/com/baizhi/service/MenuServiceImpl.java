package com.baizhi.service;


import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
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
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDao menuDao;
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Menu> quertyAll() {
        List<Menu> all = menuDao.findAll();
        if(all==null){
            return null;
        }else{
            return all;
        }
    }
}
