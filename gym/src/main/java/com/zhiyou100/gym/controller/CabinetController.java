package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.CabInfo;
import com.zhiyou100.gym.service.CabInfoService;
import com.zhiyou100.gym.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cabinet")
public class CabinetController {

    @Autowired
    private CabinetService cabinetService;
    @Autowired
    private CabInfoService cabInfoService;

    @RequestMapping("show")
    public String show(Model model){
        model.addAttribute("cabinets",cabinetService.findWAll());
        return "cabinet/show";
    }

    @RequestMapping("show1")
    public String show1(Model model){
        model.addAttribute("cabinets",cabinetService.findYAll());
        return "cabinet/show1";
    }
    @RequestMapping("show2")
    public String show2(Model model){
        model.addAttribute("infoy",cabInfoService.findYAll());
        model.addAttribute("infog",cabInfoService.findGAll());
        return "cabinet/show2";
    }
    @RequestMapping("add")
    public String add(Integer cabNumber,Model model,String msg){
        model.addAttribute("msg",msg);
        model.addAttribute("cabInfoNum",cabNumber);
        return "cabinet/add";
    }
    @RequestMapping("lease")
    public String lease(CabInfo cabInfo){
        String msg = cabInfoService.add(cabInfo);
        if (msg.equals("无输入的会员编号")){
            return "forward:add?msg="+msg+"&cabNumber="+cabInfo.getCabInfoNumber();
        }
        return "redirect:show";
    }

    //故障

    @RequestMapping("update3")
    public String Update3(Integer cabId){
        cabinetService.update3(cabId);
        return "redirect:show";
    }
    //恢复

    @RequestMapping("update1")
    public String Update1(Integer cabId){
        cabinetService.update1(cabId);
        return "redirect:show";
    }

}