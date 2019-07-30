package com.bowen.myblog.web;

import com.bowen.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.web
 * @ClassName: ArchiveShowController
 * @Author: Bowen
 * @Description: 归档控制器
 * @Date: 2019/7/27 15:57
 * @Version: 1.0.0
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        model.addAttribute("archiveMap", blogService.archiveBlog());
        model.addAttribute("blogCount", blogService.countBlog());
        return "archives";
    }
}
