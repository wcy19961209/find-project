package com.baizhi.dao;

import com.baizhi.entity.Admin;

import javax.validation.constraints.Pattern;

/**
 * Created by 畅均江 on 2018/8/28.
 */
public interface AdminDao {
    Admin select(String username, String password);
    void insert(Admin admin);
}
