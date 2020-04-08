package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("achievement")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;


    @RequestMapping("show")
    public String show(Model model,Integer achCoachNum){
        if (achCoachNum == null){
            model.addAttribute("achs",achievementService.findAll());
        }else {
            model.addAttribute("achs",achievementService.findCoachNum(achCoachNum));
        }
        return "achievement/show";
    }


    @RequestMapping("update")
    public String update(Integer achId){
        achievementService.update1(achId);
        return "redirect:show";
    }

}
