package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.LeagueMapper;
import com.zhiyou100.gym.pojo.League;
import com.zhiyou100.gym.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {

    @Autowired
    private LeagueMapper leagueMapper;

    @Override
    public List<League> findAll() {
        return leagueMapper.findAll();
    }

    @Override
    public League findById(Integer leagueId) {
        return leagueMapper.findById(leagueId);
    }

    @Override
    public void add(League league) {
        leagueMapper.add(league);
    }

    @Override
    public void deleteById(Integer leagueId) {
        leagueMapper.deleteById(leagueId);
    }

    @Override
    public void update(League league) {
        leagueMapper.update(league);
    }

    @Override
    public List<League> findWeekGroup() {
        return leagueMapper.findWeekGroup();
    }

    @Override
    public List<League> findGroup() {
        return leagueMapper.findGroup();
    }

    @Override
    public void updateTimeSlot(League league) {
        leagueMapper.updateTimeSlot(league);
    }


}
