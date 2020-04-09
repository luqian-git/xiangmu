package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.Coach;
import com.zhiyou100.gym.service.CoachService;
import com.zhiyou100.gym.service.RoleService;
import com.zhiyou100.gym.util.QiniuUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("coach")
public class CoachController {

    @Autowired
    private CoachService coachService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private QiniuUtil qiniuUtil;

    @RequestMapping("show")
    public String show(Model model,Integer coachPosition,Integer page){
        if (coachPosition == null){
            coachPosition = 2;
        }
        if (page == null) {
            page = 1;
        }
        model.addAttribute("poo", page);
        model.addAttribute("num",coachService.findCount(coachPosition));
        //分页
        model.addAttribute("coachs", coachService.findByPage(page,coachPosition));
        return "coach/show";
    }
    @RequestMapping("add")
    public String add(String msg,Model model){
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("msg",msg);
        return "coach/add";
    }
    @RequestMapping("insert")
    public String insert(@RequestParam("file") MultipartFile file,Coach coach)throws IOException {
        //文件非空
        if (!file.isEmpty()){
            //获取文件名
            String fileName = file.getOriginalFilename();
            //接收一下  上文件之后的返回值
            String path = qiniuUtil.uploadImg((FileInputStream) file.getInputStream(), fileName);
            coach.setCoachHead("http://"+path);
            coachService.add(coach);
            return "redirect:show";
        }else {
            return "forward:add?msg="+"头像上传失败";
        }
    }
    @RequestMapping("edit")
    public String edit(Model model,Integer coachId){
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("coach",coachService.findById(coachId));
        return "coach/edit";
    }
    @RequestMapping("update")
    public String update(@RequestParam("file") MultipartFile file,Coach coach)throws IOException{

        if (file.isEmpty()){
            coachService.update(coach);
            return "redirect:show";
        }else {
            //获取文件名
            String fileName = file.getOriginalFilename();
            //接收一下  上文件之后的返回值
            String path = qiniuUtil.uploadImg((FileInputStream) file.getInputStream(), fileName);
            coach.setCoachHead("http://"+path);
            coachService.update(coach);
            return "redirect:show";
        }
    }
    @RequestMapping("delete")
    public String delete(){
        return "redirect:show";
    }

    // 员工管理--






}
