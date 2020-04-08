package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@ToString
@Data
public class Recharge {

    private Integer rechId;
    private Integer rechNumber;
    private Integer rechTopId;
    private Double rechMoney;
    private Timestamp rechTime;
    private Integer rechAch;
    private Integer rechUserMember;
    private Integer rechStatus;

    private Top top;
    private VipCard vipCard;
}
