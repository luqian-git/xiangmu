package com.zhiyou100.gym.pojo;


import lombok.Data;
import lombok.ToString;

import java.sql.Date;

@ToString
@Data
public class VipCard {

    private Integer cardId;
    private Integer cardNumber;
    private Integer cardUserId;
    private Date cardOpenTime;
    private Date cardEndTime;
    private Double cardBalance;
    private Integer cardStatus;
    //添加 账号 --

    private String usAccount;
    private String usPassword;
    private String usName;
    private String usSex;
    private Integer usAge;

    private Integer usRole;

}
