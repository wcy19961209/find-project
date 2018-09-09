package com.baizhi.dao;

import com.baizhi.entity.Admin;
import com.baizhi.entity.ProvinceSum;
import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

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
    /*修改状态*/
    void UpdateUser(@Param("status") String status, @Param("id") Integer id);
    /*添加数据*/
    void insert(User user);

    /*数据图*/
    Integer queryFirst();
    Integer querySecond();
    Integer queryThird();
    Integer queryForth();
    List<ProvinceSum> query();
    List<User> findAllUser();
    /*app登录*/
    User selectregister(@Param("phoneNum") String phoneNum, @Param("password")String password);

}
