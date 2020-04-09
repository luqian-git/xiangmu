package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.LeagueAppointment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LeagueAppointmentMapper {

    public void add(LeagueAppointment leagueAppointment);

    public LeagueAppointment notRepeat(LeagueAppointment leagueAppointment);

    public List<LeagueAppointment> appShow(Integer leAppCoachNumber);

    public Integer findCount(Integer leAppCoachNumber);
    public List<LeagueAppointment> findByPage(@Param("start") int start, @Param("size") int size,Integer leAppCoachNumber);


    public List<LeagueAppointment> byNum();

    public List<LeagueAppointment> byGo();
}
