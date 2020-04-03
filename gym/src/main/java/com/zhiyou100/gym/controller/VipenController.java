package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.service.VipenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vipen")
public class VipenController {

    @Autowired
    private VipenService vipenService;

    @RequestMapping("show")
    public String show(Model model,Integer q){
        if (q == null){
            q = 0;
        }
        model.addAttribute("q",q);
        model.addAttribute("vipens",vipenService.findAll(q));
        return "vipen/show";
    }
    @RequestMapping("update")
    public String update(Integer vipenId){
        vipenService.update(vipenId);
        return "redirect:show";
    }

}
