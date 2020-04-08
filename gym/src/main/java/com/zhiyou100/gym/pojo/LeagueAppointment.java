package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LeagueAppointment {

    private Integer leAppId;
    private Integer leAppCoachNumber;
    private Integer leAppLeagueId;
    private Integer leAppCardNumber;

    private String coachName ;
    private String leagueCourse;
    private Integer num;
    private String usName;

}
