package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 畅均江 on 2018/8/28.
 */
@Service
@Transactional
public class AdminServiceImple implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Admin find(String username, String password) {
        Admin admin = adminDao.select(username, password);
        if(admin==null){
            return null;
        }else {
            return admin;
        }
    }

    @Override
    public void add(Admin admin) {
        adminDao.insert(admin);
    }

    @Override
    public void amend(String password) {
        adminDao.update(password);
    }
}
