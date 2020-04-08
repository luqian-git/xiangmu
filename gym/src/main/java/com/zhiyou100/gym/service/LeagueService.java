package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.League;

import java.util.List;

public interface LeagueService {

    public List<League> findAll();
    public League findById(Integer leagueId);
    //
    public void add(League league);
    //改为空闲
    public void deleteById(Integer leagueId);
    //修改课程表
    public void update(League league);

    //周
    public List<League> findWeekGroup();
    //时段
    public List<League> findGroup();

    //修改时间段
    public void updateTimeSlot(League league);

}
