package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@Data
public class Training {
    private Integer trainingId;
    private Integer trainingNumber;
    private Integer trainingUserNum;
    private Integer trainingEquipId;
    private Timestamp trainingStartTime;
    private Timestamp trainingEndTime;
    private Integer trainingThisTime;
    private Integer trainingRecordTime;
    private Integer trainingState;

    private String equipName;
    private String usName;
}
