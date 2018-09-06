package com.baizhi.service;

import com.baizhi.asprct.LogAnnotation;
import com.baizhi.entity.Banner;

import java.util.List;

/**
 * Created by 畅均江 on 2018/8/29.
 */
public interface BannerService {
    /*全查*/
    List<Banner> quertyAll();
    /*增加*/

    void add(Banner banner);
    /*删除*/

    void remove(Integer id);
    /*修改*/

    void remand(String status,Integer id);
}
