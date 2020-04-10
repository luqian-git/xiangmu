package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
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
        log.info("log测试登录成功登录的人是");
        log.error("登录的人是"+userService.shiroUser().getUsAccount());
        return "admin";
    }

    @RequestMapping("show")
    public String show(Model model,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",userService.findUserCount());
        //分页
        model.addAttribute("dan", userService.findByPage(page));
        //链接 role
        model.addAttribute("users", userService.findAll());
        return "user/show";
    }
    @RequestMapping("loginOut")
    public String loginOut(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return"redirect:/login.html";
    }
}
