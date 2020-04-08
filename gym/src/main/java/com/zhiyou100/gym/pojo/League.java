package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@ToString
@Data
public class League {
    private Integer leagueId;
    private String leagueWeek;
    private String leagueTimeSlot;

    private Date leagueStart;
    private Date leagueEnd;

    private Integer leagueCoachNumber;
    private String leagueCourse;
    private String leagueDesc;

    private String coachName;

    private Integer leagueWeekGroup;
    private Integer leagueGroup;

    private Integer leagueState;
}
