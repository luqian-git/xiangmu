package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Training;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.EquipService;
import com.zhiyou100.gym.service.TrainingService;
import com.zhiyou100.gym.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;
    @Autowired
    private EquipService equipService;
    @Autowired
    private UserService userService;


    @RequestMapping("show")
    public String show(Model model,Integer t){
        if (t == null){
            t = 0;
        }
        if (userService.shiroUser().getUsMember()<10000){
            model.addAttribute("msg","当前不是会员账户");
            model.addAttribute("t",t);
            model.addAttribute("trainings",trainingService.findAll(t,1));
            return "training/show";
        }else {
            model.addAttribute("t", t);
            model.addAttribute("trainings", trainingService.findAll(t, userService.shiroUser().getUsMember()));
            return "training/show";
        }
    }



    @RequestMapping("add")
    public String add(Model model,String msg){
        if (userService.shiroUser().getUsMember()>10000){
            model.addAttribute("trainingUserNum",userService.shiroUser().getUsMember());
        }
        model.addAttribute("msg",msg);
        model.addAttribute("equips",equipService.findAll());
        return "training/add";
    }
    @RequestMapping("insert")
    public String insert(Training training){
        String msg = trainingService.add(training);
        if (msg.equals("成功")){
            return "redirect:show";
        }
        return "forward:add?msg="+msg;
    }
    @RequestMapping("upTime")
    public String delete(Integer trainingId){
        trainingService.upTime(trainingId);
        return "redirect:show";
    }
    @RequestMapping("training")
    public String form(){

        return "training/form";
    }
    
}
