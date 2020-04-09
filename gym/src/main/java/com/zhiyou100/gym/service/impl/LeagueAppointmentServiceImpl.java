package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.LeagueAppointmentMapper;
import com.zhiyou100.gym.pojo.LeagueAppointment;
import com.zhiyou100.gym.pojo.User;
import com.zhiyou100.gym.service.LeagueAppointmentService;
import com.zhiyou100.gym.service.UserService;
import com.zhiyou100.gym.service.VipCardService;
import com.zhiyou100.gym.util.PageNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueAppointmentServiceImpl implements LeagueAppointmentService {

    @Autowired
    private LeagueAppointmentMapper leagueAppointmentMapper;
    @Autowired
    private UserService userService;

    @Override
    public String add(LeagueAppointment leagueAppointment) {
        User user = userService.findByMember(leagueAppointment.getLeAppCardNumber());
        if (user == null){
            return "会员号不存在";
        }else if (leagueAppointmentMapper.notRepeat(leagueAppointment) != null){
            return "不可重复预约";
        }
        leagueAppointmentMapper.add(leagueAppointment);
        return "预约成功";
    }

    @Override
    public List<LeagueAppointment> byNum() {
        return leagueAppointmentMapper.byNum();
    }

    @Override
    public List<LeagueAppointment> byGo() {
        return leagueAppointmentMapper.byGo();
    }

    @Override
    public List<LeagueAppointment> appShow(Integer leAppCoachNumber) {
        return leagueAppointmentMapper.appShow(leAppCoachNumber);
    }
    public Integer num = PageNumUtil.PageNum;
    @Override
    public Integer findCount(Integer leAppCoachNumber) {
        // 获取 数据库 中 数量
        int count = leagueAppointmentMapper.findCount(leAppCoachNumber);
        int Page = count / num;
        if (count % num != 0) {
            Page++;
        }
        return Page;
    }

    @Override
    public List<LeagueAppointment> findByPage(Integer page, Integer leAppCoachNumber) {
        if (page == null || page < 1) {
            page = 1;
        }
        int size = num;
        //跳过多条数据
        int pages = (page - 1) * size;
        return leagueAppointmentMapper.findByPage(pages, size,leAppCoachNumber);
    }
}
