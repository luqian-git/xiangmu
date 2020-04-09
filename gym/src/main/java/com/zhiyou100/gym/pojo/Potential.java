package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;

/*
 * 潜客登记
 * */

@ToString
@Data
public class Potential {

    private Integer potId;
    private Integer potNumber;
    private String potName;
    private Long potPhone;
    private String potSex;
    private Date potTime;
    private String potDesc;
    private String potVocation;
    private String potLike;
    private String potAddress;
    private Integer potStatus;

}
