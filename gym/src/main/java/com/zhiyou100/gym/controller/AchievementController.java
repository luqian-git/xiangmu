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
    public String show(Model model,Integer achCoachNum,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        if (achCoachNum == null){
            model.addAttribute("num",achievementService.findCount());
            //分页
            model.addAttribute("achs", achievementService.findByPage(page));
        }else {
            model.addAttribute("achCoachNum",achCoachNum);
            model.addAttribute("num",achievementService.findCoachNumCount(achCoachNum));
            //分页
            model.addAttribute("achs", achievementService.findCoachNumByPage(page,achCoachNum));
        }
        return "achievement/show";
    }


    @RequestMapping("update")
    public String update(Integer achId){
        achievementService.update1(achId);
        return "redirect:show";
    }

}
