package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 畅均江 on 2018/8/29.
 */
@Controller
@RequestMapping("/Menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/find")
    @ResponseBody
    private List<Menu> findAll(){
        List<Menu> menus = menuService.quertyAll();
            return menus;
    }
}
