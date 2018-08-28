package com.baizhi.service;

import com.baizhi.entity.Admin;

/**
 * Created by 畅均江 on 2018/8/28.
 */
public interface AdminService {
    Admin find(String username,String password);
    void add(Admin admin);
}
