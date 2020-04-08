package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.LeagueAppointment;

import java.util.List;

public interface LeagueAppointmentService {
    public String add(LeagueAppointment leagueAppointment);

    public List<LeagueAppointment> byNum();
    public List<LeagueAppointment> byGo();

    public List<LeagueAppointment> appShow(Integer leAppCoachNumber);
}
