package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class Vipen {

    private Integer vipenId;
    private Integer vipenUserId;
    private Long vipenNumber;
    private Timestamp vipenEntryTime;
    private Timestamp vipenOutTime;
    private Integer vipenStatus;
    private String usName;
}