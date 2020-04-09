package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Coach;

import java.util.List;

public interface CoachService {

    public List<Coach> findAll(Integer coachPosition);
    public List<Coach> findAllD(Integer coachPosition);

    /*
    *通过教练编号查询
    * */

    public Coach findcoachNumber(Integer coachNumber);

    //查询教练
    public List<Coach> findCoach();

    public Coach findById(Integer coachId);
    public void add(Coach coach);
    public void deleteById(Integer coachId);
    public void update(Coach coach);

    public Integer findCount(Integer coachPosition);

    public List<Coach> findByPage(Integer page,Integer coachPosition);

}
