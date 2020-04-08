package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.service.LeagueService;
import com.zhiyou100.gym.service.StudentService;
import com.zhiyou100.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private LeagueService leagueService;

    @RequestMapping("show")
    public String show(Model model){
        model.addAttribute("groups",leagueService.findGroup());
        model.addAttribute("students", studentService.findNum01(userService.shiroUser().getUsMember()));
        return "student/show";
    }
    @RequestMapping("update")
    public String update(Integer studentId,Model model){
        studentService.update(studentId);
        return "redirect:show";
    }

}
