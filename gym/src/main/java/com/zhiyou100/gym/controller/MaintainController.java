package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Maintain;
import com.zhiyou100.gym.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("maintain")
public class MaintainController {

    @Autowired
    private MaintainService maintainService;


    @RequestMapping("show")
    public String show(Model model,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",maintainService.findCount());
        //分页
        model.addAttribute("maintains", maintainService.findByPage(page));
        return "maintain/show";
    }
    @RequestMapping("add")
    public String add(String msg,Model model){
        model.addAttribute("msg",msg);
        return "maintain/add";
    }
    @RequestMapping("insert")
    public String insert(Maintain maintain){
        String msg = maintainService.add(maintain);
        return "forward:add?msg="+msg;
    }
    @RequestMapping("edit")
    public String edit(Model model,Integer maintainId){
        model.addAttribute("maintain",maintainService.findById(maintainId));
        return "maintain/edit";
    }
    @RequestMapping("update")
    public String update(Maintain maintain){
        maintainService.update(maintain);
        return "redirect:show";
    }
    @RequestMapping("delete")
    public String delete(Integer maintainId){
        maintainService.deleteById(maintainId);
        return "redirect:show";
    }



}
