package com.baizhi.controller;


import com.baizhi.entity.ProvinceSum;
import com.baizhi.service.UserChinaService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by microsoft on 2018/9/4.
 */
@Controller
@RequestMapping("/user")
public class UserChinaController {
    @Autowired
    private UserChinaService userChinaService;

    @RequestMapping(value = "/queryMap",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<ProvinceSum> queryMap(){
        return userChinaService.query();
    }

    @RequestMapping(value = "/queryWeek",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Map<String,Object> queryWeek() throws JSONException {
        return userChinaService.queryMonth();
    }
}
