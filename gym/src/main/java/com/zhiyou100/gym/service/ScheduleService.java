package com.zhiyou100.gym.service;

import com.zhiyou100.gym.pojo.Schedule;

import java.util.List;

public interface ScheduleService {
    public List<Schedule> findAll();
    public Schedule findById(Integer scheduleId);
    public void deleteById(Integer scheduleId);
    public String add(Schedule schedule);
    public void update(Schedule schedule);

    public List<Schedule> findNum(Integer scheduleCoachNum);

    public Integer findCount();
    public Integer findDCount(Integer scheduleCoachNum);

    public List<Schedule> findByPage(Integer page);
    public List<Schedule> findDByPage(Integer page,Integer scheduleCoachNum);


}
