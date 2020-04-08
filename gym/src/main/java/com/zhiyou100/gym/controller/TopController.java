package com.zhiyou100.gym.controller;


import com.zhiyou100.gym.pojo.Top;
import com.zhiyou100.gym.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("top")
public class TopController {

    @Autowired
    private TopService topService;
    
    
    @RequestMapping("show")
    public String show(Model model){
        model.addAttribute("tops",topService.findAll());
        return "top/show";
    }
    @RequestMapping("add")
    public String add(){
        return "top/add";
    }
    @RequestMapping("insert")
    public String insert(Top top){
        topService.add(top);
        return "redirect:show";
    }
    @RequestMapping("edit")
    public String edit(Model model,Integer topId){
        model.addAttribute("top",topService.findById(topId));
        return "top/edit";
    }
    @RequestMapping("update")
    public String update(Top top){
        topService.update(top);
        return "redirect:show";
    }
    @RequestMapping("delete")
    public String delete(Integer topId){
        topService.deleteById(topId);
        return "redirect:show";
    }
    


}