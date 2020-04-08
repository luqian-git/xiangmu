package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.LeagueAppointment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeagueAppointmentMapper {

    public void add(LeagueAppointment leagueAppointment);

    public LeagueAppointment notRepeat(LeagueAppointment leagueAppointment);

    public List<LeagueAppointment> appShow(Integer leAppCoachNumber);

    public List<LeagueAppointment> byNum();

    public List<LeagueAppointment> byGo();
}
