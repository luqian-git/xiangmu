package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@Data
@ToString
public class Maintain {

    private Integer maintainId;
    private Integer maintainNum;
    private String maintainRegion;
    private Integer maintainEquipNum;
    private String maintainDesc;
    private Date maintainTime;
    private Double maintainMoney;
    private Integer maintainCoachNumber;

    private String equipName;
    private String coachName;
}
