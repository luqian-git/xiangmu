package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Schedule;
import com.zhiyou100.gym.service.CoachService;
import com.zhiyou100.gym.service.ScheduleService;
import com.zhiyou100.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private UserService userService;
    
    @RequestMapping("show")
    public String show(Model model,Integer page,Integer UsMember){
        if (page == null) {
            page = 1;
        }
        if (UsMember == null){
            UsMember = userService.shiroUser().getUsMember();
        }
        model.addAttribute("UsMember",UsMember);
        model.addAttribute("poo", page);
        if (userService.shiroUser().getUsAccount().equals("admin")){
            model.addAttribute("num",scheduleService.findCount());
            //分页
            model.addAttribute("schedules", scheduleService.findByPage(page));
        }else {
            model.addAttribute("num",scheduleService.findDCount(UsMember));
            //分页
            model.addAttribute("schedules", scheduleService.findDByPage(page,UsMember));

        }
        return "schedule/show";
    }
    @RequestMapping("add")
    public String add(Model model,String msg){
        model.addAttribute("msg",msg);
        model.addAttribute("scheduleCoachNum",userService.shiroUser().getUsMember());
        return "schedule/add";
    }
    @RequestMapping("insert")
    public String insert(Schedule schedule){
        String msg = scheduleService.add(schedule);
        return "forward:add?msg="+msg;
    }
    @RequestMapping("edit")
    public String edit(Model model,Integer scheduleId){
        model.addAttribute("scheduleCoachNum",userService.shiroUser().getUsMember());
        model.addAttribute("schedule",scheduleService.findById(scheduleId));
        return "schedule/edit";
    }
    @RequestMapping("update")
    public String update(Schedule schedule){
        scheduleService.update(schedule);
        return "redirect:show";
    }
    @RequestMapping("delete")
    public String delete(Integer scheduleId){
        scheduleService.deleteById(scheduleId);
        return "redirect:show";
    }
    
}
