package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Coach;

import java.util.List;

public interface CoachService {

    public List<Coach> findAll(Integer coachPosition);
    public List<Coach> findAllD(Integer coachPosition);
    //查询所有 教练

    public List<Coach> findCoach();

    public Coach findById(Integer coachId);
    public void add(Coach coach);
    public void deleteById(Integer coachId);
    public void update(Coach coach);

}
