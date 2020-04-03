package com.zhiyou100.gym.controller;


import com.zhiyou100.gym.pojo.Sign;
import com.zhiyou100.gym.service.SignService;
import com.zhiyou100.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sign")
public class SignController {


    @Autowired
    private SignService signService;



    @RequestMapping("show")
    public String show(Model model,Integer q){
        if (q == null||q > 2 || q < 0 ){
            q = 0;
        }
        model.addAttribute("q",q);
        model.addAttribute("signs",signService.findAll(q));
        return "sign/show";
    }
    @RequestMapping("add")
    public String add(Model model,String msg){
        model.addAttribute("msg",msg);
        return "sign/add";
    }
    @RequestMapping("insert")
    public String insert(Sign sign){
        String r =  signService.add(sign);
        if (!r.equals("签到成功")){
            return "redirect:add";
        }
        return "redirect:show";
    }
    //forward
    @RequestMapping("insert2")
    public String insert2(Long phone,String desc,Model model){
        String r =  signService.add2(phone,desc);
        if (!r.equals("签到成功")){
            return "forward:add?msg="+r;
        }
        return "redirect:show";
    }
}
