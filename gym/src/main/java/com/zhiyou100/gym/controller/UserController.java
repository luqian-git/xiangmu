package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String login(User user,Model model){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsAccount(),user.getUsPassword());
            subject.login(token);
        } catch (Exception e) {
            model.addAttribute("msg","登录失败");
            e.printStackTrace();
            return "forward:login.html";
        }
        return "redirect:admin";
    }
    @RequestMapping("admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("show")
    public String show(Model model){
        model.addAttribute("users",userService.findAll());
        return "user/show";
    }
    @RequestMapping("loginOut")
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return"redirect:/login.html";
    }
}
