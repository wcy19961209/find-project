package com.baizhi.service;



import com.baizhi.dao.UserDao;
import com.baizhi.entity.ProvinceSum;
import com.baizhi.entity.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by microsoft on 2018/9/4.
 */
@Service
@Transactional
public class UserChinaServiceImpl implements UserChinaService{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<ProvinceSum> query() {
        return userDao.query();
    }

    @Override
    public Map<String,Object> queryMonth(){
        Integer sum1=userDao.queryFirst();
        Integer sum2=userDao.querySecond();
        Integer sum3=userDao.queryThird();
        Integer sum4=userDao.queryForth();

        List<String> str=new ArrayList<>();
        str.add("第一周");
        str.add("第二周");
        str.add("第三周");
        str.add("第四周");
        List<Object> count=new ArrayList<>();
        count.add(sum1);
        count.add(sum2);
        count.add(sum3);
        count.add(sum4);
        Map<String,Object> map=new HashMap<>();
        map.put("xAxis",str);
        map.put("count",count);

        return map;
    }




    @Override
    public List<User> findAll() {
        return userDao.findAllUser();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User queryUser(String phoneNum) {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void modifyMore(User user) {

    }

    @Override
    public User queryById(Integer id) {
        return null;
    }
}
