package com.zhiyou100.gym.controller;

import com.zhiyou100.gym.pojo.*;
import com.zhiyou100.gym.service.LeagueAppointmentService;
import com.zhiyou100.gym.service.SignService;
import com.zhiyou100.gym.service.TrainingService;
import com.zhiyou100.gym.service.UserService;
import javafx.collections.transformation.TransformationList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired
    private LeagueAppointmentService leagueAppointmentService;
    @Autowired
    private TrainingService trainingService;
    @Autowired
    private UserService userService;

    //统计分析 报名数

    @RequestMapping("analyshow")
    public List<LeagueAppointment> show(){
        return leagueAppointmentService.byNum();
    }
    //统计分析 出勤

    @RequestMapping("analysigns")
    public List<LeagueAppointment> signs(){
        return leagueAppointmentService.byGo();
    }

    //运动报表

    @RequestMapping("trainingNow")
    public List<Training> trainingNow(){
        User user = userService.shiroUser();
        return trainingService.findNow(user.getUsMember());
    }

    //运动报表

    @RequestMapping("trainingDate")
    public List<Training> training2(){
      User user = userService.shiroUser();
      System.out.println(trainingService.findAllDate(user.getUsMember()));
      return trainingService.findAllDate(user.getUsMember());
    }


    //财务报表

}
