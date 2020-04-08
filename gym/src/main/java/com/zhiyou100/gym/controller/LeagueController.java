package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.League;
import com.zhiyou100.gym.service.CoachService;
import com.zhiyou100.gym.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("league")
public class LeagueController {

    @Autowired
    private LeagueService leagueService;
    @Autowired
    private CoachService coachService;


    @RequestMapping("show")
    public String show(Model model){
        model.addAttribute("weeks",leagueService.findWeekGroup());
        model.addAttribute("groups",leagueService.findGroup());
        model.addAttribute("leagues", leagueService.findAll());
        return "league/show";
    }
    @RequestMapping("add")
    public String add(Model model){
        model.addAttribute("coachs",coachService.findCoach());
        return "league/add";
    }
    @RequestMapping("insert")
    public String insert(League league){
        leagueService.add(league);
        return "redirect:show";
    }
    @RequestMapping("edit")
    public String edit(Model model,Integer leagueId){
        model.addAttribute("league",leagueService.findById(leagueId));
        model.addAttribute("coachs",coachService.findCoach());
        return "league/edit";
    }
    @RequestMapping("update")
    public String update(League league){
        leagueService.update(league);
        return "redirect:show";
    }
    @RequestMapping("delete")
    public String delete(Integer leagueId){
        leagueService.deleteById(leagueId);
        return "redirect:show";
    }

    //时间段安排
    //跳转

    @RequestMapping("editTime")
    public String editTime(Model model){
        model.addAttribute("groups",leagueService.findGroup());
        return "league/editTime";
    }

    @RequestMapping("upTime")
    public String upTime(League league){
        leagueService.updateTimeSlot(league);
        return "redirect:editTime";
    }
}
