package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 畅均江 on 2018/8/29.
 */
public interface BannerDao {
    /*全查*/
    List<Banner> findAll();
    /*增加*/
    void insert(Banner banner);
    /*删除*/
    void delete(Integer id);
    /*修改*/
    void Update(@Param("status") String status,@Param("id") Integer id);
}
