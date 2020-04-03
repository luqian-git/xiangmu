package com.zhiyou100.gym.pojo;


import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Cabinet{
    private Integer cabId;
    private Integer cabNumber;
    private Integer cabCapacity;
    private Integer cabStatus;
    private CabInfo cabInfo;

}
