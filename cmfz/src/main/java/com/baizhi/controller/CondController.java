package com.baizhi.controller;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * Created by 畅均江 on 2018/8/28.
 */
@Controller
@RequestMapping("/cond")
public class CondController {

    @RequestMapping("/createCaptcha")
    public void createCaptcha(HttpSession session, HttpServletResponse response) throws Exception {
        String code = SecurityCode.getSecurityCode();
        session.setAttribute("code", code);
        //生成验证码图片
        BufferedImage image = SecurityImage.createImage(code);
        //响应到客户端
        OutputStream out = response.getOutputStream();
		/*
		参数一 ： 验证码图片对象
		 参数二： 响应内容的格式
		 参数三：输出字节流*/
        ImageIO.write(image, "png", out);
    }
}
