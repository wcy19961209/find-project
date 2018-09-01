package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;


/**
 * Created by 畅均江 on 2018/8/28.
 */
public interface AdminDao {
    Admin select(@Param("username") String username, @Param("password") String password);
    void insert(Admin admin);
    void update(String password);
}
