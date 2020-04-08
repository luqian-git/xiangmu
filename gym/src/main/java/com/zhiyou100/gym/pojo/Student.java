package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@ToString
@Data
public class Student {

    private Integer studentId;
    private Integer studentCoachNum;
    private Integer studentVipNum;
    private Integer studentWeek;
    private Integer studentTime;
    private Date studentDate;
    private Integer studentState;

    private String usName;

}
