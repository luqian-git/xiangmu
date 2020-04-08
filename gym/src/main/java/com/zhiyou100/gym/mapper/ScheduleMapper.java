package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    public List<Schedule> findAll();

    public List<Schedule> findNum(Integer scheduleCoachNum);

    public Schedule findById(Integer scheduleId);
    public void deleteById(Integer scheduleId);
    public void add(Schedule schedule);
    public void update(Schedule schedule);

    //查询当日是否已经写过日程
    public Schedule findHave(Integer scheduleCoachNum);
}
