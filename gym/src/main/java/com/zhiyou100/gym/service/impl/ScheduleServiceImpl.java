package com.zhiyou100.gym.service.impl;

import com.zhiyou100.gym.mapper.ScheduleMapper;
import com.zhiyou100.gym.pojo.Schedule;
import com.zhiyou100.gym.service.ScheduleService;
import com.zhiyou100.gym.util.NumTimeNowUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> findAll() {
        return scheduleMapper.findAll();
    }

    @Override
    public Schedule findById(Integer scheduleId) {
        return scheduleMapper.findById(scheduleId);
    }

    @Override
    public void deleteById(Integer scheduleId) {
        scheduleMapper.deleteById(scheduleId);
    }

    @Override
    public String add(Schedule schedule) {
        if (scheduleMapper.findHave(schedule.getScheduleCoachNum())!=null){
            return "今日已添加日程";
        }
        schedule.setScheduleNum(NumTimeNowUtil.NowDate());
        scheduleMapper.add(schedule);
        return "成功";
    }

    @Override
    public void update(Schedule schedule) {
        scheduleMapper.update(schedule);
    }

    @Override
    public List<Schedule> findNum(Integer scheduleCoachNum) {
        return scheduleMapper.findNum(scheduleCoachNum);
    }
}
