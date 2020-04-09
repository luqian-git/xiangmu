package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.LeagueAppointment;
import com.zhiyou100.gym.service.LeagueAppointmentService;
import com.zhiyou100.gym.service.LeagueService;
import com.zhiyou100.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("leApp")
public class LeagueAppointmentController {

    @Autowired
    private LeagueService leagueService;
    @Autowired
    private LeagueAppointmentService leagueAppointmentService;
    @Autowired
    private UserService userService;

    @RequestMapping("show")
    public String show(Model model){
        if (userService.shiroUser().getUsMember()<10000){
            model.addAttribute("msg","不是会员账户");
        }
        model.addAttribute("weeks",leagueService.findWeekGroup());
        model.addAttribute("groups",leagueService.findGroup());
        model.addAttribute("leagues", leagueService.findAll());
        return "leApp/show";
    }
    @RequestMapping("add")
    public String add(Model model,Integer leagueId,String msg){
        model.addAttribute("leAppCardNumber",userService.shiroUser().getUsMember());
        model.addAttribute("msg",msg);
        model.addAttribute("league",leagueService.findById(leagueId));
        return "leApp/add";
    }
    @RequestMapping("insert")
    public String insert(LeagueAppointment leagueAppointment){
        String row = leagueAppointmentService.add(leagueAppointment);
        return "forward:add?msg="+row+"&leagueId="+leagueAppointment.getLeAppLeagueId();
    }

    @RequestMapping("appShow")
    public String appShow(Model model,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",leagueAppointmentService.findCount(userService.shiroUser().getUsMember()));
        //分页
        model.addAttribute("leApps", leagueAppointmentService.findByPage(page,userService.shiroUser().getUsMember()));
        return "leApp/appShow";
    }


    @RequestMapping("statistics")
    public String statistics(){

        return "statistics/show";
    }
    @RequestMapping("cw")
    public String statistice2(){
        return "statistics/cw";
    }

}
