package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@ToString
@Data
public class Coach {

    private Integer coachId;
    private Integer coachNumber;
    private Date   coachDate;
    private String coachName;
    private String coachSex;
    private Integer coachAge;
    private String coachHead;
    private String coachLabel;
    private String coachIntroduce;
    private String coachStatus;
    private Integer coachPosition;
    private Role role;
    private String account;
    private String password;
}
