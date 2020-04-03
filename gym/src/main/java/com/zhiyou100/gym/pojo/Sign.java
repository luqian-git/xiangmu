package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class Sign {
    private Integer signId;
    private Integer signNumder;
    private Timestamp signTime;
    private Integer signUserId;
    private String signDesc;
    private Integer signStatus;

    private Integer usMember;
    private String usName;
    private Integer potNumber;
    private String potName;
}
