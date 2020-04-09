package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Recharge;
import com.zhiyou100.gym.pojo.Top;
import com.zhiyou100.gym.service.RechargeService;
import com.zhiyou100.gym.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("recharge")
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;
    @Autowired
    private TopService topService;


    @RequestMapping("show")
    public String show(Model model,Integer rechUserMember,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        if (rechUserMember == null){
            model.addAttribute("num",rechargeService.findCount());
            //分页
            model.addAttribute("recharges", rechargeService.findRTCByPage(page));
        }else {
            model.addAttribute("num",rechargeService.findrechUserMemberCount(rechUserMember));
            model.addAttribute("recharges",rechargeService.findrechUserMemberByPage(page,rechUserMember));
            model.addAttribute("rechUserMember",rechUserMember);
        }
        return "recharge/show";
    }
    //跳转 余额变动 页面

    @RequestMapping("add")
    public String add(Model model,String msg,Integer rechTopId){
        model.addAttribute("msg",msg);
        List<Top> tops = topService.findAll();
        model.addAttribute("tops",tops);
        if (rechTopId == null){
            rechTopId = 1;
        }
        model.addAttribute("top",topService.findById(rechTopId));
        return "recharge/add";
    }
    // 会员 充值 / 消费

    @RequestMapping("insert")
    public String insert(Recharge recharge){
        String msg = rechargeService.add(recharge);
        return "forward:add?msg="+msg;
    }
    // 无效记录

    @RequestMapping("update")
    public String update(){
        return "redirect:show";
    }

}
