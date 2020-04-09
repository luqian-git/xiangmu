package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.CabInfo;
import com.zhiyou100.gym.pojo.Cabinet;
import com.zhiyou100.gym.service.CabInfoService;
import com.zhiyou100.gym.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cabinet")
public class CabinetController {

    @Autowired
    private CabinetService cabinetService;
    @Autowired
    private CabInfoService cabInfoService;

    @RequestMapping("show")
    public String show(Model model,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",cabinetService.findCount13());
        //分页
        model.addAttribute("cabinets", cabinetService.findByPage13(page));
        return "cabinet/show";
    }

    @RequestMapping("show1")
    public String show1(Model model,Integer page){
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",cabinetService.findCount2());
        //分页
        model.addAttribute("cabinets", cabinetService.findByPage2(page));
        return "cabinet/show1";
    }
    @RequestMapping("show2")
    public String show2(Model model,Integer pagey,Integer pageg){
        if (pagey == null) {
            pagey = 1;
        }
        if (pageg == null) {
            pageg = 1;
        }
        model.addAttribute("pooy", pagey);
        model.addAttribute("poog", pageg);
        model.addAttribute("numy",cabInfoService.findCount(1));
        model.addAttribute("numg",cabInfoService.findCount(0));
        //分页
        model.addAttribute("infoy", cabInfoService.findByPage(pagey,1));
        model.addAttribute("infog",cabInfoService.findByPage(pageg,0));
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
            return "forward:add?msg="+msg+"&cabNumber="+cabInfo.getCabInfoNum();
        }
        return "redirect:show";
    }

    @RequestMapping("edit")
    public String edit(Integer cabInfoId,Model model){
        model.addAttribute("cabInfo",cabInfoService.findBycabInfoId(cabInfoId));
        return "cabinet/edit";
    }
    @RequestMapping("update4")
    public String update4(CabInfo cabInfo){
        cabInfoService.update(cabInfo);
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

    @RequestMapping("addCab")
    public String addCab(){
        return "cabinet/addCab";
    }
    @RequestMapping("insertCab")
    public String insertCab(Cabinet cabinet){
        cabinetService.insertCab(cabinet);
        return "redirect:addCab";
    }

}