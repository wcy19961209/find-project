package com.baizhi.service;


import com.baizhi.entity.ProvinceSum;
import com.baizhi.entity.User;
import java.util.List;
import java.util.Map;

/**
 * Created by microsoft on 2018/9/4.
 */
public interface UserChinaService {
    List<ProvinceSum> query();
    Map<String,Object> queryMonth();
    public List<User> findAll();
    public void update(User user);
    public User queryUser(String phoneNum);
    public void add(User user);
    public void modifyMore(User user);
    public User queryById(Integer id);
}
