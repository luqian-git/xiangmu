package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Training;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TrainingService {

    public List<Training> findAll(Integer t,Integer trainingUserNum);


    public Training findById(Integer trainingId);
    public String upTime(Integer trainingId);
    public String add(Training training);

    //今日运动报表
    public List<Training> findNow(Integer trainingUserNum);
    //累计运动报表
    public List<Training> findAllDate(Integer trainingUserNum);
}
