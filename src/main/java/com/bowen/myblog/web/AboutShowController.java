package com.bowen.myblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.web
 * @ClassName: AboutShowController
 * @Author: Bowen
 * @Description: 关于我显示控制器
 * @Date: 2019/7/27 15:55
 * @Version: 1.0.0
 */
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
