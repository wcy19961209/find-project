package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by 畅均江 on 2018/9/3.
 */
public interface UserDao {

    /*查询*/
    User select(Integer id);
    /*修改*/
    void Update(User user);
    /*全查*/
    List<User> squertyAll();
}
