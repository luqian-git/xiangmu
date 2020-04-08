package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.League;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeagueMapper {

    public List<League> findAll();
    public League findById(Integer leagueId);
    public void add(League league);
    public void deleteById(Integer leagueId);

    //更改课程
    public void update(League league);

    //查询 周
    public List<League> findWeekGroup();
    //查询 时段
    public List<League> findGroup();

    //修改时间段
    public void updateTimeSlot(League league);
}
