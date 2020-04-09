package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Potential;
import com.zhiyou100.gym.service.PotentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("potential")
public class PotentialController {

    @Autowired
    private PotentialService potentialService;


    @RequestMapping("show")
    public String show(Model model,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",potentialService.findCount());
        //分页
        model.addAttribute("potentials", potentialService.findByPage(page));
        return "potential/show";
    }
    @RequestMapping("add")
    public String add(){
        return "potential/add";
    }
    @RequestMapping("insert")
    public String insert(Potential potential){
        potentialService.add(potential);
        return "redirect:show";
    }
    @RequestMapping("delete")
    public String delete(Integer potId){
        potentialService.deleteById(potId);
        return "redirect:show";
    }
    @RequestMapping("edit")
    public String edit(Integer potId,Model model){
        model.addAttribute("potential",potentialService.findById(potId));
        return "potential/edit";
    }
    @RequestMapping("update")
    public String update(Potential potential){
        potentialService.update(potential);
        return "redirect:show";
    }


}
