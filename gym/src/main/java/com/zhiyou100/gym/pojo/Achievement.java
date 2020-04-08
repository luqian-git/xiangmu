package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@ToString
@Data
public class Achievement {
    private Integer achId;
    private Integer achNum;
    private Integer achCoachNum;
    private Integer achUserNum;
    private Integer achTopId;
    private Double  achTopPrice;
    private Date achDate;
    private String achDesc;
    private Integer achState;

    private String usName;
    private String coachName;
    private String topName;
}
