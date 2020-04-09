package com.zhiyou100.gym.controller;


import com.zhiyou100.gym.pojo.Sign;
import com.zhiyou100.gym.service.SignService;
import com.zhiyou100.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("sign")
public class SignController {


    @Autowired
    private SignService signService;



    @RequestMapping("show")
    public String show(Model model, Integer q,Integer signUserNumber,Integer page,String msg){
        if (q == null||q > 2 || q < 0 ){
            q = 0;
        }
        if (page == null){
            page = 1;
        }
        if (msg!= null){
            model.addAttribute("msg","请确认编号,编号错误");
        }
        model.addAttribute("poo", page);
        model.addAttribute("q",q);
        if (signUserNumber != null){
            model.addAttribute("signs",signService.findByPageNum(page,signUserNumber));
            model.addAttribute("num",signService.findCountNum(signUserNumber));
        }else {
            model.addAttribute("signs",signService.findByPage(page,q));
            model.addAttribute("num",signService.findCount(q));
        }

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
            return "forward:add?msg="+r;
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
