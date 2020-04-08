package com.zhiyou100.gym.pojo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ReportForm {

    private Integer id;
    private String month;
    private Double cost;
    private Double income;
    private Double profit;
}
