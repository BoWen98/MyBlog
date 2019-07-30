package com.bowen.myblog.web.admin;

import com.bowen.myblog.po.User;
import com.bowen.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.web.admin
 * @ClassName: LoginController
 * @Author: Bowen
 * @Description: 登录实现
 * @Date: 2019/7/26 9:42
 * @Version: 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(HttpSession session) {

        if (session.getAttribute("user") != null) {
            return "admin/index";
        }
        return "admin/login";

    }


    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            RedirectAttributes attributes,
            HttpSession session) {
        User user = userService.userLogin(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        }
        attributes.addFlashAttribute("message", "用户名或密码错误");
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
