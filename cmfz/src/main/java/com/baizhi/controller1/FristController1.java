package com.baizhi.controller1;

import com.baizhi.entity.Album;
import com.baizhi.entity.Banner;
import com.baizhi.entity.User;
import com.baizhi.service.AlbumService;
import com.baizhi.service.BannerService;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 畅均江 on 2018/9/6.
 */
@RestController
@RequestMapping("/frist")
public class FristController1 {
    @Autowired
    private BannerService bannerService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private UserService userService;
      /*首页*/
    @RequestMapping("/HomePage")
    public Map<String,Object> HomePage(String type,String sub_type,String uid) {

        Map<String, Object> map = null;

        if (type.equals("all")) {
            List<Banner> banners = bannerService.quertyAll();
            List<Album> albums = albumService.quertyAll();
            map = new HashMap<>();
            map.put("banner", banners);
            map.put("albums", albums);
            return map;
        }

        if (uid.equals("wen")) {
            List<Album> albums = albumService.quertyAll();
            map = new HashMap<>();
            map.put("albums", albums);
            return map;
        }
        map = new HashMap<>();
        map.put("error","操作失误,请重新操作！");
        return map;
    }

    /*闻*/
    @RequestMapping("/news")
    public Object news(Integer id){
        Map<String,String> map=new HashMap<>();
        try {
            Album album = albumService.find(id);
            if(album!=null){

                return album;
            }else{
                map.put("ERROR","对不起系统出现故障,请重新选择");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("ERROR","对不起网络正在连接");
            return map;
        }

    }
    /*登录接口*/
    @RequestMapping("/register")
    public Object register(String phoneNum,String password){
        Map<String,String> map=new HashMap<>();
        try {
            User querty = userService.querty(phoneNum, password);
            return querty;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error","密码错误");
            return map;
        }
    }

    /*用户修改*/
    @RequestMapping("/modify")
    public Object modify(User user){

        Map<String,String> map=new HashMap<>();
        try {
            userService.modify(user);
            User user1 = userService.find(user.getId());
            if(user1.equals(user)){
                return user1;
            }else {
                map.put("error","修改失败，请重新修改");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("error","修改失败，请重新修改");
            return map;
        }
    }

        /*思*/

}
