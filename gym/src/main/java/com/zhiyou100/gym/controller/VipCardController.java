package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.VipCard;
import com.zhiyou100.gym.service.RoleService;
import com.zhiyou100.gym.service.UserService;
import com.zhiyou100.gym.service.VipCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("vipCard")
public class VipCardController {

    @Autowired
    private VipCardService vipCardService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("show")
    public String show(Model model,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",vipCardService.findCount());
        //分页
        model.addAttribute("vipCards", vipCardService.findByPage(page));
        return "vipCard/show";
    }
    @RequestMapping("add")
    public String add(Model model,String msg){
        model.addAttribute("msg",msg);
        model.addAttribute("roles",roleService.findAll());
        return "vipCard/add";
    }
    @RequestMapping("insert")
    public String insert(VipCard vipCard){
        if (userService.findAccount(vipCard.getUsAccount())!= null){
            return "forward:add?msg="+"账号已存在";
        }
        vipCardService.add(vipCard);
        return "redirect:show";
    }
    @RequestMapping("update")
    public String update(Integer cardNumber){
        vipCardService.update(cardNumber);
        return "redirect:show";
    }

}
