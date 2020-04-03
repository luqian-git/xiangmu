package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@ToString
public class CabInfo implements Serializable {


    private Integer cabInfoId;

    private Integer cabInfoNumber;

    private Integer cabInfoPrice;

    private Integer cabInfoDuration;

    private Timestamp cabInfoCreateTime;

    private Timestamp   cabInfoUpdateTime;

    private Integer cabInfoMember;

    private Integer cabInfoNum;

    private Integer cabInfoStatus;

    private String usName;

}
