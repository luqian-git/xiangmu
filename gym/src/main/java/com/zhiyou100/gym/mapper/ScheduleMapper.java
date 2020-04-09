package com.zhiyou100.gym.mapper;

import com.zhiyou100.gym.pojo.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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


    public Integer findCount();
    public List<Schedule> findByPage(@Param("start") int start, @Param("size") int size);
    public Integer findCountD(Integer scheduleCoachNum);
    public List<Schedule> findDByPage(@Param("start") int start, @Param("size") int size,Integer scheduleCoachNum);

}
