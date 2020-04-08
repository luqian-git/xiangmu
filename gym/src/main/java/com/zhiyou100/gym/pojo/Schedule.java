package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
public class Schedule {
    private Integer scheduleId;
    private Integer scheduleNum;
    private Date scheduleDate;
    private Integer scheduleCoachNum;
    private String scheduleArrange;
    private String scheduleNo;
    private String scheduleDesc;

    private String coachName;
}
