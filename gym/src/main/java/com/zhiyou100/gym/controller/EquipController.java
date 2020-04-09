package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Equip;
import com.zhiyou100.gym.service.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("equip")
public class EquipController {

    @Autowired
    private EquipService equipService;


    @RequestMapping("show")
    public String show(Model model,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",equipService.findCount());
        //分页
        model.addAttribute("equips", equipService.findByPage(page));
        return "equip/show";
    }
    @RequestMapping("add")
    public String add(){
        return "equip/add";
    }
    @RequestMapping("insert")
    public String insert(Equip equip){
        equipService.add(equip);
        return "redirect:add";
    }
    @RequestMapping("edit")
    public String edit(Model model,Integer equipId){
        model.addAttribute("equip",equipService.findById(equipId));
        return "equip/edit";
    }
    @RequestMapping("update")
    public String update(Equip equip){
        equipService.update(equip);
        return "redirect:show";
    }
    @RequestMapping("delete")
    public String delete(Integer equipId){
        equipService.deleteById(equipId);
        return "redirect:show";
    }

}
