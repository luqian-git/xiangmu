package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Student;
import com.zhiyou100.gym.service.CoachService;
import com.zhiyou100.gym.service.LeagueService;
import com.zhiyou100.gym.service.StudentService;
import com.zhiyou100.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("query")
public class CoachQueryController {

    @Autowired
    private CoachService coachService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private LeagueService leagueService;

    @RequestMapping("show")
    public String show(Model model){
        if (userService.shiroUser().getUsMember()<10000){
            model.addAttribute("msg","不是会员账户");
        }
        model.addAttribute("coachs",coachService.findAll(2));
        return "query/show";
    }
    @RequestMapping("add")
    public String add(Model model,Integer coachNumber,String msg){
        model.addAttribute("weeks",leagueService.findWeekGroup());
        model.addAttribute("groups",leagueService.findGroup());
        model.addAttribute("msg",msg);
        model.addAttribute("vipNum", userService.shiroUser().getUsMember());
        model.addAttribute("coachNumber",coachNumber);
        model.addAttribute("students",studentService.findNum(coachNumber));
        return "query/add";
    }
    @RequestMapping("insert")
    public String insert(Student student){
        String msg = studentService.add(student);
        if (!msg.equals("成功")){
            return "forward:add?msg="+msg+"&coachNumber="+student.getStudentCoachNum();
        }
        return "redirect:show";
    }

}
